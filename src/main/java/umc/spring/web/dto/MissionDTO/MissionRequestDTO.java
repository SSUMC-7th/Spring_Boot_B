package umc.spring.web.dto.MissionDTO;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;

import java.time.LocalDate;

public class MissionRequestDTO {

    @Getter
    public static class JoinDTO {
        @NotNull
        Integer reward;
        LocalDate deadline;
        @NotBlank
        String mission_spec;
    }
}
