package umc.spring.handler.resolver;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import umc.spring.handler.annotation.CheckPage;

public class CheckPageValidator implements ConstraintValidator<CheckPage, Integer> {

    @Override
    public boolean isValid(Integer page, ConstraintValidatorContext context) {
        if (page == null || page < 1) {
            return false;
        }
        return true;
    }

    @Override
    public void initialize(CheckPage constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }
}

