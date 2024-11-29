package umc.spring.service.MissionService;

import org.springframework.data.domain.Page;
import umc.spring.domain.Mission;

import java.util.List;

public interface MissionQueryService {
    List<Mission> getAvailableMissions(String regionName, Long cursor, Long memberId);
    Page<Mission> getMissionsByStore(Long storeId, Integer page);
}
