package umc.spring.study.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class MyPageDto {
    private Long id;
    private String nickname;
    private String email;
    private String phoneNumber;
    private Integer totalPoints;
    private Long reviewCount;
    private Long completedMissionsCount;
}
