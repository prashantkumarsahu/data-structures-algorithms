package DesignPatterns.Behavioral.Strategy;

public class MediumLevel implements DifficultyLevelStrategy{
  
  @Override
  public void modifyGameRules() {
    System.out.println("Medium level Mode On. Time limit decreased. Scoring complex");
  }

  @Override
  public String getStrategyName(){
    return "Medium";
  }
}
