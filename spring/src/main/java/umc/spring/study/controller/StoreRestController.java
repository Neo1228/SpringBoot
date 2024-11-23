package umc.spring.study.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import umc.spring.study.apiPayload.ApiResponse;
import umc.spring.study.dto.storeDTO.StoreRequestDTO;
import umc.spring.study.dto.storeDTO.StoreResponseDTO;
import umc.spring.study.service.storeService.StoreCommandService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/stores")
public class StoreRestController {

    private final StoreCommandService storeCommandService;

    @PostMapping("/")
    public ApiResponse<StoreResponseDTO> addStore(@RequestBody @Valid StoreRequestDTO requestDto) {
        // Store 추가 비즈니스 로직 호출
        StoreResponseDTO responseDto = storeCommandService.addStore(requestDto);

        // 응답 데이터 생성
        return ApiResponse.onSuccess(responseDto);
    }
}
