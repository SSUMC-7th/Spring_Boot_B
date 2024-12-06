package umc.spring.converter;

import org.springframework.data.domain.Page;
import umc.spring.domain.Member;
import umc.spring.domain.Mission;
import umc.spring.domain.enums.Gender;
import umc.spring.web.dto.MemberDTO.MemberRequestDTO;
import umc.spring.web.dto.MemberDTO.MemberResponseDTO;
import umc.spring.web.dto.MissionDTO.MissionResponseDTO;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class MemberConverter {

    public static MemberResponseDTO.JoinResultDTO toJoinResultDTO(Member member) {
        return MemberResponseDTO.JoinResultDTO.builder()
                .memberId(member.getId())
                .createdAt(LocalDateTime.now())
                .build();
    }

    // MemberRequestDTO -> Member Entity
    public static Member toMember(MemberRequestDTO.JoinDTO request) {

        Gender gender = null;

        switch (request.getGender()) {
            case 1 :
                gender = Gender.MALE;
                break;
            case 2 :
                gender = Gender.FEMALE;
                break;
            case 3 :
                gender = Gender.NONE;
                break;
        }

        return Member.builder()
                .address(request.getAddress())
                .email(request.getEmail())
                .password(request.getPassword())
                .specAddress(request.getSpecAddress())
                .gender(gender)
                .name(request.getName())
                .memberPreferList(new ArrayList<>())
                .role(request.getRole())
                .build();
    }

    public static MissionResponseDTO.MissionPreviewDTO missionPreviewDTO(Mission mission) {
        return MissionResponseDTO.MissionPreviewDTO.builder()
                .deadline(mission.getDeadline())
                .mission_spec(mission.getMission_spec())
                .reward(mission.getReward())
                .build();
    }

    public static MissionResponseDTO.MissionPreviewListDTO missionPreviewListDTO(Page<Mission> missionList) {
        List<MissionResponseDTO.MissionPreviewDTO> missionPreviewDTOList = missionList.stream()
                .map(MemberConverter::missionPreviewDTO).collect(Collectors.toList());

        return MissionResponseDTO.MissionPreviewListDTO.builder()
                .isLast(missionList.isLast())
                .isFirst(missionList.isFirst())
                .totalPage(missionList.getTotalPages())
                .totalElements(missionList.getTotalElements())
                .listSize(missionPreviewDTOList.size())
                .missionList(missionPreviewDTOList)
                .build();
    }
}
