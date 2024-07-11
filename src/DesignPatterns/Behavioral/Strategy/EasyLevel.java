package DesignPatterns.Behavioral.Strategy;

public class EasyLevel implements DifficultyLevelStrategy{
  // Concrete strategy implementing the strategy interface
  @Override
  public void modifyGameRules() {
    System.out.println("Easy level Mode On. Time limit increased. Scoring simplified");
  }

  @Override
  public String getStrategyName(){
    return "Easy";
  }
}
