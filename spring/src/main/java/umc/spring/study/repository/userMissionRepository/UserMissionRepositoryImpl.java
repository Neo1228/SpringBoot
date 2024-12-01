package umc.spring.study.repository.userMissionRepository;

import com.querydsl.core.types.Projections;
import com.querydsl.core.types.dsl.CaseBuilder;
import com.querydsl.jpa.JPAExpressions;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import umc.spring.study.domain.QRegion;
import umc.spring.study.domain.QStore;
import umc.spring.study.domain.enums.MissionStatus;
import umc.spring.study.dto.MissionDto;
import umc.spring.study.domain.mapping.QMemberMission;
import umc.spring.study.domain.QMission;

import java.util.List;

public class UserMissionRepositoryImpl implements UserMissionRepositoryCustom {

    @Autowired
    private JPAQueryFactory queryFactory;

    @Override
    public Page<MissionDto> findUserMissions(Long userId, Pageable pageable) {
        QMemberMission memberMission = QMemberMission.memberMission;
        QMission mission = QMission.mission;

        List<MissionDto> results = queryFactory
                .select(Projections.constructor(MissionDto.class,
                        mission.id,
                        mission.missionSpec.as("name"),  // 미션 이름
                        memberMission.status.stringValue(), // 상태
                        mission.reward // 보상 포인트
                ))
                .from(memberMission)
                .join(memberMission.mission, mission)
                .where(memberMission.member.id.eq(userId)
                        .and(memberMission.status.in(MissionStatus.CHALLENGING, MissionStatus.COMPLETE)))
                .orderBy(
                        new CaseBuilder()
                                .when(memberMission.status.eq(MissionStatus.CHALLENGING)).then(0)
                                .otherwise(1).asc(),
                        memberMission.updatedAt.desc())
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize())
                .fetch();

        long total = queryFactory
                .select(memberMission.count())
                .from(memberMission)
                .where(memberMission.member.id.eq(userId)
                        .and(memberMission.status.in(MissionStatus.CHALLENGING, MissionStatus.COMPLETE)))
                .fetchOne();

        return new PageImpl<>(results, pageable, total);
    }

    @Override
    public Page<MissionDto> findAvailableMissions(Long userId, Long selectedRegionId, Pageable pageable) {
        QMission mission = QMission.mission;
        QStore store = QStore.store;
        QRegion region = new QRegion("region");
        QMemberMission memberMission = QMemberMission.memberMission;

        List<MissionDto> results = queryFactory
                .select(Projections.constructor(MissionDto.class,
                        mission.id,
                        mission.missionSpec.as("name"),  // 미션 이름
                        mission.reward,                  // 보상 포인트
                        store.name.as("storeName")       // 매장 이름
                ))
                .from(mission)
                .join(mission.store, store)
                .join(store.region, region)
                .where(region.id.eq(selectedRegionId)
                        .and(mission.id.notIn(
                                JPAExpressions.select(memberMission.mission.id)
                                        .from(memberMission)
                                        .where(memberMission.member.id.eq(userId)
                                                .and(memberMission.status.in(MissionStatus.CHALLENGING, MissionStatus.COMPLETE)))
                        ))
                )
                .orderBy(mission.createdAt.desc())
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize())
                .fetch();

        long total = queryFactory
                .select(mission.count())
                .from(mission)
                .join(mission.store, store)
                .join(store.region, region)
                .where(region.id.eq(selectedRegionId)
                        .and(mission.id.notIn(
                                JPAExpressions.select(memberMission.mission.id)
                                        .from(memberMission)
                                        .where(memberMission.member.id.eq(userId)
                                                .and(memberMission.status.in(MissionStatus.CHALLENGING, MissionStatus.COMPLETE)))
                        ))
                )
                .fetchOne();

        return new PageImpl<>(results, pageable, total);
    }
}
