package com.event.controllers;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

/**
 * Created by Boris on 19.05.2017.
 */
@RestController
public class EventController {

    @RequestMapping(value="/event")
    public String showEvent(){

        String data = null;
        int size = 0;
        JsonObject jo = null;

        String sURL1 = "https://app.ticketmaster.com/discovery/v2/events.json?apikey=DXHCGjAhb8CoHb0qzeB6Pf2dDLme2WWa";

        try {
            /*
            URL url = new URL(sURL1);
            HttpURLConnection request1 = (HttpURLConnection) url.openConnection();
            request1.connect();

            JsonParser jp = new JsonParser();
            JsonElement root = jp.parse(new InputStreamReader((InputStream) request1.getContent()));
            JsonArray rootobj = root.getAsJsonArray();
            data = rootobj.get(0).getAsJsonObject().toString();

            request1.disconnect();
            */



            URL url1 = new URL(sURL1);
            HttpURLConnection request1 = (HttpURLConnection) url1.openConnection();
            request1.connect();

            JsonParser jp = new JsonParser();
            JsonElement root = jp.parse(new InputStreamReader((InputStream) request1.getContent()));
            JsonArray rootobj = root.getAsJsonArray();
            data = jo.getAsJsonObject("_embedded").getAsJsonArray("events").getAsJsonArray().get(0).getAsJsonObject().toString();


            jo = root.getAsJsonObject();

            request1.disconnect();

        }
        catch(Exception e){}

        return data;
    }

    @RequestMapping("/test")
    public String test(){


        return "TestPage 'hello world!'";

    }
}
