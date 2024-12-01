package umc.spring.study.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import umc.spring.study.apiPayload.ApiResponse;
import umc.spring.study.dto.missionDTO.MissionRequestDTO;
import umc.spring.study.dto.missionDTO.MissionResponseDTO;
import umc.spring.study.service.missionService.MissionCommandService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/missions")
public class MissionRestController {

    private final MissionCommandService missionCommandService;

    @PostMapping("/")
    public ApiResponse<MissionResponseDTO> addMission(@RequestBody @Valid MissionRequestDTO requestDto) {
        // 미션 추가 비즈니스 로직 호출
        MissionResponseDTO responseDto = missionCommandService.addMission(requestDto);

        // 응답 데이터 생성
        return ApiResponse.onSuccess(responseDto);
    }
}
