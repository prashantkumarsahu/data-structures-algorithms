package DesignPatterns.Structural.Adapter;

public class Stripe {
  // Got from Third party library
  public void makePaymentStripe(double amount){
    System.out.println("Paid " + amount + " via Stripe");
  }
}
