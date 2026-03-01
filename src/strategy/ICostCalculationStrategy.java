package strategy;

public interface ICostCalculationStrategy {
    double calculate(double distance, int passengers, String serviceClass, double discountPercent);
}