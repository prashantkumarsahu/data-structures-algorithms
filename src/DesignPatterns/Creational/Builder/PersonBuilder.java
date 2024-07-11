package DesignPatterns.Creational.Builder;

public class PersonBuilder extends Person {
  private String firstName;
  private String lastName;
  private int age;


  public PersonBuilder firstName(String firstName) {
    this.firstName = firstName;
    return this;
  }

  public PersonBuilder lastName(String lastName) {
    this.lastName = lastName;
    return this;
  }

  public PersonBuilder age(int age) {
    this.age = age;
    return this;
  }

  public Person build() {
    // will return the obj of base type
    Person person = new Person();

    // Set attributes on the Person object
    person.setFirstName(firstName);
    person.setLastName(lastName);
    person.setAge(age);

    return person;
  }
}
