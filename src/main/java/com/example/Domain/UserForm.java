package com.example.Domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Created by waqas on 28/02/2017.
 */
@Entity
public class UserForm {
@Id
@GeneratedValue(strategy = GenerationType.AUTO)
private Integer id;

    private String firstname;
    private String lastname;
    private String email;
    private int phonenumber;
    private String address;
    private String city;
    private String state;
    private String website;
    private int zipcode;
    private String description;
    private boolean hosting;


    public UserForm(){}


    public UserForm(String firstname, String lastname, String email, int phonenumber, String address, String city, String state, String website, int zipcode, String description, boolean hosting) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.phonenumber=phonenumber;
        this.address = address;
        this.city = city;
        this.state = state;
        this.website = website;
        this.zipcode = zipcode;
        this.description = description;
        this.hosting = hosting;
    }

    public UserForm(String firstname, String lastname, String email, int phonenumber, String address, String city, String website, int zipcode, String description) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.phonenumber=phonenumber;
        this.address = address;
        this.city = city;
        this.website = website;
        this.zipcode = zipcode;
        this.description = description;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(int phonenumber) {
        this.phonenumber = phonenumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public int getZipcode() {
        return zipcode;
    }

    public void setZipcode(int zipcode) {
        this.zipcode = zipcode;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isHosting() {
        return hosting;
    }

    public void setHosting(boolean hosting) {
        this.hosting = hosting;
    }

    @Override
    public String toString() {
        return "UserForm{" +
                "id=" + id +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", email='" + email + '\'' +
                ", phonenumber=" + phonenumber +
                ", address='" + address + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", zipcode=" + zipcode +
                ", description='" + description + '\'' +
                ", hosting=" + hosting +
                '}';
    }
}
