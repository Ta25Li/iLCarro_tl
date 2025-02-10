package manager;

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
        click(By.xpath("//button[@type='button']"));
        //"//button[text()='Ok']"
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


}
