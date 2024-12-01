package umc.spring.study.service.userMissionService;

import umc.spring.study.dto.missionDTO.MissionResponseDTO;
import umc.spring.study.dto.userMissionDTO.UserMissionRequestDTO;
import umc.spring.study.dto.userMissionDTO.UserMissionResponseDTO;

public interface UserMissionService {
    UserMissionResponseDTO addUserMission(UserMissionRequestDTO requestDto);

    MissionResponseDTO completeMission(Long memberMissionId);
}
