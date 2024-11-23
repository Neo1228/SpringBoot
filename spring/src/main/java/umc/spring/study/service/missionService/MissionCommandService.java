package umc.spring.study.service.missionService;

import umc.spring.study.dto.missionDTO.MissionRequestDTO;
import umc.spring.study.dto.missionDTO.MissionResponseDTO;

public interface MissionCommandService {
    MissionResponseDTO addMission(MissionRequestDTO requestDto);
}
