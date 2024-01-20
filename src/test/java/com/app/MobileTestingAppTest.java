package com.app;


import com.app.controller.MobileTestingController;

import com.app.model.Phone;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(classes = MobileTestingController.class)
public class MobileTestingAppTest {

    @Autowired
    private MobileTestingController mobileTestingSystem;

    @BeforeEach
    public void setUp() {

    }

    @Test
    public void testBookPhoneSuccess() {
        mobileTestingSystem.bookPhone("Samsung Galaxy S8", "Tester1");
        Phone bookedPhone = mobileTestingSystem.getPhone("Samsung Galaxy S8");

        assertFalse(bookedPhone.isAvailable());
        assertEquals("Tester1", bookedPhone.getBookedBy());
        assertNotNull(bookedPhone.getBookedTime());
    }

    @Test
    public void testBookPhoneFailure() {
        // Try to book an already booked phone
        mobileTestingSystem.bookPhone("Apple iPhone 11", "Tester2");
        Phone initiallyBookedPhone = mobileTestingSystem.getPhone("Apple iPhone 11");

        assertFalse(initiallyBookedPhone.isAvailable());
        assertNotNull(initiallyBookedPhone.getBookedTime());

        // Attempt to book the same phone again
        mobileTestingSystem.bookPhone("Apple iPhone 11", "Tester3");
        Phone rebookedPhone = mobileTestingSystem.getPhone("Apple iPhone 11");

        assertFalse(rebookedPhone.getBookedBy().equals("Tester3"));

    }

    @Test
    public void testReturnPhoneSuccess() {
        // Book a phone and then return it
        mobileTestingSystem.bookPhone("Oneplus 9", "Tester4");
        mobileTestingSystem.returnPhone("Oneplus 9");
        Phone returnedPhone = mobileTestingSystem.getPhone("Oneplus 9");

        assertTrue(returnedPhone.isAvailable());
        assertNull(returnedPhone.getBookedBy());
        assertNull(returnedPhone.getBookedTime());
    }

    @Test
    public void testReturnPhoneFailure() {
        // Try to return a phone that was not booked
        mobileTestingSystem.returnPhone("Motorola Nexus 6");
        Phone notBookedPhone = mobileTestingSystem.getPhone("Motorola Nexus 6");

        assertTrue(notBookedPhone.isAvailable());
        assertNull(notBookedPhone.getBookedBy());
        assertNull(notBookedPhone.getBookedTime());

        // Book a phone and try to return a different one
        mobileTestingSystem.bookPhone("iPhone X", "Tester5");
        mobileTestingSystem.returnPhone("Samsung Galaxy S9");
        Phone wrongReturnedPhone = mobileTestingSystem.getPhone("iPhone X");

        assertFalse(wrongReturnedPhone.isAvailable());
        assertEquals("Tester5", wrongReturnedPhone.getBookedBy());
        assertNotNull(wrongReturnedPhone.getBookedTime());
    }

    @Test
    public void testGetPhoneInformation() {
        // Arrange: Book a phone for testing
        mobileTestingSystem.bookPhone("Samsung Galaxy S9", "Tester1");

        // Act: Call getPhoneInformation
        String phoneInformation = mobileTestingSystem.getPhoneInformation("Samsung Galaxy S9");

        // Assert: Check if the returned information is as expected
        String expectedOutput = "Phone Information for Samsung Galaxy S9:\n" +
                "Availability: No\n" +
                "Booked Time: " + new SimpleDateFormat("EEE MMM dd HH:mm:ss z yyyy").format(new Date()) + "\n" +
                "Booked By: Tester1\n";
        assertEquals(expectedOutput.trim(), phoneInformation.trim());
    }

    @Test
    public void testGetPhoneInformationNotFound() {
        // Arrange: No phones booked initially

        // Act: Call getPhoneInformation for a non-existing phone
        String phoneInformation = mobileTestingSystem.getPhoneInformation("NonExistentPhone");

        // Assert: Check if the returned information is as expected
        assertEquals("Phone not found.", phoneInformation);
    }

    @Test
    public void testGetPhoneInformationAvailable() {
        // Arrange: Phone is available, not booked

        // Act: Call getPhoneInformation for an available phone
        String phoneInformation = mobileTestingSystem.getPhoneInformation("Oneplus 9");

        // Assert: Check if the returned information is as expected
        String expectedOutput = "Phone Information for Oneplus 9:\n" +
                "Availability: Yes\n" +
                "Booked Time: N/A\n" +
                "Booked By: N/A\n";
        assertEquals(expectedOutput.trim(), phoneInformation.trim());
    }

}
