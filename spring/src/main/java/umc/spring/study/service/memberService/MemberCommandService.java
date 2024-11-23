package umc.spring.study.service.memberService;

import org.springframework.transaction.annotation.Transactional;
import umc.spring.study.domain.Member;
import umc.spring.study.dto.memberDTO.MemberRequestDTO;

public interface MemberCommandService {
    @Transactional
    Member joinMember(MemberRequestDTO.JoinDto request);
}
