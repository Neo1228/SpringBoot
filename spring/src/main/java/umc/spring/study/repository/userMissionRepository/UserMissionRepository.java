package umc.spring.study.repository.userMissionRepository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import umc.spring.study.domain.mapping.MemberMission;

import java.util.Optional;

public interface UserMissionRepository extends JpaRepository<MemberMission, Long> {
    Optional<MemberMission> findByMemberIdAndMissionId(Long memberId, Long missionId);

    Page<MemberMission> findAllByMemberId(Long memberId, PageRequest pageRequest);

import org.springframework.data.jpa.repository.JpaRepository;
import umc.spring.study.domain.mapping.MemberMission;

public interface UserMissionRepository extends JpaRepository<MemberMission, Long>, UserMissionRepositoryCustom {
    // 필요에 따라 추가 메서드 정의 가능
}
