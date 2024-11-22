package umc.spring.handler.annotation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import umc.spring.handler.resolver.RestaurantExistsValidator;

import java.lang.annotation.*;
@Documented
@Constraint(validatedBy = RestaurantExistsValidator.class)
@Target({ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
public @interface RestaurantExists {
    String message() default "존재하지 않는 가게입니다.";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
