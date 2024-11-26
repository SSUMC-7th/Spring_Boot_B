package umc.spring.service.memberMissionService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import umc.spring.converter.MemberMissionConverter;
import umc.spring.domain.Member;
import umc.spring.domain.Mission;
import umc.spring.domain.enums.MissionStatus;
import umc.spring.domain.mapping.MemberMission;
import umc.spring.dto.memberMissionDTO.MemberMissionRequestDTO;
import umc.spring.repository.MemberMissionRepository;
import umc.spring.repository.MemberRepository;
import umc.spring.repository.MissionRepository;

@Service
@RequiredArgsConstructor
public class MemberMissionServiceImpl implements MemberMissionService{
    private final MemberRepository memberRepository;
    private final MemberMissionRepository memberMissionRepository;
    private final MissionRepository missionRepository;


    @Override
    public MemberMission addMemberMission(MemberMissionRequestDTO.AddMemberMissionDTO request){
        Member member = memberRepository.findById(request.getMemberId())
                .orElseThrow();
        Mission mission = missionRepository.findById(request.getMissionId())
                .orElseThrow();
        MemberMission newMemberMission = MemberMissionConverter.toMemberMission(member, mission, MissionStatus.CHALLENGING);
        memberMissionRepository.save(newMemberMission);
        return newMemberMission;
    }
}
