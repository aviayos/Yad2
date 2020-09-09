import org.openqa.selenium.chrome.ChromeDriver;
import java.util.ArrayList;
import java.util.List;


/***
 * This class manage the access to Yad2 and perform actions with his members to
 * pop the post/s
 */
public class PageManager{
    private static final String EMAIL = "ziony51@gmail.com";
    private static final String PASSWORD = "zi1951on";

    private LoginPage loginPage;
    private MyAreaPage myAreaPage;
    private ChromeDriver chromeDriver;

    public PageManager(){
        System.setProperty(Constants.DRIVER_NAME, Constants.DRIVER_PATH);
        this.chromeDriver = new ChromeDriver();
    }

    public void init(){
        this.loginPage = new LoginPage(this.chromeDriver);
        this.myAreaPage = new MyAreaPage(this.chromeDriver);
    }

    public void start() throws InterruptedException{
            openYad2();
            loginPage.setUserName(EMAIL).setPassword(PASSWORD).login();
            List<String> postsIds = new ArrayList<>();
            postsIds.add("ירושלים - פארן");
            myAreaPage.checkForPopUpAndCloseById().openMyPosts().popUpMyPosts(postsIds);
    }

    private void openYad2() throws InterruptedException {
        try {
            chromeDriver.get(Constants.YAD2_URL);
            chromeDriver.manage().window().maximize();
            Thread.sleep(Constants.FIVE_SEC);
        }catch (InterruptedException e) {
            System.out.println("Can't open Yad2 Url");
            throw e;
        }
    }

    public void end() {
        chromeDriver.close();
    }
}
