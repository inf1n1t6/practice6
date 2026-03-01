package observer;

public interface ISubject {
    void subscribe(String stockSymbol, IObserver observer);
    void unsubscribe(String stockSymbol, IObserver observer);
    void notifyObservers(String stockSymbol, double newPrice);
}