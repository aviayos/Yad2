import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage extends Page{

    private String passwordId = "password";
    private String userNameId = "userName";
    private String loginId = "submitLogonForm";

    public LoginPage (WebDriver driver){
        super.driver = driver;
    }

    public LoginPage setUserName(String userName) throws InterruptedException {
        WebElement email= findElementBy(By.id(userNameId));
        email.sendKeys(userName);
        Thread.sleep(Constants.TWO_SEC);
        return this;
    }

    public LoginPage setPassword(String userName) throws InterruptedException {
        WebElement email= findElementBy(By.id(passwordId));
        email.sendKeys(userName);
        Thread.sleep(Constants.TWO_SEC);
        return this;
    }

    public LoginPage login() throws InterruptedException {
        WebElement loginBtn=findElementBy(By.id(loginId));
        loginBtn.click();
        Thread.sleep(Constants.TWO_SEC);
        return this;
    }

}
