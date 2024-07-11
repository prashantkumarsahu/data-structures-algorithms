package DesignPatterns.Structural.Decorator;

public class CheeseDecorator extends PizzaDecorator{

  public CheeseDecorator(BasePizza pizza) {
    super(pizza);
  }

  @Override
  public String getDescription() {
    return decoratedPizza.getDescription() + "+ Cheese";
  }

  @Override
  public Double getCost() {
    return decoratedPizza.getCost() + 10.0;
  }
}
