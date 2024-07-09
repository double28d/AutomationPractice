package AutoTest;

import HelpMethods.AlertMethods;
import HelpMethods.ElementMethods;
import SharedData.SharedData;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class ClassAttributeTest extends SharedData {

    @Test
    public void buttonAndAlertPop(){

        ElementMethods elementMethods = new ElementMethods(getWebDriver());

        WebElement classAtribute = getWebDriver().findElement(By.xpath("//a[text()='Class Attribute']"));
        elementMethods.clickElement(classAtribute);

        WebElement classButton = getWebDriver().findElement(By.cssSelector(".btn-test.btn-primary"));
        elementMethods.clickElement(classButton);

        Alert alertButton = getWebDriver().switchTo().alert();
        alertButton.accept();

    }
}


