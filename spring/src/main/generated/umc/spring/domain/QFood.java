package umc.spring.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QFood is a Querydsl query type for Food
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QFood extends EntityPathBase<Food> {

    private static final long serialVersionUID = -1348495606L;

    public static final QFood food = new QFood("food");

    public final umc.spring.domain.common.QBaseEntity _super = new umc.spring.domain.common.QBaseEntity(this);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdAt = _super.createdAt;

    public final EnumPath<umc.spring.domain.enums.FoodCategory> foodCategory = createEnum("foodCategory", umc.spring.domain.enums.FoodCategory.class);

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final ListPath<umc.spring.domain.mapping.MemberPreferFood, umc.spring.domain.mapping.QMemberPreferFood> memberPreferFoodList = this.<umc.spring.domain.mapping.MemberPreferFood, umc.spring.domain.mapping.QMemberPreferFood>createList("memberPreferFoodList", umc.spring.domain.mapping.MemberPreferFood.class, umc.spring.domain.mapping.QMemberPreferFood.class, PathInits.DIRECT2);

    public final BooleanPath preferOptional = createBoolean("preferOptional");

    //inherited
    public final DateTimePath<java.time.LocalDateTime> updatedAt = _super.updatedAt;

    public QFood(String variable) {
        super(Food.class, forVariable(variable));
    }

    public QFood(Path<? extends Food> path) {
        super(path.getType(), path.getMetadata());
    }

    public QFood(PathMetadata metadata) {
        super(Food.class, metadata);
    }

}

