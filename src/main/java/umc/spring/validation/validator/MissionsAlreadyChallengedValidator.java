package umc.spring.validation.validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import umc.spring.apiPayload.code.status.ErrorStatus;
import umc.spring.service.MemberMissionService.MemberMissionServiceImpl;
import umc.spring.validation.annotation.AlreadyChallengeMissions;

@Component
@RequiredArgsConstructor
public class MissionsAlreadyChallengedValidator implements ConstraintValidator<AlreadyChallengeMissions, Long> {

    private final MemberMissionServiceImpl memberMissionService;

    @Override
    public void initialize(AlreadyChallengeMissions constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(Long value, ConstraintValidatorContext context) {
        boolean isValid = memberMissionService.doesMissionAlreadyNotChallenged(value);

        if (!isValid) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(ErrorStatus.MEMBER_MISSION_ALREADY_CHALLENGED.toString())
                    .addConstraintViolation();
        }

        return isValid;
    }
}
