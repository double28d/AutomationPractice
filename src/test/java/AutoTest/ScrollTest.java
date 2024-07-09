package AutoTest;

import HelpMethods.ElementMethods;
import SharedData.SharedData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class ScrollTest extends SharedData {

    @Test
    public void scrollBar (){

        ElementMethods elementMethods = new ElementMethods(getWebDriver());

        WebElement click = getWebDriver().findElement(By.xpath("//a[text()='Scrollbars']"));
        elementMethods.scrollElementByPixel(0,350);
        elementMethods.clickElement(click);

        WebElement hidenButton = getWebDriver().findElement(By.id("hidingButton"));
        elementMethods.clickElement(hidenButton);

    }
}
