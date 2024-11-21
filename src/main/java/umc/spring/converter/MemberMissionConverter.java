package umc.spring.converter;

import umc.spring.domain.Member;
import umc.spring.domain.Mission;
import umc.spring.domain.enums.MissionStatus;
import umc.spring.domain.mapping.MemberMission;
import umc.spring.web.dto.MemberMissionRequestDTO;
import umc.spring.web.dto.MemberMissionResponseDTO;
import umc.spring.web.dto.MemberRequestDTO;

public class MemberMissionConverter {

    public static MemberMission toMemberMission(Member member, Mission mission) {
        return MemberMission.builder()
                .member(member)
                .mission(mission)
                .status(MissionStatus.CHALLENGING)
                .build();
    }

    public static MemberMissionResponseDTO.MissionChallengeResponseDTO toMissionChallengeResponseDTO(MemberMission memberMission) {
        return MemberMissionResponseDTO.MissionChallengeResponseDTO.builder()
                .memberMissionId(memberMission.getId())
                .memberId(memberMission.getMember().getId())
                .missionId(memberMission.getMission().getId())
                .status(memberMission.getStatus().name())
                .build();
    }
}
