package hello.itemservice.repository.v2;

import com.querydsl.jpa.impl.JPAQueryFactory;
import hello.itemservice.domain.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepositoryV2 extends JpaRepository<Item, Long> {

}
