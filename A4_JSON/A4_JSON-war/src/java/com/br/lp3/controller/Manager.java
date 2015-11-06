/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.lp3.controller;

import com.br.lp3.model.Dog;
import com.br.lp3.model.DogParser;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Castelo
 */
public class Manager {
    
    private static final String urlBase = "http://pedrocacique.com/lp3/getAllPets/";
    
    public static List<Dog> teste() {
        List<Dog> listaDogs = new ArrayList<>();
        
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("MMddyyyyhhmmss");
        String ts = sdf.format(date);
        
        String hashStr = MD5(ts);
        String uri = urlBase + "&ts" + ts + "&hash=" + hashStr;
        URL url;
        
        
        try {
            url = new URL(urlBase);
            
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            
            BufferedReader bf = new BufferedReader(new InputStreamReader(con.getInputStream()));
            
            StringBuilder sb = new StringBuilder();
            String line;
            
            while((line = bf.readLine()) != null) {
                sb.append(line);
            }
            bf.close();
            
            con.disconnect();
            listaDogs = DogParser.parseFeed(sb.toString());
        } catch (MalformedURLException ex) {
            Logger.getLogger(Manager.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Manager.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return listaDogs;
    }
    
    /**
     * Método para criptografia de uma String com método MD5
     * @param md5
     * @return 
     */
    public static String MD5(String md5) {
        try {
             java.security.MessageDigest md = java.security.MessageDigest.getInstance("MD5");
             byte[] array = md.digest(md5.getBytes());
             StringBuffer sb = new StringBuffer();
             for (int i = 0; i < array.length; ++i) {
               sb.append(Integer.toHexString((array[i] & 0xFF) | 0x100).substring(1,3));
            }
             return sb.toString();
         } catch (java.security.NoSuchAlgorithmException e) {
         }
         return null;
    }
}
