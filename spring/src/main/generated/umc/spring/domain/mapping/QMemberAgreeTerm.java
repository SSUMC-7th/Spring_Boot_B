package umc.spring.domain.mapping;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QMemberAgreeTerm is a Querydsl query type for MemberAgreeTerm
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QMemberAgreeTerm extends EntityPathBase<MemberAgreeTerm> {

    private static final long serialVersionUID = 471568498L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QMemberAgreeTerm memberAgreeTerm = new QMemberAgreeTerm("memberAgreeTerm");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final umc.spring.domain.QMember member;

    public final umc.spring.domain.QTerm term;

    public QMemberAgreeTerm(String variable) {
        this(MemberAgreeTerm.class, forVariable(variable), INITS);
    }

    public QMemberAgreeTerm(Path<? extends MemberAgreeTerm> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QMemberAgreeTerm(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QMemberAgreeTerm(PathMetadata metadata, PathInits inits) {
        this(MemberAgreeTerm.class, metadata, inits);
    }

    public QMemberAgreeTerm(Class<? extends MemberAgreeTerm> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.member = inits.isInitialized("member") ? new umc.spring.domain.QMember(forProperty("member")) : null;
        this.term = inits.isInitialized("term") ? new umc.spring.domain.QTerm(forProperty("term")) : null;
    }

}

