package DesignPatterns.Structural.Decorator;

public class VeggiesDecorator extends PizzaDecorator{

  public VeggiesDecorator(BasePizza pizza) {
    super(pizza);
  }

  @Override
  public String getDescription() {
    return decoratedPizza.getDescription() + "+ Veggies";
  }

  @Override
  public Double getCost() {
    return decoratedPizza.getCost() + 15.0;
  }
}
