package umc.spring.study.service.userMissionService;

import umc.spring.study.dto.missionDTO.MissionResponseDTO;
import umc.spring.study.dto.userMissionDTO.UserMissionRequestDTO;
import umc.spring.study.dto.userMissionDTO.UserMissionResponseDTO;

public interface UserMissionService {
    UserMissionResponseDTO addUserMission(UserMissionRequestDTO requestDto);

    MissionResponseDTO completeMission(Long memberMissionId);
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import umc.spring.study.dto.MissionDto;
import umc.spring.study.repository.userMissionRepository.UserMissionRepository;

@Service
public class UserMissionService {
    @Autowired
    private UserMissionRepository userMissionRepository;

    public Page<MissionDto> getUserMissions(Long userId, Pageable pageable) {
        return userMissionRepository.findUserMissions(userId, pageable);
    }
}
