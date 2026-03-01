package observer;

public class Trader implements IObserver {

    private final String name;
    private final double minPrice;

    public Trader(String name, double minPrice) {
        this.name = name;
        this.minPrice = minPrice;
    }

    @Override
    public void update(String stockSymbol, double newPrice) {
        if (newPrice >= minPrice) {
            System.out.println("[Трейдер " + name + "] " + stockSymbol + " = " + newPrice + " — уведомление получено!");
        }
    }
}