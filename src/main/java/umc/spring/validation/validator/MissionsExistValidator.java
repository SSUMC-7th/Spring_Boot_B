package umc.spring.validation.validator;

import jakarta.validation.Constraint;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import umc.spring.apiPayload.code.status.ErrorStatus;
import umc.spring.service.MissionService.MissionServiceImpl;
import umc.spring.validation.annotation.ExistMissions;

@Component
@RequiredArgsConstructor
public class MissionsExistValidator implements ConstraintValidator<ExistMissions, Long> {

    private final MissionServiceImpl missionService;

    @Override
    public void initialize(ExistMissions constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    // 미션이 존재하지 않으면 erorr를 준다.
    @Override
    public boolean isValid(Long value, ConstraintValidatorContext context) {
        boolean isValid = missionService.doesMissionExist(value);

        if (!isValid) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(ErrorStatus.MISSION_NOT_FOUND.toString())
                    .addConstraintViolation();
        }

        return isValid;
    }
}
