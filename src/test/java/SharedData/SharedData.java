package SharedData;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

public class SharedData {

    private WebDriver webDriver;

    @BeforeMethod
    public void prepareDriver(){
        webDriver = new ChromeDriver();
        webDriver.get("https://www.way2automation.com/demo.html");
//        webDriver.get("http://uitestingplayground.com/home");
        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @AfterMethod
    public void clearDriver(){
        webDriver.quit();
    }

    public WebDriver getWebDriver(){
        return webDriver;
    }

}
