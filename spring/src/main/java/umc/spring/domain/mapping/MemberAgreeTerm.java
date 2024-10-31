package umc.spring.domain.mapping;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class MemberAgreeTerm {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


}
