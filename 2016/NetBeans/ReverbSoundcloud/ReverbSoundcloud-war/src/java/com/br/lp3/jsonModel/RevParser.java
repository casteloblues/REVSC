/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.lp3.jsonModel;

import com.br.lp3.entities.InstREVSC;
import com.br.lp3.entities.Photo;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonNumber;
import javax.json.JsonObject;
import javax.json.JsonReader;

/**
 *
 * @author Castelo
 */
public class RevParser {

    public static List<InstREVSC> parse(String content) {
        List<InstREVSC> instruments = new ArrayList<>();
        
        JsonReader jsonRD = Json.createReader(new StringReader(content));
        JsonObject jsonOB = jsonRD.readObject();
        jsonRD.close();
        
        int all = jsonOB.getInt("total");                   //utilizado para conferência na aba glassfish
        System.out.println("numero total de itens= " + all);
        
        JsonArray instruments2 = jsonOB.getJsonArray("listings");
        System.out.println("tamanho instruments2= " + instruments2.size());
        
        for (int i = 0; i < all; i++) {
            JsonObject inst = (JsonObject) instruments2.get(i);
            
            int id = inst.getInt("id");
            String make = inst.getString("make");
            String model = inst.getString("model");
            String finish = inst.getString("finish");
            String year = inst.getString("year");
            String title = inst.getString("title");
            String description = inst.getString("description");

            JsonObject links = inst.getJsonObject("_links");
            JsonObject photo = links.getJsonObject("photo");
            
            
            String phref = photo.getString("href");

            Photo p = new Photo(phref);

            InstREVSC instRev = new InstREVSC(id, p, make, model, finish, year, title, description);
            instruments.add(instRev);
        }
        
        for (int j = 0; j < all; j++) {
            System.out.println(j);
            System.out.println(instruments.get(j).getTitle());
        }
        return instruments;
    }
}
