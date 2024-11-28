package umc.spring.converter;

import umc.spring.domain.Member;
import umc.spring.domain.Mission;
import umc.spring.domain.enums.MissionStatus;
import umc.spring.domain.mapping.MemberMission;
import umc.spring.dto.memberMissionDTO.MemberMissionResponseDTO;

public class MemberMissionConverter {
    public static MemberMission toMemberMission(Member member, Mission mission, MissionStatus missionStatus) {
        return MemberMission.builder()
                .member(member)
                .mission(mission)
                .status(missionStatus)
                .build();
    }

    public static MemberMissionResponseDTO.MemberMissionIdDTO toMemberMissionIdDTO(MemberMission memberMission) {
        return MemberMissionResponseDTO.MemberMissionIdDTO.builder()
                .memberMissionId(memberMission.getId())
                .build();
    }
}
