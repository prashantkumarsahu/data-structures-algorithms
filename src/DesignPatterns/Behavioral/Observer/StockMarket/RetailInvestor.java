package DesignPatterns.Behavioral.Observer.StockMarket;

public class RetailInvestor implements StockObserver{

  private String name;

  public RetailInvestor(String name){
    this.name = name;
  }
  @Override
  public void update(String stockSymbol, Double price) {
    System.out.println("Hello Retail Investor " + name + ", " + stockSymbol + " has a price of " + price.toString());
  }
}
