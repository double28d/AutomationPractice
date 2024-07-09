package AutoTest;

import HelpMethods.AlertMethods;
import HelpMethods.ElementMethods;
import HelpMethods.FrameMethods;
import HelpMethods.WindowMethods;
import SharedData.SharedData;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class Alerts extends SharedData{

    @Test
    public void alerts(){
        ElementMethods elementMethods = new ElementMethods(getWebDriver());
        WindowMethods windowMethods = new WindowMethods(getWebDriver());
        FrameMethods frameMethods = new FrameMethods(getWebDriver());
        AlertMethods alertMethods = new AlertMethods(getWebDriver());

        WebElement interactionButton = getWebDriver().findElement(By.xpath("//a[text()='Alert']"));
        elementMethods.clickElement(interactionButton);

        windowMethods.switchSpecificTabWindow(1);

        WebElement enterTestLink = getWebDriver().findElement(By.xpath("//div[@id='load_box']//div[@class='span_3_of_4']/p/a[text()='ENTER TO THE TESTING WEBSITE']"));
        elementMethods.clickElement(enterTestLink);

        elementMethods.scrollElementByPixel(0,450);

        WebElement alertElement = getWebDriver().findElement(By.xpath("//h2[text()='Alert']"));
        elementMethods.clickElement(alertElement);

        windowMethods.switchSpecificTabWindow(2);

        getWebDriver().switchTo().frame(getWebDriver().findElements(By.cssSelector("iframe.demo-frame")).get(0));

        WebElement simpleAlert =getWebDriver().findElement(By.xpath("//button[text()='Click the button to display an alert box:']"));
        elementMethods.clickElement(simpleAlert);

        Alert alert = getWebDriver().switchTo().alert();
        alert.accept();

        frameMethods.switchToParentiFrame();

        WebElement inputAlertButton = getWebDriver().findElement(By.xpath("//a[text()='Input Alert']"));
        elementMethods.clickElement(inputAlertButton);

        getWebDriver().switchTo().frame(getWebDriver().findElements(By.cssSelector("iframe.demo-frame")).get(1));

        WebElement inputleAlert =getWebDriver().findElement(By.xpath("//button[text()='Click the button to demonstrate the Input box.']"));
        elementMethods.clickElement(inputleAlert);
        String text = "Eu sunt DD";
        alertMethods.fillAlert(text);

        WebElement theResult = getWebDriver().findElement(By.id("demo"));
        String textt = theResult.getText();
        elementMethods.validateElementText(theResult,"Hello Eu sunt DD! How are you today?");
        System.out.println("Textul este: " + textt);


    }

}
