package umc.spring.study.repository.userMissionRepository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import umc.spring.study.dto.MissionDto;

public interface UserMissionRepositoryCustom {
    Page<MissionDto> findUserMissions(Long userId, Pageable pageable);
    Page<MissionDto> findAvailableMissions(Long userId, Long selectedRegionId, Pageable pageable);
}
