package DesignPatterns.Creational.Builder;

public class MainBuilder {

  public static void main(String[] args) {

    Person personHarry = new PersonBuilder()
        .age(12)
        .firstName("Harry")
        .lastName("Potter")
        .build();

    System.out.println(personHarry.getFirstName());

  }
}
