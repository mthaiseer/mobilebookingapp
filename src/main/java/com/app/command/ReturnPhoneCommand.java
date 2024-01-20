package com.app.command;

import com.app.controller.MobileTestingController;

public class ReturnPhoneCommand implements Command {
    private MobileTestingController mobileTestingSystem;
    private String model;

    public ReturnPhoneCommand(MobileTestingController mobileTestingSystem, String model) {
        this.mobileTestingSystem = mobileTestingSystem;
        this.model = model;
    }

    @Override
    public void execute() {
        mobileTestingSystem.returnPhone(model);
    }
}