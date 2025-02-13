import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.time.Duration;

public class BaseTest {
    AndroidDriver driver;
    AppiumDriverLocalService service;

    @BeforeClass
    public void configureAppium() throws IOException, InterruptedException {
        // Start the Appium server automatically
        service = new AppiumServiceBuilder().withAppiumJS(new File("/Users/hiteshmoudgil/node_modules/appium/build/lib/main.js"))
                .withIPAddress("127.0.0.1")
                .usingPort(4723)
                .build();
        service.start();

        // Set the capabilities
        UiAutomator2Options options = new UiAutomator2Options();
        options.setDeviceName("TestingEmulator");
        options.setAppPackage("com.veeva.vault.mobile");
        options.setAppActivity("veeva.vault.mobile.MainActivity");
        Thread.sleep(5000);

        // Initialize the driver
        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/"), options);

        // This is to delay the moving between screens
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
    }

    @AfterClass
    public void tearDown() {
        if(driver!=null){
            driver.quit();
        }
    }
}
