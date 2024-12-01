package umc.spring.study.repository.memberRepository;

import com.querydsl.jpa.impl.JPAQueryFactory;
import com.querydsl.core.types.Projections;
import lombok.RequiredArgsConstructor;
import umc.spring.study.domain.QMember;
import umc.spring.study.domain.QReview;
import umc.spring.study.domain.mapping.QMemberMission;
import umc.spring.study.dto.MyPageDto;
import umc.spring.study.domain.enums.MissionStatus;

@RequiredArgsConstructor
public class MemberRepositoryImpl implements MemberRepositoryCustom {

    private final JPAQueryFactory queryFactory;

    @Override
    public MyPageDto findMyPageInfo(Long userId) {
        QMember member = QMember.member;
        QReview review = QReview.review;
        QMemberMission memberMission = QMemberMission.memberMission;

        return queryFactory
                .select(Projections.constructor(MyPageDto.class,
                        member.id,
                        member.name.as("nickname"),
                        member.email,
                        member.point.as("totalPoints"),
                        review.count().as("reviewCount"),
                        memberMission.count().as("completedMissionsCount")
                ))
                .from(member)
                .leftJoin(review).on(review.member.id.eq(member.id))
                .leftJoin(memberMission).on(memberMission.member.id.eq(member.id)
                        .and(memberMission.status.eq(MissionStatus.COMPLETE)))
                .where(member.id.eq(userId))
                .fetchOne();
    }
}
