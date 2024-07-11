package DesignPatterns.Creational.Factory;

import DesignPatterns.Creational.Factory.Machine.FoodMachine;
import DesignPatterns.Creational.Factory.Machine.HotdogMachine;
import DesignPatterns.Creational.Factory.Machine.PizzaMachine;
import DesignPatterns.Creational.Factory.Product.Food;

public class MainStoreFront {

  public static void main(String[] args) {

    FoodMachine pizzaMachine = new PizzaMachine();
    Food pizza = pizzaMachine.createFood();

    pizza.prepare();
    pizza.serve();

    FoodMachine hotdogMachine = new HotdogMachine();

    Food hotdog = hotdogMachine.createFood();
    hotdog.prepare();
    hotdog.serve();
  }

}
