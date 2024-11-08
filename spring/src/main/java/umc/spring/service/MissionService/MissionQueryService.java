package umc.spring.service.MissionService;

import umc.spring.domain.Mission;

import java.util.List;

public interface MissionQueryService {
    List<Mission> getAvailableMissions(String regionName, Long cursor, Long memberId);
}
