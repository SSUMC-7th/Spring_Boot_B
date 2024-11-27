package umc.spring.service.MissionService;

import org.springframework.data.domain.Page;
import umc.spring.domain.Mission;
import umc.spring.domain.Store;

import java.util.List;
import java.util.Optional;

public interface MissionQueryService {
    Optional<Mission> findMission(Long id);
    List<Mission> findInProgressMissionsByMemberWithCursor(Long memberId, Long cursorId, int limit);

    Page<Mission> getMissionsByStore(Long storeId, Integer page);
}