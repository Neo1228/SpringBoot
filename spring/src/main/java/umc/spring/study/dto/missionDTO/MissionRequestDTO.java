package umc.spring.study.dto.missionDTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MissionRequestDTO {
    private Integer reward;
    private LocalDate deadLine;
    private String missionSpec;
    private Long storeId;
}
