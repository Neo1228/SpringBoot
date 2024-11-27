package umc.spring.study.repository.storeRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import umc.spring.study.domain.Store;

public interface StoreRepository extends JpaRepository<Store, Long>, StoreRepositoryCustom {
}