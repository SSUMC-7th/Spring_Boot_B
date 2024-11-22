package umc.spring.web.dto.StoreDTO;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import umc.spring.validation.annotation.ExistRegions;

public class StoreRequestDTO {

    @Getter
    public static class JoinDTO {
        @NotBlank
        String name;
        @NotBlank
        String address;
        @ExistRegions
        Long regionId;
    }
}
