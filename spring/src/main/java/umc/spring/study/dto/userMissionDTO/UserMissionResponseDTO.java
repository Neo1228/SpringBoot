package umc.spring.study.dto.userMissionDTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserMissionResponseDTO {
    private Long id;
    private Long memberId;
    private Long missionId;
    private String missionSpec; // 미션 설명

    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    public static class UserMissionListDTO {
        private List<UserMissionResponseDTO> missions;
        private int totalPages;
        private int currentPage;
    }

}