package DesignPatterns.Creational.Singleton;

// Only one instance of a class is created and used throughout the application.
public class Singleton {
  private static Singleton singleInstance;

  private Singleton(){

  }

  public static Singleton getSingleInstance(){
    if(singleInstance == null){
      // Making it thread safe.
      synchronized (Singleton.class){
        singleInstance = new Singleton();
      }
    }
    return singleInstance;
  }

  public static void printName(String name){
    System.out.println(name);
  }
}
