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
        String data2 = null;
        String data3 = null;
        String data4 = null;
        String data5 = null;

        String sumOfData = null;

        int size = 0;
        JsonObject jo = null;

        String sURL1 = "https://app.ticketmaster.com/discovery/v2/events.json?apikey=DXHCGjAhb8CoHb0qzeB6Pf2dDLme2WWa";

        try {

            URL url1 = new URL(sURL1);
            HttpURLConnection request1 = (HttpURLConnection) url1.openConnection();
            request1.connect();

            JsonParser jp = new JsonParser();
            JsonElement root = jp.parse(new InputStreamReader((InputStream) request1.getContent()));
            JsonObject rootobj = root.getAsJsonObject();

            //EventData
            data = rootobj.getAsJsonObject("_embedded").getAsJsonArray("events")
                    .getAsJsonArray().get(0).getAsJsonObject().get("name").getAsString();

            data2 = rootobj.getAsJsonObject("_embedded").getAsJsonArray("events")
                    .getAsJsonArray().get(0).getAsJsonObject().get("id").getAsString();


            //VenueData
            data3 = rootobj.getAsJsonObject("_embedded").getAsJsonArray("events")
                    .getAsJsonArray().get(0).getAsJsonObject().get("_embedded")
                    .getAsJsonObject().get("venues").getAsJsonArray().get(0).getAsJsonObject()
                    .get("name").getAsString();

            data4 = rootobj.getAsJsonObject("_embedded").getAsJsonArray("events")
                    .getAsJsonArray().get(0).getAsJsonObject().get("_embedded")
                    .getAsJsonObject().get("venues").getAsJsonArray().get(0).getAsJsonObject().get("city").getAsJsonObject().get("name").getAsString();

            data5 = rootobj.getAsJsonObject("_embedded").getAsJsonArray("events")
                    .getAsJsonArray().get(0).getAsJsonObject().get("_embedded")
                    .getAsJsonObject().get("venues").getAsJsonArray().get(0).getAsJsonObject().get("country").getAsJsonObject().get("name").getAsString();


            //SumData
            sumOfData ="<h1>Event</h1>" +
                    "<h2>Event nr: 0</h2>" +
                    "<h3>Event name: </h3>" + data +
                    "<br/>" + "<h3>Event ID: </h3> "+ data2  +
                    "<br/>" + "<h3>Venue Name: </h3>" + data3 +
                    "<br/>" + "<h3>City: </h3>" + data4 +
                    "<br/>" + "<h3>Country: </h3>" + data5;

            request1.disconnect();

        }
        catch(Exception e){}

        return sumOfData;
    }

    @RequestMapping("/test")
    public String test(){


        return "TestPage 'hello world!'";

    }
}
