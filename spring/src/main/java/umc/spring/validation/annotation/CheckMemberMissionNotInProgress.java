package umc.spring.validation.annotation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import umc.spring.validation.validator.MemberMissionNotInProgressValidator;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = MemberMissionNotInProgressValidator.class)
@Target({ElementType.METHOD, ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
public @interface CheckMemberMissionNotInProgress {

    String message() default "해당 미션은 진행중이지 않습니다.";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};}