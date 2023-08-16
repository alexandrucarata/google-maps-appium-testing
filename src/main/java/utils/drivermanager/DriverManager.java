package utils.drivermanager;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import utils.desiredcapsmanager.DesiredCapabilitiesManager;
import utils.filereader.ConfigFileReader;

import java.net.MalformedURLException;
import java.net.URL;

public class DriverManager {
    private static AndroidDriver driver;

    public static AndroidDriver getInstance() {
        if (driver != null) {
            return driver;
        }
        DesiredCapabilities desiredCapabilities = DesiredCapabilitiesManager.getDesiredCapabilities();
        try {
            driver = new AndroidDriver(new URL(ConfigFileReader.getProperty("url")), desiredCapabilities);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
        return driver;
    }
}
