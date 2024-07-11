package DesignPatterns.Structural.Adapter;

public class StripeAdapter implements PaymentGateway{

  // To be written by Payment Aggregator

  private Stripe stripeGateway;

  public StripeAdapter(Stripe stripeGateway) {
    this.stripeGateway = stripeGateway;
  }

  @Override
  public void processPayment(double amount) {
    stripeGateway.makePaymentStripe(amount);
  }
}
