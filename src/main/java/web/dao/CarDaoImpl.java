package web.dao;

import org.springframework.stereotype.Repository;
import web.model.Car;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class CarDaoImpl implements CarDao {
    public static final List<Car> cars = new ArrayList<>();

    static {

        cars.add(new Car("Opel Astra", 400000, 2007));
        cars.add(new Car("Ford focus", 350000, 2005));
        cars.add(new Car("Audi A4", 800000, 2008));
        cars.add(new Car("BMW5", 1000000, 2010));
        cars.add(new Car("Volkswagen Golf", 650000, 2009));
    }

    @Override
    public List<Car> getCars(int count) {
        if (count <= 0 || count > cars.size()) {
            return cars;
        }
        return cars.stream().limit(count).collect(Collectors.toList());
    }
}
