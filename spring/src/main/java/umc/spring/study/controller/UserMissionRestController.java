package umc.spring.study.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;
import umc.spring.study.apiPayload.ApiResponse;
import umc.spring.study.converter.UserMissionConverter;
import umc.spring.study.domain.mapping.MemberMission;
import umc.spring.study.dto.missionDTO.MissionResponseDTO;
import umc.spring.study.dto.userMissionDTO.UserMissionRequestDTO;
import umc.spring.study.dto.userMissionDTO.UserMissionResponseDTO;
import umc.spring.study.repository.userMissionRepository.UserMissionRepository;
import umc.spring.study.service.userMissionService.UserMissionService;
import umc.spring.study.validation.annotation.PageNumber;
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

    private final UserMissionRepository userMissionRepository;

    @PostMapping("/")
    public ApiResponse<UserMissionResponseDTO> addUserMission(@RequestBody @Valid UserMissionRequestDTO requestDto) {
        // 미션 도전 비즈니스 로직 호출
        UserMissionResponseDTO responseDto = userMissionService.addUserMission(requestDto);

        // 응답 데이터 생성
        return ApiResponse.onSuccess(responseDto);
    }

    @GetMapping("/my")
    public ApiResponse<UserMissionResponseDTO.UserMissionListDTO> getMyMissions(
            @RequestParam @PageNumber Integer page,
            @RequestParam Long memberId
    ) {
        Page<MemberMission> missionPage = userMissionRepository.findAllByMemberId(memberId, PageRequest.of(page, 10));
        UserMissionResponseDTO.UserMissionListDTO missionListDTO = UserMissionConverter.toUserMissionListDTO(missionPage);
        return ApiResponse.onSuccess(missionListDTO);
    }

    @PatchMapping("/complete")
    public ApiResponse<MissionResponseDTO> completeMission(
            @RequestParam Long memberMissionId
    ) {
        MissionResponseDTO responseDTO = userMissionService.completeMission(memberMissionId);
        return ApiResponse.onSuccess(responseDTO);
    }
}
