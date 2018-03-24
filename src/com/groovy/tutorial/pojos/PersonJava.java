package com.groovy.tutorial.pojos;

/**
 * Simple POJO
 */
public class PersonJava {

    //private fields
    private String firstName;
    private String lastName;
    private long phone;
    private int age;
    private String email;


    //no-args constructor
    public PersonJava(){

    }

    public PersonJava(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public PersonJava(String firstName, String lastName, long phone, int age, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.age = age;
        this.email = email;
    }
    

    //getters and setter (Boiler plate code)
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public long getPhone() {
        return phone;
    }

    public void setPhone(long phone) {
        this.phone = phone;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "PersonJava{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }

    public void sendMail(String message){
        System.out.println("Message sent!");
    }
}
