package org.example.usergenerationapi.Model;

import net.datafaker.Faker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

public class Person {

    private String firstName;
    private String lastName;
    private String email;
    private String language;
    private String address;
    private String country;
    private String university;
    private String phoneNumber;
    private String gender;
    private String job;
    private String company;
    private Date bd;
    private String pet;
    private String transport;
    private String favCoffee;
    private String favBook;

    public Person(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setUniversity(String university) {
        this.university = university;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public void setBd(Date bd) {
        this.bd = bd;
    }

    public void setPet(String pet) {
        this.pet = pet;
    }

    public void setTransport(String transport) {
        this.transport = transport;
    }

    public void setFavCoffee(String favCoffee) {
        this.favCoffee = favCoffee;
    }

    public void setFavBook(String favBook) {
        this.favBook = favBook;
    }

    @Override
    public String toString() {
        return "Person{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", language='" + language + '\'' +
                ", address='" + address + '\'' +
                ", country='" + country + '\'' +
                ", university='" + university + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", gender='" + gender + '\'' +
                ", job='" + job + '\'' +
                ", company='" + company + '\'' +
                ", bd=" + bd +
                ", pet='" + pet + '\'' +
                ", transport='" + transport + '\'' +
                ", favCoffee='" + favCoffee + '\'' +
                ", favBook='" + favBook + '\'' +
                '}';
    }
}
