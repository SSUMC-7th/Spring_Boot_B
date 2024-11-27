package umc.spring.validation.validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import umc.spring.apiPayload.code.status.ErrorStatus;
import umc.spring.domain.enums.MissionStatus;
import umc.spring.repository.MemberMissionRepository.MemberMissionRepository;
import umc.spring.validation.annotation.CheckMemberMissionNotInProgress;
import umc.spring.web.dto.MemberMissionRequestDTO;

@Component
@RequiredArgsConstructor
public class MemberMissionNotInProgressValidator implements ConstraintValidator<CheckMemberMissionNotInProgress, MemberMissionRequestDTO.UpdateMemberMissionCompleteDTO> {

    private final MemberMissionRepository memberMissionRepository;

    @Override
    public boolean isValid(MemberMissionRequestDTO.UpdateMemberMissionCompleteDTO request, ConstraintValidatorContext context) {
        // 멤버와 미션에 해당하는 MemberMission 존재 여부 및 상태 검사
        boolean isProgressMission = memberMissionRepository.findByMemberAndMission(request.getMemberId(), request.getMissionId())
                .map(memberMission -> memberMission.getStatus() == MissionStatus.IN_PROGRESS)
                .orElse(false);

        if (!isProgressMission) {
            // 기본 검증 메시지 비활성화
            context.disableDefaultConstraintViolation();
            // 커스텀 검증 메시지 설정
            context.buildConstraintViolationWithTemplate(ErrorStatus.MISSION_NOT_IN_PROGRESS.toString())
                    .addConstraintViolation();
        }

        // 진행 중인 미션일 경우 검증 통과
        return isProgressMission;
    }
}
