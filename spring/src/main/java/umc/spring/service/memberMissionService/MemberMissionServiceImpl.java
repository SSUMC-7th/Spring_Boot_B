package umc.spring.service.memberMissionService;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import umc.spring.apiPayload.code.status.ErrorStatus;
import umc.spring.apiPayload.exception.GeneralException;
import umc.spring.converter.MemberMissionConverter;
import umc.spring.domain.Member;
import umc.spring.domain.Mission;
import umc.spring.domain.Restaurant;
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

    @Override
    public Page<MemberMission> getMissionListByMemberId(Long memberId, Integer page, MissionStatus status){
        Member member = memberRepository.findById(memberId)
                .orElseThrow();

        return memberMissionRepository.findAllByMemberAndStatus(member, status, PageRequest.of(page, 10));
    }

    @Override
    public MemberMission changeToCompleteMission(MemberMissionRequestDTO.AddMemberMissionDTO request) {
        Member member = memberRepository.findById(request.getMemberId())
                .orElseThrow(() -> new GeneralException(ErrorStatus.MEMBER_NOT_FOUND));
        Mission mission = missionRepository.findById(request.getMissionId())
                .orElseThrow(() -> new GeneralException(ErrorStatus.MISSION_NOT_FOUND));
        MemberMission memberMission = memberMissionRepository.findByMemberAndStatusAndMission(member, MissionStatus.CHALLENGING, mission);
        if (memberMission == null) {
            throw new GeneralException(ErrorStatus.MEMBER_MISSION_NOT_FOUND);
        }

        memberMission.completeMission();

        return memberMissionRepository.save(memberMission);
    }
}
