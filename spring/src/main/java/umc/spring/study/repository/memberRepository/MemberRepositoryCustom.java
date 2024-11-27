package umc.spring.study.repository.memberRepository;

import umc.spring.study.dto.MyPageDto;

public interface MemberRepositoryCustom {
    MyPageDto findMyPageInfo(Long userId);
}
