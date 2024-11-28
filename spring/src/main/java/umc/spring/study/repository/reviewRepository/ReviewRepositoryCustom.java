package umc.spring.study.repository.reviewRepository;

public interface ReviewRepositoryCustom {
    void saveReview(Long memberId, Long parentReviewId, Long title, Float score);
}
