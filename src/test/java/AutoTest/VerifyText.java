package AutoTest;

import HelpMethods.ElementMethods;
import SharedData.SharedData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class VerifyText extends SharedData {

    @Test
    public void textTest (){

        ElementMethods elementMethods = new ElementMethods(getWebDriver());

        WebElement click = getWebDriver().findElement(By.xpath("//a[text()='Verify Text']"));
        elementMethods.scrollElementByPixel(0,350);
        elementMethods.clickElement(click);

        WebElement textElement = getWebDriver().findElement(By.xpath("//div[@class='bg-primary']//span[@class='badge-secondary']"));
        elementMethods.validateElementText(textElement,"Welcome UserName!");
        System.out.println("Textul Validat");

    }
}
