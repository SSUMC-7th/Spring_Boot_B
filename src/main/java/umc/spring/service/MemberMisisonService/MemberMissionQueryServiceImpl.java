package umc.spring.service.MemberMisisonService;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import umc.spring.domain.Mission;
import umc.spring.domain.enums.MissionStatus;
import umc.spring.domain.mapping.MemberMission;
import umc.spring.repository.MemberRepository.MemberMissionRepository;

@Service
@RequiredArgsConstructor
public class MemberMissionQueryServiceImpl implements MemberMissionQueryService {

    private final MemberMissionRepository memberMissionRepository;

    @Override
    public Page<Mission> getInProgressMissions(Long memberId, Integer page) {
        Page<MemberMission> memberMissions = memberMissionRepository.findByMemberIdAndStatus(
                memberId,
                MissionStatus.CHALLENGING,
                PageRequest.of(page, 10)
        );

        return memberMissions.map(MemberMission::getMission);
    }
}
