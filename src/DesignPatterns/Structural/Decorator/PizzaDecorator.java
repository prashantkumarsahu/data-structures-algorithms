package DesignPatterns.Structural.Decorator;

public abstract class PizzaDecorator implements BasePizza{

  protected BasePizza decoratedPizza;

  public PizzaDecorator(BasePizza pizza){
    this.decoratedPizza = pizza;
  }
}
