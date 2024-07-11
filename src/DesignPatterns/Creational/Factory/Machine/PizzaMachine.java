package DesignPatterns.Creational.Factory.Machine;

import DesignPatterns.Creational.Factory.Product.Food;
import DesignPatterns.Creational.Factory.Product.Pizza;

public class PizzaMachine implements FoodMachine {

  @Override
  public Food createFood() {
    return new Pizza();
  }
}
