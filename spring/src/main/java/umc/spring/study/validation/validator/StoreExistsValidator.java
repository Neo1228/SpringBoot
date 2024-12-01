package umc.spring.study.validation.validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import umc.spring.study.repository.storeRepository.StoreRepository;
import umc.spring.study.validation.annotation.ExistStore;

@Component
@RequiredArgsConstructor
public class StoreExistsValidator implements ConstraintValidator<ExistStore, Long> {

    private final StoreRepository storeRepository;

    @Override
    public boolean isValid(Long storeId, ConstraintValidatorContext context) {
        if (storeId == null) {
            return false;
        }
        return storeRepository.existsById(storeId);
    }
}
