package com.app.controller;

import com.app.datastore.PhoneStore;
import com.app.model.Phone;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

@Component
public class MobileTestingController {

    // Singleton instance used to get phone records
    private final Map<String, Phone> phoneInventory = PhoneStore.getInstance().getPhoneInventory();
    private final Lock lock = new ReentrantLock();

    public void bookPhone(String model, String user) {
        lock.lock();
        try {
            Phone phone = phoneInventory.get(model);
            if (phone != null && phone.isAvailable()) {
                phone.book(user);
                System.out.println(user + " booked " + model + " at " + phone.getBookedTime());
            } else {
                System.out.println("Sorry, " + model + " is not available for booking.");
            }
        } finally {
            lock.unlock();
        }
    }

    public void returnPhone(String model) {
        lock.lock();
        try {
            Phone phone = phoneInventory.get(model);
            if (phone != null && !phone.isAvailable()) {
                phone.returnPhone();
                System.out.println(model + " has been returned.");
            } else {
                System.out.println(model + " was not booked, cannot be returned.");
            }
        } finally {
            lock.unlock();
        }
    }

    public void displayInventory() {
        lock.lock();
        try {
            System.out.println("Mobile Testing System Inventory:");
            for (Phone phone : phoneInventory.values()) {
                System.out.println(phone);
            }
        } finally {
            lock.unlock();
        }
    }

    public Phone getPhone(String model) {
        lock.lock();
        try {
            return phoneInventory.get(model);
        } finally {
            lock.unlock();
        }
    }

    public String getPhoneInformation(String model) {
        lock.lock();
        try {
            Phone phone = phoneInventory.get(model);
            if (phone != null) {
                return "Phone Information for " + model + ":\n" +
                        "Availability: " + (phone.isAvailable() ? "Yes" : "No") + "\n" +
                        "Booked Time: " + (phone.isAvailable() ? "N/A" : phone.getBookedTime()) + "\n" +
                        "Booked By: " + (phone.isAvailable() ? "N/A" : phone.getBookedBy());
            } else {
                return "Phone not found.";
            }
        } finally {
            lock.unlock();
        }
    }
}
