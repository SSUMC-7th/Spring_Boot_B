package umc.spring.repository.MemberMissionRepository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import umc.spring.domain.Member;
import umc.spring.domain.Mission;
import umc.spring.domain.mapping.MemberMission;

public interface MemberMissionRepositoryCustom {
    Page<MemberMission> findMissionsByMemberAndStatus(Long memberId, String status, Long cursor, Pageable pageable);
    MemberMission findByMemberAndMission(Member member, Mission mission);
}
