package umc.spring.domain;

import jakarta.persistence.*;
import lombok.*;
import umc.spring.domain.common.BaseEntity;
import umc.spring.domain.enums.FoodCategory;
import umc.spring.domain.mapping.MemberMission;
import umc.spring.domain.mapping.MemberPreferFood;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Food extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "VARCHAR(20)")
    private FoodCategory foodCategory;

    @Column(nullable = false)
    private Boolean preferOptional;

    @OneToMany(mappedBy = "food", cascade = CascadeType.ALL)
    private List<MemberPreferFood> memberPreferFoodList = new ArrayList<>();
}
