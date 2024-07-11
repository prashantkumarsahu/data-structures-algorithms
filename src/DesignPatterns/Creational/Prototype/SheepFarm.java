
package DesignPatterns.Creational.Prototype;

public class SheepFarm {


  public static void main(String[] args) {
    Sheep blackPrototype = new BlackSheep("Black Black");
    Sheep whitePrototype = new WhiteSheep("White White");

    System.out.println(blackPrototype.getName());
    Sheep cloneBlackSheep = blackPrototype.clone();
    cloneBlackSheep.setName("Clone Black Black");
    System.out.println(cloneBlackSheep.getName());

    Sheep cloneWhiteSheep = whitePrototype.clone();
  }

  /* ****************************************************************
   Advantages:
   1. Code reuse = Esp. for complex initialization
   2. Reduced Initialization = no need to initialize new objects having same properties, except 1 or 2
   3. Flexible objects = Can change specific properties
   4. Code Maintenance = Less code to maintain, as object is created using only 1 line
   5. Code readability

   Disadvantages
   1. Shallow vs Deep copy: If Concrete impl class has a nested class, then Deep copy is necessary.
   2. Object serialization
   3. Object state
   4. Multiple Concrete Impl classes needed for different clones;
  */




}
