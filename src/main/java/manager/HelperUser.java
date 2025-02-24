package manager;

import models.User;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;

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


public String getErorrText() {
   return wd.findElement(By.cssSelector("div.error")).getText();
   //(By.xpath(" //div[@class='error']/div"))
}
    public String getErorrTextReg() {
        return wd.findElement(By.xpath("//*[text()='Wrong email format']")).getText();

    }

//------ Registration -----------------------

    public void openRegistrationForm() {
click(By.xpath("//*[text() = ' Sign up ']"));
    }

    public void fillRegistrationForm(User user) {
        type(By.id("name"),user.getFirstName());
        type(By.id("lastName"),user.getLastName());
        type(By.id("email"),user.getEmail());
        type(By.id("password"),user.getPassword());
    }

    public void checkPolicy1() {
      //  click(By.id("terms-of-use")); // not working as size 0
      //  click(By.cssSelector("label[for='terms-of-use']"));  not working as clickin in the middle of the field and opens tems of use

        JavascriptExecutor js =(JavascriptExecutor) wd;
        js.executeScript("document.querySelector('#terms-of-use').click();");
    }
    public void checkPolicy() {

        if (!wd.findElement(By.id("terms-of-use")).isSelected()) { //if not selected then click

            JavascriptExecutor js = (JavascriptExecutor) wd;
            js.executeScript("document.querySelector('#terms-of-use').click();");
        }
    }

    public void checkPolicyXY(){
        WebElement label = wd.findElement(By.cssSelector("label[for='terms-of-use']"));
        Rectangle rectangle = label.getRect(); //элемент знает свои координаты
        int w = rectangle.getWidth(); //вытащить щирину объекта
        int xOffset = -w/2;  //сдвинуть на половину элемента в верхний левый угол

      //  Dimension size = wd.manage().window().getSize(); // узнать размеры экрана

        Actions actions = new Actions(wd);
        actions.moveToElement(label,xOffset,0).click().release().perform();
        //кликнуть в верхний левый угол элемента

    }
//======================================================

    public void login(User user) {
        openLogForm();
        fillLogForm(user);
        submit();
        okClick();
    }
}
