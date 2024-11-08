package umc.spring.repository.MemberMissionRepository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import umc.spring.domain.mapping.MemberMission;

public interface MemberMissionRepositoryCustom {
    Page<MemberMission> findMissionsByMemberAndStatus(Long memberId, String status, Long cursor, Pageable pageable);
}
