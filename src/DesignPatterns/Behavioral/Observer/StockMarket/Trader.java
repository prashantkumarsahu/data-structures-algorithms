package DesignPatterns.Behavioral.Observer.StockMarket;

public class Trader implements StockObserver{

  private String name;

  public Trader(String name){
    this.name = name;
  }
  @Override
  public void update(String stockSymbol, Double price) {
    System.out.println("Hello Trader " + name + ", " + stockSymbol + " has a price of " + price.toString());
  }
}
