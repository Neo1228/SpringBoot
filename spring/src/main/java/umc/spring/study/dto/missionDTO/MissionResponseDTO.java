package umc.spring.study.dto.missionDTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MissionResponseDTO {
    private Long id;
    private Integer reward;
    private LocalDate deadLine;
    private String missionSpec;
    private String storeName; // 미션이 속한 가게의 이름

    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    public static class MissionListDTO {
        private List<MissionResponseDTO> missions;
        private int totalPages;
        private int currentPage;
    }
}