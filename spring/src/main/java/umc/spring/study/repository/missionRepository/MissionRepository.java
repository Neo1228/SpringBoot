package umc.spring.study.repository.missionRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import umc.spring.study.domain.Mission;

public interface MissionRepository extends JpaRepository<Mission, Long> {
    // 추가적인 커스텀 메서드를 작성할 수 있습니다.
}
