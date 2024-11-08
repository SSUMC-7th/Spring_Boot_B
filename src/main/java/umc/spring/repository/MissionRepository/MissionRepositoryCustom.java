package umc.spring.repository.MissionRepository;

import umc.spring.domain.Mission;

import java.util.List;

public interface MissionRepositoryCustom {
    List<Mission> dynamicQueryFindInProgressMissionsByMemberWithCursor(Long memberId, Long cursorId, int limit);
}
