package com.app.model;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Phone {

    private String model;
    private boolean available;
    private String bookedBy;
    private Date bookedTime;

    public Phone(String model) {
        this.model = model;
        this.available = true;
    }

    public boolean isAvailable() {
        return available;
    }

    public void book(String user) {
        available = false;
        bookedBy = user;
        bookedTime = new Date();
    }

    public void returnPhone() {
        available = true;
        bookedBy = null;
        bookedTime = null;
    }

    public String getModel() {
        return model;
    }

    public String getBookedBy() {
        return bookedBy;
    }

    public Date getBookedTime() {
        return bookedTime;
    }

    public String getBookedTimeString() {
        if (bookedTime != null) {
            return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(bookedTime);
        }
        return null;
    }

    @Override
    public String toString() {
        return model + " - Availability: " + (available ? "Yes" : "No") +
                (available ? "" : ", Booked by: " + bookedBy + ", Booked at: " + bookedTime);
    }

}



