package fyt.find.example.driver;

import fyt.find.example.car.Car;
import fyt.find.example.config.AppConfig;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

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
        //AppConfig appConfig = new AppConfig();
        ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);


        //when
        //Driver driver = appConfig.diver();
        Driver driver = ac.getBean(Driver.class);

        //then
        Assertions.assertThat(driver.drive()).isEqualTo("임형규가 소나타를 운전합니다.");

    }
}