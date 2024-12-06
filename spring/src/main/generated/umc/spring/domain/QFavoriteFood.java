package umc.spring.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QFavoriteFood is a Querydsl query type for FavoriteFood
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QFavoriteFood extends EntityPathBase<FavoriteFood> {

    private static final long serialVersionUID = 1905081030L;

    public static final QFavoriteFood favoriteFood = new QFavoriteFood("favoriteFood");

    public final umc.spring.domain.common.QBaseEntity _super = new umc.spring.domain.common.QBaseEntity(this);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdAt = _super.createdAt;

    public final EnumPath<umc.spring.domain.enums.Food> food = createEnum("food", umc.spring.domain.enums.Food.class);

    public final NumberPath<Long> id = createNumber("id", Long.class);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> updatedAt = _super.updatedAt;

    public QFavoriteFood(String variable) {
        super(FavoriteFood.class, forVariable(variable));
    }

    public QFavoriteFood(Path<? extends FavoriteFood> path) {
        super(path.getType(), path.getMetadata());
    }

    public QFavoriteFood(PathMetadata metadata) {
        super(FavoriteFood.class, metadata);
    }

}

