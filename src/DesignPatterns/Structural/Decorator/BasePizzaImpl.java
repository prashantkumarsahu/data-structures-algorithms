package DesignPatterns.Structural.Decorator;

public class BasePizzaImpl implements BasePizza{

  @Override
  public String getDescription() {
    return "Base pizza";
  }

  @Override
  public Double getCost() {
    return 5.0;
  }
}
