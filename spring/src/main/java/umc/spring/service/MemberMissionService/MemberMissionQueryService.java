package umc.spring.service.MemberMissionService;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import umc.spring.domain.mapping.MemberMission;

public interface MemberMissionQueryService {
    Page<MemberMission> getMissionsByMemberAndStatus(Long memberId, String status, Long cursor, Pageable pageable);
}
