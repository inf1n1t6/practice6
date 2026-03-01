package strategy;

public class TrainStrategy implements ICostCalculationStrategy {

    @Override
    public double calculate(double distance, int passengers, String serviceClass, double discountPercent) {
        double base = distance * 2.0;
        if (serviceClass.equalsIgnoreCase("business")) base *= 1.8;
        base *= passengers;
        base -= base * (discountPercent / 100);
        return Math.round(base * 100.0) / 100.0;
    }
}