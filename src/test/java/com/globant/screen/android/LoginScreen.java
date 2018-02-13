package com.globant.screen.android;


import com.globant.pageobject.BaseScreen;
import com.globant.util.annottation.ScreenAndroid;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * This class represents the SplashScreenActivity.
 */
@ScreenAndroid
public class LoginScreen extends BaseScreen {

	@AndroidFindBy(id = ID + "action_button")
	private AndroidElement actionButtonSignup;

	@AndroidFindBy(id = ID + "tv_acc_link")
	private AndroidElement actionButtonSignin;

    @Autowired
	public LoginScreen(AppiumDriver<? extends MobileElement> appiumDriver) {
        super(appiumDriver);
	}

	/**
	 * Tap on "Continuar" button.
	 *
	 *
	 */
	public void tapOnContinue() {
		click(actionButtonSignup);
	}

	/**
	 * Tap on "¿Ya tienes una cuenta?" option.
	 *
	 *
	 */
	public void tapOnDoYouAlreadyHaveAnAccount() {
		click(actionButtonSignin);
	}

}
