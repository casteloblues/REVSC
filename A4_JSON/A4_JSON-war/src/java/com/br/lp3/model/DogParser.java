/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.lp3.model;

import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;
import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.json.JsonReader;

/**
 *
 * @author Castelo
 */
public class DogParser {
    
    public static List<Dog> parseFeed(String content) {
        List<Dog> dogs = new ArrayList<>();
    
        JsonReader jsonRd = Json.createReader(new StringReader(content));
        JsonObject jsonOb = jsonRd.readObject();
        jsonRd.close();
        
        JsonArray dogs2 = jsonOb.getJsonArray("dogs");
//        JsonArray results = data.getJsonArray("results");
        
        for (int i = 0; i < dogs2.size(); i++) {
            JsonObject d = dogs2.getJsonObject(i);
            
            String photo = d.getString("photo");
            String name = d.getString("name");
            String age = d.getString("age");
            String race = d.getString("race");
            String city = d.getString("city");
            String desc = d.getString("description");
            
            JsonObject state = d.getJsonObject("state");
            String st_name = state.getString("name");
            String st_initials = state.getString("initials");
            
            JsonObject country = d.getJsonObject("country");
            String country_name = country.getString("name");
            String country_initials = country.getString("initials");
            
            State st = new State(st_name, st_initials);
            Country c = new Country(country_name, country_initials);
            
            Dog dog = new Dog(photo, name, age, race, city, st, desc);
            dogs.add(dog);
        }
        return dogs;
    }
}
