package com.example.ghost840119.datlichhen.model;

/**
 * Created by ghost840119 on 6/9/2017.
 */

public class Event {
    private String nameEvent;
    private String dataEvent;
    private String addressEvent;

    public Event() {
    }

    public Event(String nameEvent, String dataEvent, String addressEvent) {
        this.nameEvent = nameEvent;
        this.dataEvent = dataEvent;
        this.addressEvent = addressEvent;
    }

    public String getNameEvent() {
        return nameEvent;
    }

    public void setNameEvent(String nameEvent) {
        this.nameEvent = nameEvent;
    }

    public String getDataEvent() {
        return dataEvent;
    }

    public void setDataEvent(String dataEvent) {
        this.dataEvent = dataEvent;
    }

    public String getAddressEvent() {
        return addressEvent;
    }

    public void setAdrressEvent(String adrressEvent) {
        this.addressEvent = adrressEvent;
    }
}
