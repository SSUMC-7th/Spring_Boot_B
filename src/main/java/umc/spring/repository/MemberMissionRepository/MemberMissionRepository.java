package umc.spring.repository.MemberMissionRepository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import umc.spring.domain.Mission;
import umc.spring.domain.mapping.MemberMission;
import umc.spring.domain.mapping.MissionStatus;

import java.util.Optional;

public interface MemberMissionRepository extends JpaRepository<MemberMission, Long> {
    @Query("SELECT mm.status FROM MemberMission mm WHERE mm.mission.id = :missionId")
    Optional<MissionStatus> findStatusByMissionId(@Param("missionId") Long missionId);

    @Query("SELECT m FROM MemberMission mm JOIN mm.mission m WHERE mm.member.id = :memberId AND mm.status = 'COMPLETE'")
    Page<Mission> findCompleteMissionsByMemberId(@Param("memberId") Long memberId, PageRequest pageRequest);
}
