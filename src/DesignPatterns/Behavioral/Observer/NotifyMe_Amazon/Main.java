package DesignPatterns.Behavioral.Observer.NotifyMe_Amazon;

public class Main {


  public static void main(String[] args) {

    // Implement the Notify Me feature in Amazon.
    ProductObservable productObservable1 = new ProductObservableImpl("Iphone15");

    ProductObserver emailProductObserver1 = new EmailProductObserverImpl("prashant@gmail.com", productObservable1);
    ProductObserver emailProductObserver2 = new EmailProductObserverImpl("ekant@gmail.com", productObservable1);
    ProductObserver mobileProductObserver1 = new MobileProductObserverImpl("799", productObservable1);

    productObservable1.registerObserver(emailProductObserver1);
    productObservable1.registerObserver(emailProductObserver2);
    productObservable1.registerObserver(mobileProductObserver1);

    productObservable1.setProductCount(5);

    productObservable1.removeObserver(emailProductObserver1);

    productObservable1.setProductCount(0);

  }

}
