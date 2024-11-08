package umc.spring.repository.ReviewRepository;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import umc.spring.domain.QReview;
import umc.spring.domain.Review;

@Repository
@RequiredArgsConstructor
public class ReviewRepositoryImpl implements ReviewRepositoryCustom{

    private final JPAQueryFactory jpaQueryFactory;
    private final QReview review = QReview.review;

    @Override
    public Review dynamicQueryCreateReview(Long memberId, Long storeId, String body, float score) {
        BooleanBuilder predicate = new BooleanBuilder();


        if (memberId != null) {
            predicate.and(review.member.id.eq(memberId));
        }


        if (storeId != null) {
            predicate.and(review.store.id.eq(storeId));
        }


        if (body != null && !body.isEmpty()) {
            predicate.and(review.body.eq(body));
        }


        if (score >= 0) {
            predicate.and(review.score.eq(score));
        }


        return jpaQueryFactory
                .selectFrom(review)
                .where(predicate)
                .fetchOne();
    }
}
