package fyt.find.example.driver;

import fyt.find.example.car.Car;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * packageName   : fyt.find.example.driver
 * Author        : imhyeong-gyu
 * Data          : 2025. 4. 10.
 * Description   :
 */
class HyeongKyuLIMTest {

    @Test
    void drive() {
        //given
        Driver driver = new HyeongKyuLIM();

        //when

        //then
        Assertions.assertThat(driver.drive()).isEqualTo("임형규가 소나타를 운전합니다.");

    }
}