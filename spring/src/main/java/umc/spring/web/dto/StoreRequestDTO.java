package umc.spring.web.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import umc.spring.validation.annotation.ExistRegion;

public class StoreRequestDTO {

    @Getter
    public static class CreateStoreDto {
        @NotBlank
        private String name;

        @ExistRegion
        private Long regionId;

        @NotBlank
        private String address;
    }
}
