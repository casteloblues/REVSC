/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.lp3.jsonModel;

import com.br.lp3.entities.InstREVSC;
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
public class RevParser {

    public static List<InstREVSC> parseFeed(String content) {
        List<InstREVSC> instruments = new ArrayList<>();

        JsonReader jsonRD = Json.createReader(new StringReader(content));
        JsonObject jsonOB = jsonRD.readObject();
        jsonRD.close();
        JsonArray instruments2 = jsonOB.getJsonArray("instruments");

        for (int i = 0; i <= instruments2.size(); i++) {
            JsonObject inst = instruments2.getJsonObject(i);

            String photo = inst.getString("photo");
            String id = inst.getString("id");
            String make = inst.getString("make");
            String model = inst.getString("model");
            String finish = inst.getString("finish");
            String year = inst.getString("year");
            String title = inst.getString("title");
            String description = inst.getString("description");
            
            InstREVSC instRev = new InstREVSC(id, photo, make, model, finish, year, title, description);
            instruments.add(instRev);
        }
        return instruments;
    }
}
