import io.appium.java_client.android.AndroidDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import utils.appiumservermanager.AppiumServerManager;
import utils.drivermanager.DriverManager;
import utils.filereader.ConfigFileReader;

public class BaseTest {
    private AndroidDriver driver;
    private final String appPackage = ConfigFileReader.getProperty("app.package");

    @BeforeClass
    public void startSession() {
        AppiumServerManager.startServer();
        driver = DriverManager.getInstance();
    }

    @BeforeMethod
    public void startApp() {
        driver.activateApp(appPackage);
    }

    @AfterMethod
    public void stopApp() {
        driver.terminateApp(appPackage);
    }

    @AfterClass
    public void stopSession() {
        driver.quit();
        AppiumServerManager.stopServer();
    }
}
