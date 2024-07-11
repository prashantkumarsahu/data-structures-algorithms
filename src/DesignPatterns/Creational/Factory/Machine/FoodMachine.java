package DesignPatterns.Creational.Factory.Machine;

import DesignPatterns.Creational.Factory.Product.Food;

public interface FoodMachine {

  // can be interface or abstract class

//  public abstract Food createFood();
  Food createFood();

}
