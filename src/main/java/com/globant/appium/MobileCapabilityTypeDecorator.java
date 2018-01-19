package com.globant.appium;

import io.appium.java_client.remote.MobileCapabilityType;

public interface MobileCapabilityTypeDecorator extends MobileCapabilityType {
    String XCODE_ORG_ID = "xcodeOrgId";
    String BUNDLE_ID = "bundleid";
    String XCODE_SIGNIN_ID = "xcodeSigningId";
    String APP_PACKAGE = "appPackage";
    String APP_ACTIVITY = "appActivity";
}
