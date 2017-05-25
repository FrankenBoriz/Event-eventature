package com.event.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Created by Boris on 19.05.2017.
 */
@Entity
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String eventName;
    private String date;
    private String city;

    public String getEventName () { return eventName; }

    public void setEventName() { this.eventName = eventName; }

    public String getDate () { return date; }

    public void setDate () { this.date = date; }

    public String getCity () { return city; }

    public void setCity () { this.city = city; }



            //API-Key  DXHCGjAhb8CoHb0qzeB6Pf2dDLme2WWa
}
