package umc.spring.study.converter;

import umc.spring.study.domain.Member;
import umc.spring.study.domain.Review;
import umc.spring.study.domain.Store;
import umc.spring.study.dto.reviewDTO.ReviewRequestDTO;
import umc.spring.study.dto.reviewDTO.ReviewResponseDTO;

public class ReviewConverter {

    public static Review toEntity(ReviewRequestDTO requestDto, Member member, Store store) {
        return Review.builder()
                .title(requestDto.getTitle())
                .score(requestDto.getScore())
                .member(member)
                .parentReview(null) // 새로 작성되는 리뷰는 기본적으로 부모가 없음
                .build();
    }

    public static ReviewResponseDTO toResponseDto(Review review) {
        return ReviewResponseDTO.builder()
                .id(review.getId())
                .title(review.getTitle())
                .score(review.getScore())
                .memberName(review.getMember().getName())
                .storeName(review.getMember().getAddress()) // 가게의 주소를 응답 데이터로
                .build();
    }
}
