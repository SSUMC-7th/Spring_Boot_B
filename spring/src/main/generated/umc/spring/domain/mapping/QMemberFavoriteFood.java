package umc.spring.domain.mapping;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QMemberFavoriteFood is a Querydsl query type for MemberFavoriteFood
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QMemberFavoriteFood extends EntityPathBase<MemberFavoriteFood> {

    private static final long serialVersionUID = -423625056L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QMemberFavoriteFood memberFavoriteFood = new QMemberFavoriteFood("memberFavoriteFood");

    public final umc.spring.domain.common.QBaseEntity _super = new umc.spring.domain.common.QBaseEntity(this);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdAt = _super.createdAt;

    public final umc.spring.domain.QFavoriteFood favoriteFood;

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final umc.spring.domain.QMember member;

    //inherited
    public final DateTimePath<java.time.LocalDateTime> updatedAt = _super.updatedAt;

    public QMemberFavoriteFood(String variable) {
        this(MemberFavoriteFood.class, forVariable(variable), INITS);
    }

    public QMemberFavoriteFood(Path<? extends MemberFavoriteFood> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QMemberFavoriteFood(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QMemberFavoriteFood(PathMetadata metadata, PathInits inits) {
        this(MemberFavoriteFood.class, metadata, inits);
    }

    public QMemberFavoriteFood(Class<? extends MemberFavoriteFood> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.favoriteFood = inits.isInitialized("favoriteFood") ? new umc.spring.domain.QFavoriteFood(forProperty("favoriteFood")) : null;
        this.member = inits.isInitialized("member") ? new umc.spring.domain.QMember(forProperty("member")) : null;
    }

}

