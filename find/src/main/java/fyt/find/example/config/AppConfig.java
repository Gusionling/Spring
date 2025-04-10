package fyt.find.example.config;

import fyt.find.example.car.Car;
import fyt.find.example.car.Sonata;
import fyt.find.example.driver.Driver;
import fyt.find.example.driver.HyeongKyuLIM;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * packageName   : fyt.find.example.config
 * Author        : imhyeong-gyu
 * Data          : 2025. 4. 10.
 * Description   :
 */

@Configuration
public class AppConfig {

    @Bean
    public Driver driver(){
        return new HyeongKyuLIM(car());
    }

    @Bean
    public Car car(){
        return new Sonata();
    }
}
