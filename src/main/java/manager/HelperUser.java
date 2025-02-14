package manager;

import models.User;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HelperUser extends HelperBase {
    public HelperUser(WebDriver wd) {
        super(wd);
    }

    public void openLogForm() {
        click(By.cssSelector("a[ng-reflect-router-link='login']"));
        //(By.xpath("//*[text()=' Log in ']"))
    }

    public void fillLogForm(String email, String password) {
        // type(By.xpath("//input[@id='email']"), email);
        // type(By.xpath("//input[@id='password']"), password);
        type(By.id("email"), email);
        type(By.id("password"), password);

    }

    public void fillLogForm(User user) {
        type(By.id("email"), user.getEmail());
        type(By.id("password"), user.getPassword());


    }
    public void submitLogin() { //find btn Login and click
        click(By.xpath("//button[@type='submit']"));
    }



    public String getMessage() {
        //   WebElement element = wd.findElement(By.cssSelector(".dialog-container>h2"));
        //   String text = element.getText();
        //   return text;

    //    pause(2000);
        return wd.findElement(By.cssSelector(".dialog-container>h2")).getText(); //child of dialog-container class
    }

    public void okClick() {
        if (isElementPresent(By.xpath("//button[text()='Ok']")))
            click(By.xpath("//button[text()='Ok']"));
        //("//button[@type='button']"));
    }

    //public void clickLogout(){
    //   click(By.xpath("//a[normalize-space()='Logout']"));
//}
    public boolean isLogged() {
        return isElementPresent(By.xpath
                ("//*[text()=' Logout ']"));
    }

    public void logout() {
        click(By.xpath("//a[normalize-space()='Logout']"));
    }

//===========negative========================================
public void tearDown(){
    //   if (driver != null)
    //     driver.quit();
} 


public String getErorrText() {
   return wd.findElement(By.cssSelector("div.error")).getText();
   //(By.xpath(" //div[@class='error']/div"))
}


}
