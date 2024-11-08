package umc.spring.repository.ReviewRepository;

import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.persistence.EntityManager;
import umc.spring.domain.*;

public class ReviewRepositoryImpl implements ReviewRepositoryCustom{

    private final JPAQueryFactory queryFactory;
    private final EntityManager entityManager;

    public ReviewRepositoryImpl(JPAQueryFactory queryFactory, EntityManager entityManager) {
        this.queryFactory = queryFactory;
        this.entityManager = entityManager;
    }

    @Override
    public void saveReview(String body, Float score, Long memberId, Long storeId) {
        QMember member = QMember.member;
        QStore store = QStore.store;

        Member memberEntity = queryFactory.selectFrom(member)
                .where(member.id.eq(memberId))
                .fetchOne();

        Store storeEntity = queryFactory.selectFrom(store)
                .where(store.id.eq(storeId))
                .fetchOne();

        if (memberEntity != null && storeEntity != null) {
            Review review = Review.builder()
                    .body(body)
                    .score(score)
                    .member(memberEntity)
                    .store(storeEntity)
                    .build();

            entityManager.persist(review);
        } else {
            throw new IllegalArgumentException("Member 또는 Store를 찾을 수 없습니다.");
        }
    }
}
