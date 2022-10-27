package kitchenpos.domain.menu;

import java.util.List;
import kitchenpos.domain.Menu;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface MenuRepository extends JpaRepository<Menu, Long> {

    @EntityGraph(attributePaths = "menuProducts")
    List<Menu> findAll();

    @Query("select count(m.id) from Menu m where m.id in (:menuIds)")
    int countByIdIn(List<Long> menuIds);
}