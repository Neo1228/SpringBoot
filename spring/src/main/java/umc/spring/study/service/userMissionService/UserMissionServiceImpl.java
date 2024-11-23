package umc.spring.study.service.userMissionService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.spring.study.apiPayload.exception.GeneralException;
import umc.spring.study.apiPayload.exception.handler.MissionHandler;
import umc.spring.study.converter.UserMissionConverter;
import umc.spring.study.domain.Member;
import umc.spring.study.domain.Mission;
import umc.spring.study.domain.mapping.MemberMission;
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
}
