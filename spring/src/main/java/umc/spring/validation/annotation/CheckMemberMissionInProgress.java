package umc.spring.validation.annotation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import umc.spring.validation.validator.MemberMissionInProgressValidator;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = MemberMissionInProgressValidator.class)
@Target({ElementType.METHOD, ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
public @interface CheckMemberMissionInProgress {

    String message() default "해당 미션은 이미 진행중입니다.";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};}