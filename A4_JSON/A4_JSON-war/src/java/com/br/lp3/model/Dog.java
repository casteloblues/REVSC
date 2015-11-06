/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.lp3.model;

/**
 *
 * @author Castelo
 */
public class Dog {
    private String photo;
    private String name;
    private String external_url;
    private String description;
    private String age;
    private String race;
    private String city;

    public Dog() {}

    Dog(String photo, String name, String age, String race, String city, State st, String desc) {
        this.photo = photo;
        this.name = name;
        this.age = age;
        this.race = race;
        this.city = city;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getExternal_url() {
        return external_url;
    }

    public void setExternal_url(String external_url) {
        this.external_url = external_url;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getRace() {
        return race;
    }

    public void setRace(String race) {
        this.race = race;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }
    
    @Override
    public String toString() {
        return "Dog{" + "name=" + name + ", external_url=" + external_url + ", description=" + description + ", age=" + age + ", race=" + race + ", city=" + city + '}';
    }
}
