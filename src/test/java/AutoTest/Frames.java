package AutoTest;

import HelpMethods.ElementMethods;
import HelpMethods.WindowMethods;
import SharedData.SharedData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;


public class Frames  extends SharedData {

    @Test
    public void frames() {

        ElementMethods elementMethods = new ElementMethods(getWebDriver());
        WindowMethods windowMethods = new WindowMethods(getWebDriver());

        WebElement interactionButton = getWebDriver().findElement(By.xpath("//a[text()='Frames and Windows']"));
        elementMethods.clickElement(interactionButton);

        windowMethods.switchSpecificTabWindow(1);

        WebElement enterTestLink = getWebDriver().findElement(By.xpath("//div[@id='load_box']//div[@class='span_3_of_4']/p/a[text()='ENTER TO THE TESTING WEBSITE']"));
        elementMethods.clickElement(enterTestLink);

        elementMethods.scrollElementByPixel(0,450);

        WebElement frameElement = getWebDriver().findElement(By.xpath("//h2[text()='Frames and Windows']"));
        elementMethods.clickElement(frameElement);

        windowMethods.switchSpecificTabWindow(2);

        getWebDriver().switchTo().frame(getWebDriver().findElement(By.cssSelector("iframe.demo-frame")));

        WebElement newBrowserTab = getWebDriver().findElement(By.xpath("//div[@class='farme_window']//a[text()='New Browser Tab']"));
        elementMethods.clickElement(newBrowserTab);

        windowMethods.switchSpecificTabWindow(3);

        WebElement nBTab = getWebDriver().findElement(By.linkText("New Browser Tab"));
        String actualText = nBTab.getText();
        String expectedText = "New Browser Tab";
        System.out.println("Textul obtinut este: " + actualText);
        Assert.assertEquals(expectedText, actualText);

        getWebDriver().close();

        windowMethods.switchSpecificTabWindow(2);

        WebElement separateWindow = getWebDriver().findElement(By.xpath("//a[text()='Open Seprate New Window']"));
        elementMethods.clickElement(separateWindow);

        getWebDriver().switchTo().frame(getWebDriver().findElement(By.cssSelector("iframe[src='frames-windows/defult2.html']")));

        WebElement openSeparateWindowLink = getWebDriver().findElement(By.xpath("//div[contains(@class, 'farme_window')]//a[contains(text(), 'Open New Seprate Window')]"));
        elementMethods.clickElement(openSeparateWindowLink);

        windowMethods.switchSpecificTabWindow(3);

        WebElement linkInNewWindow = getWebDriver().findElement(By.cssSelector(".farme_window a"));
        String actualText2 = linkInNewWindow.getText();
        String expectedText2 = "Open New Seprate Window";
        System.out.println("Textul obținut este: " + actualText2);
        Assert.assertEquals(actualText2, expectedText2);
        getWebDriver().close();

        windowMethods.switchSpecificTabWindow(2);

        WebElement multipleWindows = getWebDriver().findElement(By.xpath("//a[text()='Open Multiple Windows']"));
        elementMethods.clickElement(multipleWindows);

        getWebDriver().switchTo().frame(getWebDriver().findElement(By.cssSelector("iframe[src='frames-windows/defult4.html']")));

        WebElement openMultipleWindowLink = new WebDriverWait(getWebDriver(), Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("a[href='#'][onclick*='window.open']")));
        elementMethods.clickElement(openMultipleWindowLink);



    }
}
