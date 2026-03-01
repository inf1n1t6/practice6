package observer;

import java.util.*;

public class StockExchange implements ISubject {

    private final Map<String, Double> stockPrices = new HashMap<>();
    private final Map<String, List<IObserver>> subscribers = new HashMap<>();

    @Override
    public void subscribe(String stockSymbol, IObserver observer) {
        subscribers.computeIfAbsent(stockSymbol, k -> new ArrayList<>()).add(observer);
        System.out.println("[Биржа] " + observer.getClass().getSimpleName() + " подписан на " + stockSymbol);
    }

    @Override
    public void unsubscribe(String stockSymbol, IObserver observer) {
        List<IObserver> list = subscribers.get(stockSymbol);
        if (list != null) {
            list.remove(observer);
            System.out.println("[Биржа] " + observer.getClass().getSimpleName() + " отписан от " + stockSymbol);
        }
    }

    @Override
    public void notifyObservers(String stockSymbol, double newPrice) {
        List<IObserver> list = subscribers.getOrDefault(stockSymbol, Collections.emptyList());
        for (IObserver observer : list) {
            observer.update(stockSymbol, newPrice);
        }
    }

    public void setPrice(String stockSymbol, double newPrice) {
        double oldPrice = stockPrices.getOrDefault(stockSymbol, 0.0);
        stockPrices.put(stockSymbol, newPrice);
        System.out.println("\n[Биржа] " + stockSymbol + ": " + oldPrice + " → " + newPrice);
        notifyObservers(stockSymbol, newPrice);
    }

    public double getPrice(String stockSymbol) {
        return stockPrices.getOrDefault(stockSymbol, 0.0);
    }
}