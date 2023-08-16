package utils.desiredcapsmanager;

import io.appium.java_client.remote.AutomationName;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.remote.DesiredCapabilities;
import utils.filereader.ConfigFileReader;

public class DesiredCapabilitiesManager {
    public static DesiredCapabilities getDesiredCapabilities() {
        DesiredCapabilities capabilities = new DesiredCapabilities ();
        capabilities.setCapability (MobileCapabilityType.PLATFORM_NAME, Platform.ANDROID);
        capabilities.setCapability (MobileCapabilityType.DEVICE_NAME, ConfigFileReader.getProperty("device.name"));
        capabilities.setCapability (MobileCapabilityType.AUTOMATION_NAME, AutomationName.ANDROID_UIAUTOMATOR2);
        capabilities.setCapability ("appPackage", ConfigFileReader.getProperty("app.package"));
        capabilities.setCapability ("appActivity", ConfigFileReader.getProperty("app.activity"));
        capabilities.setCapability ("noReset", false);
        return capabilities;
    }
}
