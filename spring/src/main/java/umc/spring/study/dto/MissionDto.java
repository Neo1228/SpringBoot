package umc.spring.study.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class MissionDto {
    private Long id;
    private String name;
    private String status;
    private Integer rewardPoints;
    private String storeName; // 홈 화면 쿼리에서 사용
}
