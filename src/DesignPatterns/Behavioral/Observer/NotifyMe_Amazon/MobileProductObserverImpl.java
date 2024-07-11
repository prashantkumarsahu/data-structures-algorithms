package DesignPatterns.Behavioral.Observer.NotifyMe_Amazon;


public class MobileProductObserverImpl implements ProductObserver{

  private String phoneNumber;

  private ProductObservable productObservable;

  public MobileProductObserverImpl(String phone, ProductObservable observable){
    this.phoneNumber = phone;
    this.productObservable = observable;
  }

  @Override
  public void update() {
    String msg = "product is now available. Hurry Up !!";
    sendsmg(phoneNumber, msg);
  }

  private void sendsmg(String phoneNumber, String msg){
    System.out.println("Hello " + phoneNumber + " " + msg);
  }
}
