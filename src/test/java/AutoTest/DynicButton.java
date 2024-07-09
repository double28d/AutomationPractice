package AutoTest;

import HelpMethods.ElementMethods;
import SharedData.SharedData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class DynicButton extends SharedData {

    @Test
    public void youtubeTest() {

        ElementMethods elementMethods = new ElementMethods(getWebDriver());

        WebElement dynamicID = getWebDriver().findElement(By.xpath("//a[text()='Dynamic ID']"));
        elementMethods.clickElement(dynamicID);

        WebElement dynamicButton = getWebDriver().findElement(By.xpath("//button[text()='Button with Dynamic ID']"));
        elementMethods.clickElement(dynamicButton);

    }
}