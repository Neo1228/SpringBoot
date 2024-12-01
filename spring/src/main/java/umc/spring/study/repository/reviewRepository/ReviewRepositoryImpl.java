package umc.spring.study.repository.reviewRepository;

import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import umc.spring.study.domain.QReview;

import java.time.LocalDateTime;

@Repository
@RequiredArgsConstructor
public class ReviewRepositoryImpl implements ReviewRepositoryCustom {

    private final JPAQueryFactory queryFactory;

    @Override
    @Transactional
    public void saveReview(Long memberId, Long parentReviewId, Long title, Float score) {
        QReview review = QReview.review;

        queryFactory
                .insert(review)
                .set(review.member.id, memberId)
                .set(review.parentReview.id, parentReviewId)
                .set(review.title, title)
                .set(review.score, score)
                .set(review.createdAt, LocalDateTime.now())
                .execute();
    }
}
