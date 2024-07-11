package DesignPatterns.Structural.Decorator;

public class DecoratorMain {

  public static void main(String[] args) {

    BasePizza basePizza = new BasePizzaImpl();

    System.out.println(basePizza.getDescription() + " " + basePizza.getCost());

    basePizza = new CheeseDecorator(basePizza);

    System.out.println(basePizza.getDescription() + " " + basePizza.getCost());

    basePizza = new VeggiesDecorator(basePizza);

    System.out.println(basePizza.getDescription() + " " + basePizza.getCost());

  }
}
