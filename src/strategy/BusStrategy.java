package strategy;

public class BusStrategy implements ICostCalculationStrategy {

    @Override
    public double calculate(double distance, int passengers, String serviceClass, double discountPercent) {
        double base = distance * 0.8;
        base *= passengers;
        base -= base * (discountPercent / 100);
        return Math.round(base * 100.0) / 100.0;
    }
}