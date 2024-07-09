package AutoTest;

import HelpMethods.ElementMethods;
import SharedData.SharedData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class LoadDelayTest extends SharedData {

    @Test
    public void loadDelayButton (){

        ElementMethods elementMethods = new ElementMethods(getWebDriver());

        WebElement loadPage = getWebDriver().findElement(By.xpath("//a[text()='Load Delay']"));
        elementMethods.clickElement(loadPage);

        WebElement delayButton = getWebDriver().findElement(By.xpath("//button[text()='Button Appearing After Delay']"));
        elementMethods.clickElement(delayButton);

    }
}
