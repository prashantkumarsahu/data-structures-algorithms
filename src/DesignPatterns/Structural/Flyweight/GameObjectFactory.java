package DesignPatterns.Structural.Flyweight;


import java.util.HashMap;
import java.util.Map;

class GameObjectFactory {
  private final Map<String, GameObject> gameObjects = new HashMap<>();

  // if Tree object already present, return the GameObject, otherwise create a new Tree Object
  public GameObject getGameObject(String type) {
    return gameObjects.computeIfAbsent(type, Tree::new);
  }
}