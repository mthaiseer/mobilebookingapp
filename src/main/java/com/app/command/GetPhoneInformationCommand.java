package com.app.command;

import com.app.controller.MobileTestingController;

public class GetPhoneInformationCommand implements Command {
    private final MobileTestingController mobileTestingController;
    private final String model;

    public GetPhoneInformationCommand(MobileTestingController mobileTestingController, String model) {
        this.mobileTestingController = mobileTestingController;
        this.model = model;
    }

    @Override
    public void execute() {
        System.out.println(mobileTestingController.getPhoneInformation(model));
    }
}