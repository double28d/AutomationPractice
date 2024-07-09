package AutoTest;

import HelpMethods.ElementMethods;
import SharedData.SharedData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;


public class DynamicTable extends SharedData {

    @Test
    public void Dynamic (){
        ElementMethods elementMethods = new ElementMethods(getWebDriver());

        WebElement click = getWebDriver().findElement(By.xpath("//a[text()='Dynamic Table']"));
        elementMethods.scrollElementByPixel(0,350);
        elementMethods.clickElement(click);

        WebElement cpuColumn = getWebDriver().findElement(By.xpath("//span[@role='columnheader' and text()='CPU']"));
        WebElement chromeRow = getWebDriver().findElement(By.xpath("//span[@role='cell' and text()='Chrome']"));
        WebElement cpuChromeElement = getWebDriver().findElement(By.xpath("//p[@class='bg-warning' and contains(text(),'Chrome CPU:')]"));

        String cpuLoadText = cpuChromeElement.getText().replace("Chrome CPU: ", "");
        double cpuLoad = Double.parseDouble(cpuLoadText.replace("%", ""));
//
//        double expectedCpuLoad = getCpuLoadForChrome();
//        if (cpuLoad == expectedCpuLoad) {
//            System.out.println("Testul a trecut: Valoarea încărcării CPU-ului pentru Chrome este aceeași cu cea din eticheta galbenă.");
//        } else {
//            System.out.println("Testul a eșuat: Valoarea încărcării CPU-ului pentru Chrome este diferită față de cea din eticheta galbenă.");
//        }
    }
}
