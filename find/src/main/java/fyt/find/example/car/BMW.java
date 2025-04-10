package fyt.find.example.car;

import lombok.Getter;

/**
 * packageName   : fyt.find.example.car
 * Author        : imhyeong-gyu
 * Data          : 2025. 4. 10.
 * Description   :
 */

@Getter
public class BMW implements Car {

    private final String name = "BMW";

    @Override
    public String move() {
        return "BMW가 달립니다";
    }
}
