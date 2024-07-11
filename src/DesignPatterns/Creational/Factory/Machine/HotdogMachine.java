package DesignPatterns.Creational.Factory.Machine;

import DesignPatterns.Creational.Factory.Product.Food;
import DesignPatterns.Creational.Factory.Product.Hotdog;

public class HotdogMachine implements FoodMachine {
  @Override
  public Food createFood() {
    return new Hotdog();
  }
}
