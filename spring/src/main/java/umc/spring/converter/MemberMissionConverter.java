package umc.spring.converter;

import org.springframework.data.domain.Page;
import umc.spring.domain.Member;
import umc.spring.domain.Mission;
import umc.spring.domain.enums.MissionStatus;
import umc.spring.domain.mapping.MemberMission;
import umc.spring.dto.memberMissionDTO.MemberMissionResponseDTO;
import umc.spring.dto.missionDTO.MissionResponseDTO;

import java.util.List;
import java.util.stream.Collectors;

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

    public static MemberMissionResponseDTO.MemberMissionPreViewDTO missionPreViewDTO(MemberMission mission){
        return MemberMissionResponseDTO.MemberMissionPreViewDTO.builder()
                .missionPoint(mission.getMission().getMissionPoint())
                .content(mission.getMission().getContent())
                .deadline(mission.getMission().getDeadline())
                .restaurantName(mission.getMission().getRestaurant().getName())
                .build();
    }
    public static MemberMissionResponseDTO.MemberMissionListDTO memberMissionListDTO(Page<MemberMission> missionList){

        List<MemberMissionResponseDTO.MemberMissionPreViewDTO> memberMissionPreViewDTOList = missionList.stream()
                .map(MemberMissionConverter::missionPreViewDTO).collect(Collectors.toList());

        return MemberMissionResponseDTO.MemberMissionListDTO.builder()
                .isLast(missionList.isLast())
                .isFirst(missionList.isFirst())
                .totalPage(missionList.getTotalPages())
                .totalElements(missionList.getTotalElements())
                .listSize(memberMissionPreViewDTOList.size())
                .missionList(memberMissionPreViewDTOList)
                .build();
    }
}
