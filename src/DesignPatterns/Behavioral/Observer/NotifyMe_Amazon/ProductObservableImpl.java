package DesignPatterns.Behavioral.Observer.NotifyMe_Amazon;

import java.util.ArrayList;
import java.util.List;

public class ProductObservableImpl implements ProductObservable{

  List<ProductObserver> productObserverList = new ArrayList<>();
  Integer productCount = 0;

  String productName;

  public ProductObservableImpl(String productName){
    this.productName = productName;
  }

  @Override
  public void registerObserver(ProductObserver productObserver) {
    productObserverList.add(productObserver);
  }

  @Override
  public void removeObserver(ProductObserver productObserver) {
    productObserverList.remove(productObserver);
  }

  @Override
  public void notifyObservers() {
    for(ProductObserver observer: productObserverList){
      observer.update();
    }
  }

  @Override
  public void setProductCount(Integer newAdditions) {
    if(productCount == 0){
      notifyObservers(); // if previously productCount was 0, and now new ones are being added, then update observers
                        // about new stock being available.
    }
    productCount = productCount + newAdditions;
  }

  @Override
  public Integer getProductCount(String stockSymbol, Double price) {
    return productCount;
  }
}
