package DesignPatterns.Creational.Factory.Product;


public class Hotdog implements Food {
  @Override
  public void prepare() {
    System.out.println("Prepraing hotdog");

  }

  @Override
  public void serve() {
    System.out.println("Serving hotdog");

  }
}
