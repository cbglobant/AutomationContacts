package com.globant.appium;

import com.globant.util.EnumPlataform;
import org.aeonbits.owner.Config;
import org.aeonbits.owner.Config.Sources;

@Sources("file:src/main/resources/appium.properties")
public interface AppiumConfig extends Config {

    @Key("run.enviroment")
    @DefaultValue("false")
    Boolean isRunEnviroment();

    @Key("automationName")
    @DefaultValue("Appium")
    String automationName();

    @Key("device.name")
    @DefaultValue("${device.name}")
    String deviceName();

    @Key("device.udid")
    String udid();

    @Key("platform")
    @DefaultValue("ANDROID")
    EnumPlataform platform();

    @Key("platform.version")
    @DefaultValue("")
    String platformVersion();

    @Key("clearSystemFiles")
    @DefaultValue("true")
    Boolean clearSystemFiles();

    @Key("app")
    @DefaultValue("${app}")
    String app();

    @Key("app.noReset")
    @DefaultValue("true")
    Boolean isAppNoReset();

    @Key("app.fullReset")
    @DefaultValue("true")
    Boolean isAppFullReset();

    @Key("appium.server.ip")
    @DefaultValue("127.0.0.1")
    String appiumServerIp();

    @Key("appium.server.port")
    @DefaultValue("4723")
    int appiumServerPort();

    @Key("appium.new.command.timeout")
    @DefaultValue("120")
    int newCommandTimeout();

    @Key("appium.timeout")
    @DefaultValue("60")
    int timeout();

    @Key("android.app.package")
    String appPackage();

    @Key("android.app.activity")
    String appActivity();

    @Key("ios.app.bundleid")
    String bundleid();

    @Key("ios.app.xcodeOrgId")
    String xcodeOrgId();

    @Key("ios.app.xcodeSigningId")
    String xcodeSigningId();

    @Key("ios.app.showXcodeLog")
    @DefaultValue("true")
    Boolean showXcodeLog();
}
