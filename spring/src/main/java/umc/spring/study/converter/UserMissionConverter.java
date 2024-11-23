package umc.spring.study.converter;

import umc.spring.study.domain.Member;
import umc.spring.study.domain.Mission;
import umc.spring.study.domain.enums.MissionStatus;
import umc.spring.study.domain.mapping.MemberMission;
import umc.spring.study.dto.userMissionDTO.UserMissionRequestDTO;
import umc.spring.study.dto.userMissionDTO.UserMissionResponseDTO;

public class UserMissionConverter {

    public static MemberMission toEntity(UserMissionRequestDTO requestDto, Member member, Mission mission) {
        return MemberMission.builder()
                .member(member)
                .mission(mission)
                .status(MissionStatus.CHALLENGING) // 기본 상태는 도전 중 (CHALLENGING)
                .build();
    }

    public static UserMissionResponseDTO toResponseDto(MemberMission memberMission) {
        return UserMissionResponseDTO.builder()
                .id(memberMission.getId())
                .memberId(memberMission.getMember().getId())
                .missionId(memberMission.getMission().getId())
                .missionSpec(memberMission.getMission().getMissionSpec())
                .build();
    }
}
