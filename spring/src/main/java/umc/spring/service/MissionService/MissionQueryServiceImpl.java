package umc.spring.service.MissionService;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.spring.apiPayload.code.status.ErrorStatus;
import umc.spring.apiPayload.exception.handler.MemberHandler;
import umc.spring.apiPayload.exception.handler.MemberMissionHandler;
import umc.spring.apiPayload.exception.handler.StoreHandler;
import umc.spring.domain.Member;
import umc.spring.domain.Mission;
import umc.spring.domain.Store;
import umc.spring.domain.enums.MissionStatus;
import umc.spring.domain.mapping.MemberMission;
import umc.spring.repository.MemberMissionRepository.MemberMissionRepository;
import umc.spring.repository.MemberRepository.MemberRepository;
import umc.spring.repository.MissionRepository.MissionRepository;
import umc.spring.repository.StoreRepository.StoreRepository;

import java.util.List;

@Service
@Transactional
public class MissionQueryServiceImpl implements MissionQueryService {

    private final MissionRepository missionRepository;
    private final StoreRepository storeRepository;
    private final MemberRepository memberRepository;
    private final MemberMissionRepository missionMissionRepository;
    private final MemberMissionRepository memberMissionRepository;

    public MissionQueryServiceImpl(MissionRepository missionRepository, StoreRepository storeRepository, MemberRepository memberRepository, MemberMissionRepository missionMissionRepository, MemberMissionRepository memberMissionRepository) {
        this.missionRepository = missionRepository;
        this.storeRepository = storeRepository;
        this.memberRepository = memberRepository;
        this.missionMissionRepository = missionMissionRepository;
        this.memberMissionRepository = memberMissionRepository;
    }

    @Override
    public List<Mission> getAvailableMissions(String regionName, Long cursor, Long memberId) {
        return missionRepository.findMissions(regionName, cursor, memberId);
    }

    @Override
    public Page<Mission> getMissionsByStore(Long storeId, Integer page) {

        Store store = storeRepository.findById(storeId)
                .orElseThrow(() -> new StoreHandler(ErrorStatus.STORE_NOT_FOUND));

        Page<Mission> missionPage = missionRepository.findALLByStore(store, PageRequest.of(page, 10));
        return missionPage;
    }

    @Override
    public Page<Mission> getInProgressMissionsByMember(Long memberId, Integer page){

        Member member = memberRepository.findById(memberId)
                .orElseThrow(() -> new MemberHandler(ErrorStatus.MEMBER_NOT_FOUND));

        Page<MemberMission> memberMissionsPage = memberMissionRepository.findMemberMissionsByMemberAndStatus(
                memberId,
                MissionStatus.IN_PROGRESS.name(),
                null, // cursor를 사용하는 경우 필요한 값
                PageRequest.of(page, 10)
        );

        // MemberMission이 비어있는 경우 예외 처리
        if (memberMissionsPage.isEmpty()) {
            throw new MemberMissionHandler(ErrorStatus.MEMBER_MISSION_NOT_FOUND);
        }

        // MemberMission에서 Mission만 추출
        Page<Mission> missionPage = memberMissionsPage.map(MemberMission::getMission);

        return missionPage;
    }
}