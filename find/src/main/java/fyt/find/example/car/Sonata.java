package fyt.find.example.car;

import lombok.Getter;
import org.springframework.stereotype.Component;

/**
 * packageName   : fyt.find.example.car
 * Author        : imhyeong-gyu
 * Data          : 2025. 4. 10.
 * Description   :
 */
@Getter
@Component
public class Sonata implements Car {

    private final String name = "소나타";

    @Override
    public String move() {
        return "소나타가 달립니다";
    }
}
