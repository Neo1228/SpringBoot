package umc.spring.study.repository.foodCategoryRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import umc.spring.study.domain.FoodCategory;

public interface FoodCategoryRepository extends JpaRepository<FoodCategory, Long> {
}
