package rentCarCompany;

public class Sonata extends Car {
    private static final int DISTANCE_PER_LITER = 10;
    private static final String NAME = "Sonata";

    private final int distance;

    public Sonata(int distance) {
        this.distance = distance;
    }

    @Override
    double getDistancePerLiter() {
        return DISTANCE_PER_LITER;
    }

    @Override
    double getTripDistance() {
        return distance;
    }

    @Override
    String getName() {
        return NAME;
    }
}
