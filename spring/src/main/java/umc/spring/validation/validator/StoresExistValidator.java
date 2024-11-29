package umc.spring.validation.validator;


import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import umc.spring.apiPayload.code.status.ErrorStatus;
import umc.spring.repository.StoreRepository.StoreRepository;
import umc.spring.validation.annotation.ExistStores;

import java.util.List;

@Component
@RequiredArgsConstructor
public class StoresExistValidator implements ConstraintValidator<ExistStores, Long> {

    private final StoreRepository storeRepository;

    @Override
    public void initialize(ExistStores constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(Long value, ConstraintValidatorContext context) {
        if (value == null) {
            return true; // null인 경우 유효성 검증을 통과하도록 설정 (필수 값 검증은 다른 어노테이션 사용)
        }

        boolean exists = storeRepository.existsById(value);
        if (!exists) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate("해당 식당이 존재하지 않습니다.")
                    .addConstraintViolation();
        }

        return exists;
    }
}
