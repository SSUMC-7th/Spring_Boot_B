package umc.spring.service.memberMissionService;

import org.springframework.data.domain.Page;
import umc.spring.domain.Mission;
import umc.spring.domain.enums.MissionStatus;
import umc.spring.domain.mapping.MemberMission;
import umc.spring.dto.memberMissionDTO.MemberMissionRequestDTO;

public interface MemberMissionService {
    MemberMission addMemberMission(MemberMissionRequestDTO.AddMemberMissionDTO request);
    Page<MemberMission> getMissionListByMemberId(Long memberId, Integer page, MissionStatus status);
    MemberMission changeToCompleteMission(MemberMissionRequestDTO.AddMemberMissionDTO request);
}
