import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class MyAreaPage extends Page{

    private String myPostsXpath = "//span[@class='catSubcatTitle']/a";
    private String coronaPopUpXpath = "//div[@id='coronaPopUpContent']//div[@class='close']";
    private String floatingAdId = "sLightbox_container";
    private String adToolTipCloseBtnXpath = "//div[@id='sLightbox_container']//div[@class='closeToolTipIframe']";
    private String postIdentifierXpath = "//table[@id='feed']/tbody/tr[2]/td/div[text()='0']";
    private String postsFrameXpath = "//table[@id='feed']//iframe";
    private String popUpBtnId = "bounceRatingOrderBtn";
    private String adCloseBtnXpath = "//div[@id='sLightbox_container']//div[@class='close_btn']";

    public MyAreaPage (WebDriver driver){
        super.driver = driver;
    }

    public MyAreaPage openMyPosts() throws InterruptedException {
        WebElement myPosts=findElementBy(By.xpath(myPostsXpath));
        myPosts.click();
        Thread.sleep(Constants.TWO_SEC);
        return this;
    }

    public MyAreaPage checkForPopUpAndCloseById(){
        String mwh = driver.getWindowHandle();//current window

        Set s=driver.getWindowHandles(); //this method will give you the handles of all opened windows

        Iterator ite=s.iterator();

        while(ite.hasNext())
        {
            String popupHandle=ite.next().toString();
            if(!popupHandle.contains(mwh)) {
                driver.switchTo().window(popupHandle);
                List<WebElement> elementList = findElementsBy(By.xpath(coronaPopUpXpath));
                if (elementList != null && !elementList.isEmpty()){
                    elementList.get(0).click();
                }
            }
        }
        driver.switchTo().window(mwh);
        return this;
    }

    public MyAreaPage closeAdsIfDisplayed(String adCloseBtnXpath) {
        List<WebElement> floatingAd = findElementsBy(By.id(floatingAdId));
        if(floatingAd!= null && !floatingAd.isEmpty() && floatingAd.get(0).isDisplayed()){
            WebElement close = findElementBy(By.xpath(adCloseBtnXpath));
            close.click();
        }
        return this;
    }

    public void popUpMyPosts(List<String> postsIds) throws InterruptedException {
        closeAdsIfDisplayed(adToolTipCloseBtnXpath);
        for (String postsId : postsIds) {
            postIdentifierXpath = postIdentifierXpath.replaceAll("0",postsId);
            WebElement post=findElementBy(By.xpath(postIdentifierXpath));
            post.click();
            Thread.sleep(Constants.FIVE_SEC);

            //switch to list of posts frame
            switchToFrame(findElementBy(By.xpath(postsFrameXpath)));

            closeAdsIfDisplayed(adCloseBtnXpath);

            WebElement bounceBtn = findElementBy(By.id(popUpBtnId));
            scrollToElement(bounceBtn);
            bounceBtn.click();

            driver.switchTo().defaultContent();
            //close the post item
            post.click();
            Thread.sleep(Constants.TWO_SEC);
        }
    }
}
