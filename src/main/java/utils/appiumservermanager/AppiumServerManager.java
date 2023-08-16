package utils.appiumservermanager;

import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import utils.filereader.ConfigFileReader;

public class AppiumServerManager {
    private static AppiumDriverLocalService service;

    public static void startServer() {
        if (service == null) {
            service = new AppiumServiceBuilder()
                    .withIPAddress(ConfigFileReader.getProperty("ip"))
                    .usingPort(Integer.parseInt(ConfigFileReader.getProperty("port")))
                    .build();
        }
        service.start();
    }

    public static void stopServer() {
        if (service != null) {
            service.stop();
        }
    }
}
