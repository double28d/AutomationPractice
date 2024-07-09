package HelpMethods;

import SharedData.SharedData;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class FrameMethods {

    private WebDriver webDriver;

    public FrameMethods(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public void switchSpecificiFrame(String value){
        webDriver.switchTo().frame(value);
    }

    public void switchToParentiFrame(){
        webDriver.switchTo().parentFrame();
    }
}
