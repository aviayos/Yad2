import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

/***
 * The pages father class.
 */
public class Page {
    protected WebDriver driver;

    protected WebElement findElementBy(By by){
        return driver.findElement(by);
    }

    protected List<WebElement> findElementsBy(By by){
        return driver.findElements(by);
    }

    protected void scrollToElement(WebElement e){
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].scrollIntoView(true);", e);
    }

    protected void switchToFrame(WebElement e){
        driver.switchTo().frame(e);
    }

}
