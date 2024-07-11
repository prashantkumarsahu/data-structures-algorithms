package DesignPatterns.Behavioral.Observer.NotifyMe_Amazon;


public class EmailProductObserverImpl implements ProductObserver{

  private String emailId;

  private ProductObservable productObservable;

  public EmailProductObserverImpl(String email, ProductObservable observable){
    this.emailId = email;
    this.productObservable = observable;
  }

  @Override
  public void update() {
    String msg = "product is now available. Hurry Up !!";
    sendemail(emailId, msg);
  }

  private void sendemail(String emailId, String msg){
    System.out.println("Hello " + emailId + " " + msg);
  }
}
