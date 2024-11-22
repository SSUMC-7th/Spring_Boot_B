package umc.spring.web.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import umc.spring.validation.annotation.ExistRegions;
import umc.spring.validation.annotation.ExistStores;

public class StoreRequestDTO {

    @Getter
    public static class CreateStoreDto {
        @NotBlank
        private String name;

        @ExistRegions
        private Long regionId;

        @NotBlank
        private String address;
    }
}
