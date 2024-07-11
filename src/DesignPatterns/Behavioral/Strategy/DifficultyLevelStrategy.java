package DesignPatterns.Behavioral.Strategy;

public interface DifficultyLevelStrategy {
 // Could be interface or abstract class
  void modifyGameRules();

  String getStrategyName();
}
