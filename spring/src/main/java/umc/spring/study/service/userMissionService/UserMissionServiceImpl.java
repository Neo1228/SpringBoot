package umc.spring.study.service.userMissionService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.spring.study.apiPayload.exception.GeneralException;
import umc.spring.study.apiPayload.exception.handler.MissionHandler;
import umc.spring.study.converter.MissionConverter;
import umc.spring.study.converter.UserMissionConverter;
import umc.spring.study.domain.Member;
import umc.spring.study.domain.Mission;
import umc.spring.study.domain.mapping.MemberMission;
import umc.spring.study.dto.missionDTO.MissionResponseDTO;
import umc.spring.study.dto.userMissionDTO.UserMissionRequestDTO;
import umc.spring.study.dto.userMissionDTO.UserMissionResponseDTO;
import umc.spring.study.repository.memberRepository.MemberRepository;
import umc.spring.study.repository.missionRepository.MissionRepository;
import umc.spring.study.repository.userMissionRepository.UserMissionRepository;
import umc.spring.study.apiPayload.code.status.ErrorStatus;

import static umc.spring.study.apiPayload.code.status.ErrorStatus.MISSION_NOT_FOUND;

@Service
@RequiredArgsConstructor
public class UserMissionServiceImpl implements UserMissionService {

    private final UserMissionRepository userMissionRepository;
    private final MemberRepository memberRepository;
    private final MissionRepository missionRepository;

    @Override
    @Transactional
    public UserMissionResponseDTO addUserMission(UserMissionRequestDTO requestDto) {
        // Member 조회 (존재하지 않으면 예외 발생)
        Member member = memberRepository.findById(requestDto.getMemberId())
                .orElseThrow(() -> new GeneralException(ErrorStatus.MEMBER_NOT_FOUND));

        // Mission 조회 (존재하지 않으면 예외 발생)
        Mission mission = missionRepository.findById(requestDto.getMissionId())
                .orElseThrow(() -> new MissionHandler(MISSION_NOT_FOUND));

        // DTO를 Entity로 변환 후 저장
        MemberMission memberMission = UserMissionConverter.toEntity(requestDto, member, mission);
        MemberMission savedMemberMission = userMissionRepository.save(memberMission);

        // Entity를 Response DTO로 변환 후 반환
        return UserMissionConverter.toResponseDto(savedMemberMission);
    }

    @Transactional
    public MissionResponseDTO completeMission(Long missionId) {
        // Mission 조회
        Mission mission = missionRepository.findById(missionId)
                .orElseThrow(() -> new GeneralException(ErrorStatus.MISSION_NOT_FOUND));

        // Mission 상태 변경
        mission.completeMission();

        // JPA 변경 감지로 자동 업데이트
        if (mission != null) {
            return MissionConverter.toResponseDto(mission);
        } else {
            throw new GeneralException(ErrorStatus.MISSION_NOT_FOUND);
        }
    }
}
