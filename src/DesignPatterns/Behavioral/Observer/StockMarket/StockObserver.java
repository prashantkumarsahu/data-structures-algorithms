package DesignPatterns.Behavioral.Observer.StockMarket;

public interface StockObserver {

  void update(String stockSymbol, Double price);
}
