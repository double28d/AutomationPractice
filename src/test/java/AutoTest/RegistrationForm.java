package AutoTest;

import HelpMethods.ElementMethods;
import HelpMethods.WindowMethods;
import SharedData.SharedData;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

public class RegistrationForm extends SharedData {

    @Test
    public void registration() {
        ElementMethods elementMethods = new ElementMethods(getWebDriver());
        WindowMethods windowMethods = new WindowMethods(getWebDriver());

        WebElement registrationButton = getWebDriver().findElement(By.xpath("//a[text()='Registration']"));
        elementMethods.clickElement(registrationButton);

        windowMethods.switchSpecificTabWindow(1);

        WebElement nameField = getWebDriver().findElement(By.name("name"));
        nameField.sendKeys("Dani");

        WebElement phoneField = getWebDriver().findElement(By.name("phone"));
        phoneField.sendKeys("0258741369");

        WebElement emailField = getWebDriver().findElement(By.name("email"));
        emailField.sendKeys("garsiru@nej.ort");

        WebElement countryClick = getWebDriver().findElement(By.name("country"));
        elementMethods.clickElement(countryClick);

        List<String> countryList = Arrays.asList("Moldova, Republic of");
        WebElement dropdownElement = getWebDriver().findElement(By.xpath("//select[@name='country']"));
        Select dropdown = new Select(dropdownElement);
        List<WebElement> option = dropdown.getOptions();
        for (WebElement curentOption : option) {
            String currentOptionText = curentOption.getText();
            if (countryList.contains(currentOptionText)) {
                curentOption.click();
                JavascriptExecutor executor = (JavascriptExecutor) getWebDriver();
                executor.executeScript("arguments[0].blur();", dropdownElement);
                break;
            }
        }

        WebElement cityField = getWebDriver().findElement(By.name("city"));
        cityField.sendKeys("Chisinau");

        WebElement usernameField = getWebDriver().findElement(By.xpath("//div[@id='load_box']//form[@id='load_form']//input[@name='username']"));
        usernameField.sendKeys("DD");

        WebElement passwordField = getWebDriver().findElement(By.xpath("//div[@id='load_box']//form[@id='load_form']//input[@name='password']"));
        passwordField.sendKeys("parola");

        WebElement submitButton = getWebDriver().findElement(By.xpath("//div[@id='load_box']//form[@id='load_form']//input[@class='button']"));
        elementMethods.clickElement(submitButton);

        WebDriverWait wait = new WebDriverWait(getWebDriver(), Duration.ofSeconds(3));
        WebElement submitClicked = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.popupbox #alert")));

        WebElement alerID = getWebDriver().findElement(By.cssSelector("div.popupbox #alert"));
        String alertmessage = alerID.getText();
        System.out.println("Textul obtinut: " + alertmessage);
        Assert.assertEquals(alerID.getText(), "This is just a dummy form, you just clicked SUBMIT BUTTON");

    }

}
