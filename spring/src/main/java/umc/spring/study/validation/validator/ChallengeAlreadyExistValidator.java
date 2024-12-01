package umc.spring.study.validation.validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import umc.spring.study.repository.userMissionRepository.UserMissionRepository;
import umc.spring.study.validation.annotation.NotChallenged;

@Component
@RequiredArgsConstructor
public class ChallengeAlreadyExistValidator implements ConstraintValidator<NotChallenged, Long> {

    private final UserMissionRepository userMissionRepository;

    @Override
    public boolean isValid(Long memberId, ConstraintValidatorContext context) {
        if (memberId == null) {
            return false;
        }

        // 미션이 이미 도전 중인지 확인
        return !userMissionRepository.findByMemberIdAndMissionId(memberId, memberId).isPresent();
    }
}
