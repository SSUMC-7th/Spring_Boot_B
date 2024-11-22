package umc.spring.validation.validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;
import umc.spring.repository.MemberMissionRepository.MemberMissionRepository;
import umc.spring.repository.MemberMissionRepository.MemberMissionRepositoryCustom;
import umc.spring.validation.annotation.ProgressMemberMission;
import umc.spring.web.dto.MemberMissionRequestDTO;

@Component
@RequiredArgsConstructor
public class MemberMissionProgressedValidator implements ConstraintValidator<ProgressMemberMission, MemberMissionRequestDTO.CreateMemberMissionDto> {

    private final MemberMissionRepository memberMissionRepository;

    @Override
    public boolean isValid(MemberMissionRequestDTO.CreateMemberMissionDto request, ConstraintValidatorContext context) {
        // Check if there is any mission in progress for the given member
        boolean hasProgressMission = memberMissionRepository
                .findMissionsByMemberAndStatus(request.getMemberId(), "IN_PROGRESS", null, Pageable.unpaged())
                .getTotalElements() > 0;

        return !hasProgressMission; // Return true if no mission is in progress
    }
}
