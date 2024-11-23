package umc.spring.study.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import umc.spring.study.apiPayload.ApiResponse;
import umc.spring.study.dto.userMissionDTO.UserMissionRequestDTO;
import umc.spring.study.dto.userMissionDTO.UserMissionResponseDTO;
import umc.spring.study.service.userMissionService.UserMissionService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user-missions")
public class UserMissionRestController {

    private final UserMissionService userMissionService;

    @PostMapping("/")
    public ApiResponse<UserMissionResponseDTO> addUserMission(@RequestBody @Valid UserMissionRequestDTO requestDto) {
        // 미션 도전 비즈니스 로직 호출
        UserMissionResponseDTO responseDto = userMissionService.addUserMission(requestDto);

        // 응답 데이터 생성
        return ApiResponse.onSuccess(responseDto);
    }
}
