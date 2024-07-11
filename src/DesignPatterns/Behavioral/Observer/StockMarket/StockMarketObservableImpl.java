package DesignPatterns.Behavioral.Observer.StockMarket;

import java.util.ArrayList;
import java.util.List;

public class StockMarketObservableImpl implements StockMarketObservable {

  private List<StockObserver> observersList = new ArrayList<>();

  public void setStockPrice(String stockSymbol, Double price){
    notifyObservers(stockSymbol, price);
  }

  @Override
  public int getStockCount() {
    return 0;
  }

  @Override
  public void registerObserver(StockObserver stockObserver) {
    observersList.add(stockObserver);
  }

  @Override
  public void removeObserver(StockObserver stockObserver) {
    observersList.remove(stockObserver);
  }

  @Override
  public void notifyObservers(String stockSymbol, Double price) {
    for(StockObserver observer: observersList){
      observer.update(stockSymbol, price);
    }
  }

}
