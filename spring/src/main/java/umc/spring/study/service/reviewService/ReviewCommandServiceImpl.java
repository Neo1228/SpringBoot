package umc.spring.study.service.reviewService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.spring.study.apiPayload.exception.GeneralException;
import umc.spring.study.converter.ReviewConverter;
import umc.spring.study.domain.Member;
import umc.spring.study.domain.Review;
import umc.spring.study.domain.Store;
import umc.spring.study.dto.reviewDTO.ReviewRequestDTO;
import umc.spring.study.dto.reviewDTO.ReviewResponseDTO;
import umc.spring.study.repository.memberRepository.MemberRepository;
import umc.spring.study.repository.reviewRepository.ReviewRepository;
import umc.spring.study.repository.storeRepository.StoreRepository;
import umc.spring.study.apiPayload.code.status.ErrorStatus;

@Service
@RequiredArgsConstructor
public class ReviewCommandServiceImpl implements ReviewCommandService {

    private final ReviewRepository reviewRepository;
    private final MemberRepository memberRepository;
    private final StoreRepository storeRepository;

    @Override
    @Transactional
    public ReviewResponseDTO addReview(ReviewRequestDTO requestDto) {
        // Member 조회 (존재하지 않으면 예외 발생)
        Member member = memberRepository.findById(requestDto.getMemberId())
                .orElseThrow(() -> new GeneralException(ErrorStatus.MEMBER_NOT_FOUND));

        // Store 조회 (존재하지 않으면 예외 발생)
        Store store = storeRepository.findById(requestDto.getStoreId())
                .orElseThrow(() -> new GeneralException(ErrorStatus.STORE_NOT_FOUND));

        // DTO를 Entity로 변환 후 저장
        Review review = ReviewConverter.toEntity(requestDto, member, store);
        Review savedReview = reviewRepository.save(review);

        // Entity를 Response DTO로 변환 후 반환
        return ReviewConverter.toResponseDto(savedReview);
    }
}
