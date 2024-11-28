package umc.spring.service.MemberMissionService;

import org.springframework.data.domain.Page;
import umc.spring.domain.Mission;

public interface MemberMissionService {
    Page<Mission> getChallengingMissions(Long memberId, Integer page);
}
