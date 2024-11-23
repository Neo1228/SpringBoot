package umc.spring.study.service.reviewService;

import jakarta.validation.Valid;
import umc.spring.study.dto.reviewDTO.ReviewRequestDTO;
import umc.spring.study.dto.reviewDTO.ReviewResponseDTO;

public interface ReviewCommandService {
    ReviewResponseDTO addReview(@Valid ReviewRequestDTO requestDto);
}
