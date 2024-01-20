package com.app.command;

import com.app.controller.MobileTestingController;
import org.springframework.beans.factory.annotation.Autowired;

public class DisplayInventoryCommand implements Command {
    @Autowired
    private MobileTestingController mobileTestingController;

    public DisplayInventoryCommand(MobileTestingController mobileTestingController) {
        this.mobileTestingController = mobileTestingController;
    }

    @Override
    public void execute() {
        mobileTestingController.displayInventory();
    }
}