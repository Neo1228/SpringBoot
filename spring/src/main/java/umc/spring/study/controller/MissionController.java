package umc.spring.study.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;
import umc.spring.study.dto.MissionDto;
import umc.spring.study.service.userMissionService.UserMissionService;

@RestController
@RequestMapping("/api/missions")
public class MissionController {

    @Autowired
    private UserMissionService userMissionService;

    @GetMapping("/user/{userId}")
    public Page<MissionDto> getUserMissions(
            @PathVariable Long userId,
            Pageable pageable) {
        return userMissionService.getUserMissions(userId, pageable);
    }
}
