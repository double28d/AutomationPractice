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

import static org.testng.Assert.assertTrue;

public class SimpleClick extends SharedData {

    @Test
    public void simpleClick (){

        ElementMethods elementMethods = new ElementMethods(getWebDriver());

        WebElement click = getWebDriver().findElement(By.xpath("//a[text()='Click']"));
        elementMethods.scrollElementByPixel(0,350);
        elementMethods.clickElement(click);

        WebElement domClick = getWebDriver().findElement(By.id("badButton"));
        elementMethods.clickElement(domClick);

        WebElement validateClick = getWebDriver().findElement(By.id("badButton"));
        String buttonClassAfterClick = validateClick.getAttribute("class");

        if (buttonClassAfterClick.contains("btn-success")) {
            System.out.println("The button changed to GREEN after click");
        } else {
            System.out.println("The button did not change to GREEN after click");
            assertTrue(false, "The button did not change to GREEN after click");
        }
    }
}
