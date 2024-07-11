package DesignPatterns.Behavioral.Strategy;

public class GameContext {
  private DifficultyLevelStrategy difficultyLevelStrategy;
  // Context delegates the responsiblity of the operation (setting difficulty level) to concrete strategy classes;

  // uses constructor injection.
  public GameContext(DifficultyLevelStrategy difficultyLevelStrategy){
    this.difficultyLevelStrategy = difficultyLevelStrategy;
  }

  public void setDifficultyLevelStrategy(DifficultyLevelStrategy difficultyLevelStrategy) {
    this.difficultyLevelStrategy = difficultyLevelStrategy;
  }

  public void startGame(){
    difficultyLevelStrategy.modifyGameRules();
  }

  public void endGame(){
    System.out.println("End Game with strategy = " + difficultyLevelStrategy.getStrategyName());
  }
}
