package umc.spring.study.repository.regionRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import umc.spring.study.domain.Region;

public interface RegionRepository extends JpaRepository<Region, Long> {
    // 필요한 경우 커스텀 쿼리 메서드를 추가할 수 있습니다.
}
