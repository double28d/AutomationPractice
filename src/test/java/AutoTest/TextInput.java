package AutoTest;

import HelpMethods.ElementMethods;
import SharedData.SharedData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class TextInput extends SharedData {

    @Test
    public void textInput (){
        ElementMethods elementMethods = new ElementMethods(getWebDriver());

        WebElement click = getWebDriver().findElement(By.xpath("//a[text()='Text Input']"));
        elementMethods.scrollElementByPixel(0,350);
        elementMethods.clickElement(click);

        WebElement textField = getWebDriver().findElement(By.id("newButtonName"));
        elementMethods.fillText(textField, "Automate this test");

        WebElement clickOnTheButton = getWebDriver().findElement(By.id("updatingButton"));
        elementMethods.clickElement(clickOnTheButton);

        WebElement validateButton = getWebDriver().findElement(By.id("updatingButton"));
        elementMethods.validateElementText(validateButton, "Automate this test");

        System.out.println("The Button Changed");

    }
}
