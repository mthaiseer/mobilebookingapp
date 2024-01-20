package com.app.datastore;

import com.app.model.Phone;

import java.util.HashMap;
import java.util.Map;

public class PhoneStore {



    // Private static instance variable
    private static final PhoneStore instance = new PhoneStore();

    // Map to store phones
    private Map<String, Phone> phoneInventory = new HashMap<>();

    // Private constructor to prevent instantiation from outside
    private PhoneStore() {
        // Initialize phone inventory in the constructor
        phoneInventory.put("Samsung Galaxy S9", new Phone("Samsung Galaxy S9"));
        phoneInventory.put("Samsung Galaxy S8", new Phone("Samsung Galaxy S8"));
        phoneInventory.put("Motorola Nexus 6", new Phone("Motorola Nexus 6"));
        phoneInventory.put("Oneplus 9", new Phone("Oneplus 9"));
        phoneInventory.put("Apple iPhone 13", new Phone("Apple iPhone 13"));
        phoneInventory.put("Apple iPhone 12", new Phone("Apple iPhone 12"));
        phoneInventory.put("Apple iPhone 11", new Phone("Apple iPhone 11"));
        phoneInventory.put("iPhone X", new Phone("iPhone X"));
        phoneInventory.put("Nokia 3310", new Phone("Nokia 3310"));
    }

    // Public method to access the singleton instance
    public static PhoneStore getInstance() {
        return instance;
    }

    // Public method to access the phone inventory
    public Map<String, Phone> getPhoneInventory() {
        return phoneInventory;
    }




}
