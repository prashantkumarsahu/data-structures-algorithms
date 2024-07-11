package DesignPatterns.Behavioral.Observer.StockMarket;

public interface StockMarketObservable {

  void registerObserver(StockObserver stockObserver);
  void removeObserver(StockObserver stockObserver);
  void notifyObservers(String stockSymbol, Double price);

  void setStockPrice(String stockSymbol, Double price);

  int getStockCount();

}
