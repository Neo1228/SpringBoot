package umc.spring.study.repository.reviewRepository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import umc.spring.study.domain.Review;
import umc.spring.study.domain.Store;

public interface ReviewRepository extends JpaRepository<Review, Long> {

    Page<Review> findAllByStore(Store store, PageRequest pageRequest);

    Page<Review> findAllByMemberId(Long memberId, PageRequest pageRequest);
import org.springframework.data.jpa.repository.JpaRepository;
import umc.spring.study.domain.Review;

public interface ReviewRepository extends JpaRepository<Review, Long> {
    // 추가적인 커스텀 메서드를 작성할 수 있습니다.
}
