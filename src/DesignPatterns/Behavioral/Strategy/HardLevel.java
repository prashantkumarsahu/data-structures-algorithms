package DesignPatterns.Behavioral.Strategy;

public class HardLevel implements DifficultyLevelStrategy{
  
  @Override
  public void modifyGameRules() {
    System.out.println("Hard level Mode On. Time limit minimum. Scoring most complex");
  }

  @Override
  public String getStrategyName(){
    return "Hard";
  }
}
