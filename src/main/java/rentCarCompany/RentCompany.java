package rentCarCompany;

import java.util.ArrayList;
import java.util.List;

public class RentCompany {
    private static final String NEWLINE = System.getProperty("line.separator");
    private final List<Car> cars;

    private RentCompany() {
        this.cars = new ArrayList<>();
    }

    public static RentCompany create() {
        return new RentCompany();
    }

    public String generateReport() {
        StringBuilder sb = new StringBuilder();

        for (Car car : cars) {
            sb.append(String.format("%s : %.0f리터%s", car.getName(), car.getChargeQuantity(), NEWLINE));
        }
        return sb.toString();
    }

    public void addCar(Car car) {
        this.cars.add(car);
    }
}
