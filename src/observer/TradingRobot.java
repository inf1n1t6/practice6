package observer;

public class TradingRobot implements IObserver {

    private final String name;
    private final double buyBelow;
    private final double sellAbove;

    public TradingRobot(String name, double buyBelow, double sellAbove) {
        this.name = name;
        this.buyBelow = buyBelow;
        this.sellAbove = sellAbove;
    }

    @Override
    public void update(String stockSymbol, double newPrice) {
        if (newPrice < buyBelow) {
            System.out.println("[Робот " + name + "] " + stockSymbol + " = " + newPrice + " — ПОКУПАЮ!");
        } else if (newPrice > sellAbove) {
            System.out.println("[Робот " + name + "] " + stockSymbol + " = " + newPrice + " — ПРОДАЮ!");
        } else {
            System.out.println("[Робот " + name + "] " + stockSymbol + " = " + newPrice + " — жду...");
        }
    }
}