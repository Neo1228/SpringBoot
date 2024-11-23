package umc.spring.study.service.missionService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.spring.study.apiPayload.exception.GeneralException;
import umc.spring.study.converter.MissionConverter;
import umc.spring.study.domain.Mission;
import umc.spring.study.domain.Store;
import umc.spring.study.dto.missionDTO.MissionRequestDTO;
import umc.spring.study.dto.missionDTO.MissionResponseDTO;
import umc.spring.study.repository.missionRepository.MissionRepository;
import umc.spring.study.repository.storeRepository.StoreRepository;
import umc.spring.study.apiPayload.code.status.ErrorStatus;

@Service
@RequiredArgsConstructor
public class MissionCommandServiceImpl implements MissionCommandService {

    private final MissionRepository missionRepository;
    private final StoreRepository storeRepository;

    @Override
    @Transactional
    public MissionResponseDTO addMission(MissionRequestDTO requestDto) {
        // Store 조회 (존재하지 않으면 예외 발생)
        Store store = storeRepository.findById(requestDto.getStoreId())
                .orElseThrow(() -> new GeneralException(ErrorStatus.STORE_NOT_FOUND));

        // DTO를 Entity로 변환 후 저장
        Mission mission = MissionConverter.toEntity(requestDto, store);
        Mission savedMission = missionRepository.save(mission);

        // Entity를 Response DTO로 변환 후 반환
        return MissionConverter.toResponseDto(savedMission);
    }
}
