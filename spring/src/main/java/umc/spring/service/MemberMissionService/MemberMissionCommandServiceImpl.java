package umc.spring.service.MemberMissionService;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import umc.spring.domain.Member;
import umc.spring.domain.Mission;
import umc.spring.domain.enums.MissionStatus;
import umc.spring.domain.mapping.MemberMission;
import umc.spring.repository.MemberRepository.MemberRepository;
import umc.spring.repository.MissionRepository.MissionRepository;
import umc.spring.repository.MemberMissionRepository.MemberMissionRepository;
import umc.spring.web.dto.MemberMissionRequestDTO;

@Service
@RequiredArgsConstructor
public class MemberMissionCommandServiceImpl implements MemberMissionCommandService {

    private final MemberMissionRepository memberMissionRepository;
    private final MissionRepository missionRepository;
    private final MemberRepository memberRepository;

    @Transactional
    public MemberMission addMemberMission(MemberMissionRequestDTO.CreateMemberMissionDto request) {
        Member member = memberRepository.findById(request.getMemberId())
                .orElseThrow(() -> new IllegalArgumentException("Member not found"));
        Mission mission = missionRepository.findById(request.getMissionId())
                .orElseThrow(() -> new IllegalArgumentException("Mission not found"));

        // 동일한 멤버와 미션으로 매핑된 MemberMission 엔티티가 있는지 확인
        MemberMission existingMemberMission = memberMissionRepository.findByMemberAndMission(member, mission);

        if (existingMemberMission != null) {
            // 이미 존재하는 경우 상태를 IN_PROGRESS로 변경
            existingMemberMission.setStatus(MissionStatus.IN_PROGRESS);
            return existingMemberMission;
        } else {
            // 존재하지 않는 경우 새로운 MemberMission 생성
            MemberMission newMemberMission = MemberMission.builder()
                    .member(member)
                    .mission(mission)
                    .status(MissionStatus.IN_PROGRESS)
                    .build();

            return memberMissionRepository.save(newMemberMission);
        }
    }
}
