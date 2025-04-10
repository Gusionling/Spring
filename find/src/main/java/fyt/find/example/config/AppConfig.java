package fyt.find.example.config;

import fyt.find.example.car.Car;
import fyt.find.example.car.Sonata;
import fyt.find.example.driver.Driver;
import fyt.find.example.driver.HyeongKyuLIM;

/**
 * packageName   : fyt.find.example.config
 * Author        : imhyeong-gyu
 * Data          : 2025. 4. 10.
 * Description   :
 */
public class AppConfig {

    public Driver diver(){
        return new HyeongKyuLIM(car());
    }

    public Car car(){
        return new Sonata();
    }
}
