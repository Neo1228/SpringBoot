package umc.spring.study.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;
import umc.spring.study.apiPayload.ApiResponse;
import umc.spring.study.converter.ReviewConverter;
import umc.spring.study.domain.Review;
import umc.spring.study.dto.reviewDTO.ReviewRequestDTO;
import umc.spring.study.dto.reviewDTO.ReviewResponseDTO;
import umc.spring.study.repository.reviewRepository.ReviewRepository;
import umc.spring.study.service.reviewService.ReviewCommandService;
import umc.spring.study.validation.annotation.PageNumber;

@RestController
@RequiredArgsConstructor
@RequestMapping("/reviews")
public class ReviewRestController {

    private final ReviewCommandService reviewCommandService;

    private final ReviewRepository reviewRepository;

    @PostMapping("/")
    public ApiResponse<ReviewResponseDTO> addReview(@RequestBody @Valid ReviewRequestDTO requestDto) {
        // 리뷰 추가 비즈니스 로직 호출
        ReviewResponseDTO responseDto = reviewCommandService.addReview(requestDto);

        // 응답 데이터 생성
        return ApiResponse.onSuccess(responseDto);
    }

    @GetMapping("/my-reviews")
    public ApiResponse<ReviewResponseDTO.ReviewListDTO> getMyReviews(
            @RequestParam @PageNumber Integer page,
            @RequestParam Long memberId
    ) {
        Page<Review> reviewPage = reviewRepository.findAllByMemberId(memberId, PageRequest.of(page, 10));
        ReviewResponseDTO.ReviewListDTO reviewListDTO = ReviewConverter.toReviewListDTO(reviewPage);
        return ApiResponse.onSuccess(reviewListDTO);
    }

}
