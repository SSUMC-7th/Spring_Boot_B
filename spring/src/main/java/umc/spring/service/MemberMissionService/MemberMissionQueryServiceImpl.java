package umc.spring.service.MemberMissionService;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.spring.domain.mapping.MemberMission;
import umc.spring.repository.MemberMissionRepository.MemberMissionRepository;

@Service
@Transactional(readOnly = true)
public class MemberMissionQueryServiceImpl implements MemberMissionQueryService {

    private final MemberMissionRepository memberMissionRepository;

    public MemberMissionQueryServiceImpl(MemberMissionRepository memberMissionRepository) {
        this.memberMissionRepository = memberMissionRepository;
    }

    @Override
    public Page<MemberMission> getMissionsByMemberAndStatus(Long memberId, String status, Long cursor, Pageable pageable) {
        return memberMissionRepository.findMemberMissionsByMemberAndStatus(memberId, status, cursor, pageable);
    }
}
