package strategy;

public class TravelBookingContext {

    private ICostCalculationStrategy strategy;

    public void setStrategy(ICostCalculationStrategy strategy) {
        this.strategy = strategy;
    }

    public double calculateCost(double distance, int passengers, String serviceClass, double discountPercent) {
        if (strategy == null) {
            throw new IllegalStateException("Стратегия не выбрана!");
        }
        if (distance <= 0) throw new IllegalArgumentException("Расстояние должно быть больше 0");
        if (passengers <= 0) throw new IllegalArgumentException("Количество пассажиров должно быть больше 0");
        if (discountPercent < 0 || discountPercent > 100) throw new IllegalArgumentException("Скидка должна быть от 0 до 100");

        return strategy.calculate(distance, passengers, serviceClass, discountPercent);
    }
}