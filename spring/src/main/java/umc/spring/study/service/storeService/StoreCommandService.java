package umc.spring.study.service.storeService;

import umc.spring.study.dto.storeDTO.StoreRequestDTO;
import umc.spring.study.dto.storeDTO.StoreResponseDTO;

public interface StoreCommandService {
    StoreResponseDTO addStore(StoreRequestDTO requestDto);
}
