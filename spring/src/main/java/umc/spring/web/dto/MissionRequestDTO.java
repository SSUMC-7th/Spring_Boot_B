package umc.spring.web.dto;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import umc.spring.validation.annotation.ExistStore;

import java.time.LocalDate;

public class MissionRequestDTO {

    @Getter
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class CreateMissionDto {
        @ExistStore
        private Long storeId;

        @NotBlank
        private String missionSpec;

        @Min(0)
        private Integer reward;

        @Future
        @NotNull
        private LocalDate dueDate;
    }
}