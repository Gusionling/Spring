package fyt.find.example.driver;

import fyt.find.example.car.Car;
import fyt.find.example.car.Sonata;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.sql.SQLOutput;

/**
 * packageName   : fyt.find.example.driver
 * Author        : imhyeong-gyu
 * Data          : 2025. 4. 10.
 * Description   :
 */
@Getter
@AllArgsConstructor
public class HyeongKyuLIM implements Driver {

    private final Car car;

    @Override
    public String drive() {
        return "임형규가 " + car.getName()+"를 운전합니다.";
    }

}
