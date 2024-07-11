package DesignPatterns.Behavioral.Strategy;

public class StrategyDesignPatterns {
  // Create a family of strategies:
  // 1. Difficulty Level
  // 2. Scoring Criteria etc.

  public static void main(String[] args) {

    // 3 components: Context, Strategy, Concrete Strategy

    GameContext game1 = new GameContext(new EasyLevel());

    game1.startGame(); // Play with easy mode

    game1.setDifficultyLevelStrategy(new MediumLevel());

    game1.startGame();

    game1.setDifficultyLevelStrategy(new HardLevel());

    game1.startGame();

    game1.setDifficultyLevelStrategy(new EasyLevel());

    game1.endGame();
  }
}
