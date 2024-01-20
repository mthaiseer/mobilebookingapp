package com.app.command;

import com.app.controller.MobileTestingController;

/**
 *  This class handles
 *
 * Author: Mohamed Thaiseer
 * Date: [Current Date]
 */
public class BookPhoneCommand implements Command {
    private MobileTestingController mobileTestingSystem;
    private String model;
    private String user;

    public BookPhoneCommand(MobileTestingController mobileTestingSystem, String model, String user) {
        this.mobileTestingSystem = mobileTestingSystem;
        this.model = model;
        this.user = user;
    }

    @Override
    public void execute() {
        mobileTestingSystem.bookPhone(model, user);
    }
}
