package manager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HelperUser extends HelperBase{
    public HelperUser(WebDriver wd) {
        super(wd);
    }
    public void openLogRegForm() {
   click(By.cssSelector("a[ng-reflect-router-link='login']"));
    }

    public void fillLogRegForm(String email, String password) {
 type(By.xpath("//input[@id='email']"), email);
 type(By.xpath("//input[@id='password']"), password);
    }

    public void submitLogin(){ //find btn Login and click
        click(By.xpath("//button[@type='submit']"));
    }

    public boolean isLogged() {
        return isElementPresent(By.xpath("//h2[normalize-space()='Logged in success']"));
    }
public void okClick(){
    click(By.xpath("//button[@type='button']"));
}
//public void clickLogout(){
 //   click(By.xpath("//a[normalize-space()='Logout']"));
//}
   public void logout() {
       click(By.xpath("//a[normalize-space()='Logout']"));
  }
}
