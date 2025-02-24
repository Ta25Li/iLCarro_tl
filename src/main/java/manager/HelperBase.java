package manager;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class HelperBase {
    WebDriver wd;

    public HelperBase(WebDriver wd) {
        this.wd = wd;
    }

    public void type(By locator, String text) {
        WebElement element = wd.findElement(locator);
        element.click();
       element.clear();// clear field to make sure it's empty
       clearNew(element);
        if (text != null) {
            element.sendKeys(text);
        }
    }

    public void clearNew(WebElement element){ //type and clear - imitate empty field
        element.sendKeys(" ");
        element.sendKeys(Keys.BACK_SPACE);
    }


    public void click(By locator){

        //  WebElement element = wd.findElement(locator);
       // element.click();
        wd.findElement(locator).click();

    }

    public boolean isElementPresent(By locator){
      //  List<WebElement> list = wd.findElements(locator);
     //   return list.size()>0;
       return wd.findElements(locator).size()>0;
    }

    public void pause(int time){
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean isYallaBtnNotActive() {
        boolean res = isElementPresent(By.cssSelector("button[disabled]"));

        WebElement element = wd.findElement(By.cssSelector("button[type='submit']"));
        boolean result = element.isEnabled(); //second option to find disabled button

        return res && !result;
    }

    public void submit() { //find btn Login and click

        click(By.xpath("//button[@type='submit']"));
    }

    public String getMessage() {
        //   WebElement element = wd.findElement(By.cssSelector(".dialog-container>h2"));
        //   String text = element.getText();
        //   return text;

        //    pause(2000);
        return wd.findElement(By.cssSelector(".dialog-container>h2")).getText(); //child of dialog-container class
    }

}