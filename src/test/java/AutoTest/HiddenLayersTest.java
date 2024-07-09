package AutoTest;

import HelpMethods.ElementMethods;
import SharedData.SharedData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class HiddenLayersTest extends SharedData {

    @Test
    public void hiddenButton (){

        ElementMethods elementMethods = new ElementMethods(getWebDriver());

        WebElement hiddenPage = getWebDriver().findElement(By.xpath("//a[text()='Hidden Layers']"));
        elementMethods.clickElement(hiddenPage);

        WebElement hiddenButton = getWebDriver().findElement(By.id("greenButton"));
        elementMethods.clickElement(hiddenButton);
        elementMethods.clickElement(hiddenButton);

//        WebElement hiddenButton2 = getWebDriver().findElement(By.id("blueButton"));
//        elementMethods.clickElement(hiddenButton2);
    }
}
