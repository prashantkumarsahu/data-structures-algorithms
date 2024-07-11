package DesignPatterns.Behavioral.Observer.NotifyMe_Amazon;

public interface ProductObservable {

  void registerObserver(ProductObserver stockObserver);
  void removeObserver(ProductObserver stockObserver);
  void notifyObservers();

  void setProductCount(Integer count);

  Integer getProductCount(String stockSymbol, Double price);

}
