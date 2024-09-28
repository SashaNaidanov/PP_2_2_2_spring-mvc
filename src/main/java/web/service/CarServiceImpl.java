package web.service;

import org.springframework.stereotype.Component;
import web.model.Car;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class CarServiceImpl implements CarService {

    private static int CARS_COUNT;

    private List<Car> cars;

    {
        cars = new ArrayList<>();
        cars.add(new Car(++CARS_COUNT, 52,"BMW"));
        cars.add(new Car(++CARS_COUNT, 52,"Mercedes"));
        cars.add(new Car(++CARS_COUNT, 52,"Range Rover"));
        cars.add(new Car(++CARS_COUNT, 52,"Mazda"));
        cars.add(new Car(++CARS_COUNT, 52,"BMW"));
    }

    public List<Car> getCarsList(int count) {
        if (count >= 5) {
            return cars;
        } else {
            return cars.stream().limit(count).collect(Collectors.toList());
        }
    }
}
