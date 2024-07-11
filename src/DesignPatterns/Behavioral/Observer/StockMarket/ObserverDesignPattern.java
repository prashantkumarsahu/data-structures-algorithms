package DesignPatterns.Behavioral.Observer.StockMarket;

public class ObserverDesignPattern {

  public static void main(String[] args) {

    // 4 components: Subject (Observable), Observer, ConcreteSubject, ConcreteObserver
    // Whenever subject undergoes change in state, the observers are notified

    /* 1. Subject = Stock Market
       2. Observers = Investors, Traders
       3.
     */
    StockMarketObservable stockMarket = new StockMarketObservableImpl();

    StockObserver investor1 = new RetailInvestor("Prashant");
    StockObserver trader1 = new Trader("Ankit");

    stockMarket.registerObserver(investor1);
    stockMarket.registerObserver(trader1);

    stockMarket.setStockPrice("INFY", 1250.0);
    stockMarket.setStockPrice("TCS", 2500.0);

    stockMarket.removeObserver(investor1);

    stockMarket.setStockPrice("WIPRO", 3500.0);
  }
}
