package umc.spring.repository.ReviewRepository;

public interface ReviewRepositoryCustom {
    void saveReview(String body, Float score, Long memberId, Long storeId);
}
