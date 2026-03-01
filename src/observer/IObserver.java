package observer;

public interface IObserver {
    void update(String stockSymbol, double newPrice);
}