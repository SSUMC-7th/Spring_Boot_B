package umc.spring.service.MemberMisisonService;

import org.springframework.data.domain.Page;
import umc.spring.domain.Mission;

public interface MemberMissionQueryService {
    Page<Mission> getInProgressMissions(Long memberId, Integer page);
}
