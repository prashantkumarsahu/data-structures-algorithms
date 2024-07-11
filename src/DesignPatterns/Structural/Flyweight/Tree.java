package DesignPatterns.Structural.Flyweight;


class Tree implements GameObject {

  // Concrete object to render
  private final String type;

  public Tree(String type) {
    this.type = type;
  }

  @Override
  public void render(String player) {
    System.out.println("Rendering a " + type + " for player " + player);
  }
}