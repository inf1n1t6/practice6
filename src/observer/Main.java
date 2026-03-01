package observer;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        StockExchange exchange = new StockExchange();

        Trader trader1 = new Trader("Иван", 150.0);
        Trader trader2 = new Trader("Мария", 200.0);
        TradingRobot robot1 = new TradingRobot("R2D2", 120.0, 180.0);
        TradingRobot robot2 = new TradingRobot("HAL9000", 90.0, 160.0);

        exchange.subscribe("AAPL", trader1);
        exchange.subscribe("AAPL", robot1);
        exchange.subscribe("GOOGL", trader2);
        exchange.subscribe("GOOGL", robot2);
        exchange.subscribe("AAPL", trader2);

        exchange.setPrice("AAPL", 110.0);
        Thread.sleep(500);
        exchange.setPrice("AAPL", 155.0);
        Thread.sleep(500);
        exchange.setPrice("AAPL", 190.0);
        Thread.sleep(500);

        exchange.setPrice("GOOGL", 85.0);
        Thread.sleep(500);
        exchange.setPrice("GOOGL", 170.0);

        System.out.println("\n--- Мария отписывается от GOOGL ---");
        exchange.unsubscribe("GOOGL", trader2);
        exchange.setPrice("GOOGL", 210.0);
    }
}