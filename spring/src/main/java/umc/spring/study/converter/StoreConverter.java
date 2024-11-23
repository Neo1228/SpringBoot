package umc.spring.study.converter;

import umc.spring.study.domain.Region;
import umc.spring.study.domain.Store;
import umc.spring.study.dto.storeDTO.StoreRequestDTO;
import umc.spring.study.dto.storeDTO.StoreResponseDTO;

public class StoreConverter {

    public static Store toEntity(StoreRequestDTO requestDto, Region region) {
        return Store.builder()
                .name(requestDto.getName())
                .address(requestDto.getAddress())
                .region(region)
                .score(0.0f)
                .build();
    }

    public static StoreResponseDTO toResponseDto(Store store) {
        return StoreResponseDTO.builder()
                .id(store.getId())
                .name(store.getName())
                .address(store.getAddress())
                .score(store.getScore())
                .regionName(store.getRegion() != null ? store.getRegion().getName() : "N/A")
                .build();
    }

}
