package umc.spring.study.converter;

import umc.spring.study.domain.Mission;
import umc.spring.study.domain.Store;
import umc.spring.study.dto.missionDTO.MissionRequestDTO;
import umc.spring.study.dto.missionDTO.MissionResponseDTO;

public class MissionConverter {

    public static Mission toEntity(MissionRequestDTO requestDto, Store store) {
        return Mission.builder()
                .reward(requestDto.getReward())
                .deadLine(requestDto.getDeadLine())
                .missionSpec(requestDto.getMissionSpec())
                .store(store)
                .build();
    }

    public static MissionResponseDTO toResponseDto(Mission mission) {
        return MissionResponseDTO.builder()
                .id(mission.getId())
                .reward(mission.getReward())
                .deadLine(mission.getDeadLine())
                .missionSpec(mission.getMissionSpec())
                .storeName(mission.getStore().getName())
                .build();
    }
}
