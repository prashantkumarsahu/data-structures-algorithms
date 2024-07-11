package DesignPatterns.Creational.Singleton;

public class Main {

  Singleton singletonObj1 = Singleton.getSingleInstance();
  Singleton singletonObj2 = Singleton.getSingleInstance();

  // System.out.println(singletonObj1 == singletonObj2);

}
