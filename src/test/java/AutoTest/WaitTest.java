package AutoTest;

import HelpMethods.ElementMethods;
import SharedData.SharedData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;


public class WaitTest extends SharedData {

    @Test
    public void waitButoon () {

        ElementMethods elementMethods = new ElementMethods(getWebDriver());

        WebElement ajaxButton = getWebDriver().findElement(By.xpath("//a[text()='AJAX Data']"));
        elementMethods.scrollElementByPixel(0,350);
        elementMethods.clickElement(ajaxButton);

        WebElement waitButton = getWebDriver().findElement(By.id("ajaxButton"));
        elementMethods.clickElement(waitButton);

        Duration timeout = Duration.ofSeconds(15);
        WebDriverWait  wait = new WebDriverWait(getWebDriver(), timeout);
        WebElement delaymessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("p.bg-success")));
        String delayMessage = delaymessage.getText();
        System.out.println("The delay text is: " + delayMessage);
        Assert.assertEquals(delaymessage.getText(),"Data loaded with AJAX get request.");
    }
}
