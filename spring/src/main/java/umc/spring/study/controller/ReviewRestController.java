package umc.spring.study.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import umc.spring.study.apiPayload.ApiResponse;
import umc.spring.study.dto.reviewDTO.ReviewRequestDTO;
import umc.spring.study.dto.reviewDTO.ReviewResponseDTO;
import umc.spring.study.service.reviewService.ReviewCommandService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/reviews")
public class ReviewRestController {

    private final ReviewCommandService reviewCommandService;

    @PostMapping("/")
    public ApiResponse<ReviewResponseDTO> addReview(@RequestBody @Valid ReviewRequestDTO requestDto) {
        // 리뷰 추가 비즈니스 로직 호출
        ReviewResponseDTO responseDto = reviewCommandService.addReview(requestDto);

        // 응답 데이터 생성
        return ApiResponse.onSuccess(responseDto);
    }
}
