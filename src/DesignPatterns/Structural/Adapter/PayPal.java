package DesignPatterns.Structural.Adapter;

public class PayPal {

  // Got from Third party library
  public void makePaymentPaypal(double amount){
    System.out.println("Paid " + amount + " via Paypal");
  }
}
