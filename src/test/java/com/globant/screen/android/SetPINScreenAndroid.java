package com.globant.screen.android;

import com.globant.pageobject.BaseScreen;
import com.globant.util.ScreenFactory;
import com.globant.util.annottation.ScreenAndroid;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@ScreenAndroid
public class SetPINScreenAndroid extends BaseScreen {

    @Autowired
    private ScreenFactory screenFactory;

    @Autowired
    public SetPINScreenAndroid(AppiumDriver<? extends MobileElement> appiumDriver) {
        super(appiumDriver);
    }

    public <T extends BaseScreen> T writePIN(String nameBean, List<String> pin) {
        pin.stream()
                .forEach(n -> {
                    click(n);
                });
        return screenFactory.getScreen(nameBean);
    }
}
