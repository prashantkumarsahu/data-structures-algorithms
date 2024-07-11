package DesignPatterns.Structural.Adapter;

public class MainPayApp {

  public static void main(String[] args) {

    // Writing the adapters makes the 2 different incompatible libraries work in the same app

    PaymentGateway paypalPaymentGateway = new PaypalAdapter(new PayPal());
    PaymentGateway stripePaymentGateway = new StripeAdapter(new Stripe());

    paypalPaymentGateway.processPayment(20.04);

    stripePaymentGateway.processPayment(30.05);
  }
}
