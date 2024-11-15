package umc.spring;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import umc.spring.service.MissionService.MissionQueryService;
import umc.spring.service.StoreService.StoreQueryService;

@SpringBootApplication
@EnableJpaAuditing
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	// 실습 테스트 코드
//	@Bean
//	public CommandLineRunner run(ApplicationContext context) {
//		return args -> {
//			StoreQueryService storeService = context.getBean(StoreQueryService.class);
//
//			// 파라미터 값 설정
//			String name = "요아정";
//			Float score = 4.0f;
//
//			// 쿼리 메서드 호출 및 쿼리 문자열과 파라미터 출력
//			System.out.println("Executing findStoresByNameAndScore with parameters:");
//			System.out.println("Name: " + name);
//			System.out.println("Score: " + score);
//
//			storeService.findStoresByNameAndScore(name, score)
//					.forEach(System.out::println);
//		};
//	}

	// 내가 진행중, 진행 완료한 미션 모아서 보는 쿼리(페이징 포함) 테스트 코드
//	@Bean
//	public CommandLineRunner run(ApplicationContext context) {
//		return args -> {
//			// MissionQueryService Bean 가져오기
//			MissionQueryService missionService = context.getBean(MissionQueryService.class);
//
//			// 파라미터 값 설정
//			Long memberId = 1L; // 테스트할 회원 ID
//			Long cursorId = null; // 첫 페이지인 경우 null 설정
//			int limit = 10; // 한 번에 가져올 미션 수
//
//			// 쿼리 메서드 호출 및 쿼리 결과 출력
//			System.out.println("Executing findInProgressMissionsByMemberWithCursor with parameters:");
//			System.out.println("Member ID: " + memberId);
//			System.out.println("Cursor ID: " + (cursorId == null ? "null" : cursorId));
//			System.out.println("Limit: " + limit);
//
//			missionService.findInProgressMissionsByMemberWithCursor(memberId, cursorId, limit)
//					.forEach(mission -> {
//						System.out.println("Mission ID: " + mission.getId());
//						System.out.println("Store Name: " + mission.getStore().getName());
//						System.out.println("Reward: " + mission.getReward());
//						System.out.println("Mission Spec: " + mission.getMissionSpec());
//						System.out.println("Status: " + mission.getMissionStatus());
//						System.out.println("----------------------------------------");
//					});
//		};
//	}


}
