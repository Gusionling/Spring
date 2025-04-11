package fyt.find.example.config;

import fyt.find.example.car.Car;
import fyt.find.example.car.Sonata;
import fyt.find.example.driver.Driver;
import fyt.find.example.driver.HyeongKyuLIM;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

/**
 * packageName   : fyt.find.example.config
 * Author        : imhyeong-gyu
 * Data          : 2025. 4. 10.
 * Description   :
 */

@Configuration
@ComponentScan(
       basePackages = "fyt.find.example"
)
public class AppConfig {

}
