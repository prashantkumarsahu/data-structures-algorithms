package DesignPatterns.Structural.Adapter;

public class PaypalAdapter implements PaymentGateway{

  // To be written by Payment Aggregator
  private PayPal payPalGateway;

  public PaypalAdapter(PayPal payPalGateway) {
    this.payPalGateway = payPalGateway;
  }

  @Override
  public void processPayment(double amount) {
    payPalGateway.makePaymentPaypal(amount);
  }
}
