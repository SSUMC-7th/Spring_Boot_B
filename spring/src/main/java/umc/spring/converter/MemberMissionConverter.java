package umc.spring.converter;

import umc.spring.domain.Member;
import umc.spring.domain.Mission;
import umc.spring.domain.enums.MissionStatus;
import umc.spring.domain.mapping.MemberMission;
import umc.spring.web.dto.MemberMissionResponseDTO;

public class MemberMissionConverter {

    public static MemberMission toMemberMission(Member member, Mission mission) {
        return MemberMission.builder()
                .member(member)
                .mission(mission)
                .status(MissionStatus.NOT_STARTED)
                .build();
    }

    public static MemberMissionResponseDTO.CreateMemberMissionResultDto toCreateResultDto(MemberMission memberMission) {
        return MemberMissionResponseDTO.CreateMemberMissionResultDto.builder()
                .memberMissionId(memberMission.getId())
                .memberId(memberMission.getMember().getId())
                .missionId(memberMission.getMission().getId())
                .status(memberMission.getStatus().name())
                .build();
    }

    public static MemberMissionResponseDTO.UpdateMissionCompleteResultDTO toUpdateCompleteResultDTO(MemberMission memberMission) {
        return MemberMissionResponseDTO.UpdateMissionCompleteResultDTO.builder()
                .memberMissionId(memberMission.getId())
                .memberId(memberMission.getMember().getId())
                .missionId(memberMission.getMission().getId())
                .status(memberMission.getStatus().name())
                .build();
    }
}
