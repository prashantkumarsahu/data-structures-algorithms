package DesignPatterns.Structural.Adapter;

public interface PaymentGateway {

  //   // To be written by Payment Aggregator
  void processPayment(double amount);
}
