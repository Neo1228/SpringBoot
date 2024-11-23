package umc.spring.study.service.storeService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.spring.study.apiPayload.exception.handler.StoreHandler;
import umc.spring.study.converter.StoreConverter;
import umc.spring.study.domain.Region;
import umc.spring.study.domain.Store;
import umc.spring.study.dto.storeDTO.StoreRequestDTO;
import umc.spring.study.dto.storeDTO.StoreResponseDTO;
import umc.spring.study.repository.regionRepository.RegionRepository;
import umc.spring.study.repository.storeRepository.StoreRepository;
import umc.spring.study.apiPayload.code.status.ErrorStatus;

@Service
@RequiredArgsConstructor
public class StoreCommandServiceImpl implements StoreCommandService {

    private final StoreRepository storeRepository;
    private final RegionRepository regionRepository;

    @Override
    @Transactional
    public StoreResponseDTO addStore(StoreRequestDTO requestDto) {
        // Region 조회 (존재하지 않으면 예외 발생)
        Region region = regionRepository.findById(requestDto.getRegionId())
                .orElseThrow(() -> new StoreHandler(ErrorStatus.REGION_NOT_FOUND));

        // DTO를 Entity로 변환 후 저장
        Store store = StoreConverter.toEntity(requestDto, region);
        Store savedStore = storeRepository.save(store);

        // Entity를 Response DTO로 변환 후 반환
        return StoreConverter.toResponseDto(savedStore);
    }
}
