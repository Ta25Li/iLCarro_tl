package tests;

import models.User;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Random;

public class RegistrationTests extends TestBase {

    @BeforeMethod
    public void preCondition() {
        if (app.getHelperUser().isLogged())
            app.getHelperUser().logout();
    }

    @Test
    public void registrationSuccess() {
        Random random = new Random();
        int i = random.nextInt(1000);
        // int i = random.nextInt(1000)+1000;   to make the random number bigger - might have repeated numbers
        System.out.println(i);

        System.out.println(System.currentTimeMillis());  // to avoid repeated numbers
        int z = (int) ((System.currentTimeMillis() / 1000) % 3600); // to make integer from long
        System.out.println(z);

        User user = new User()
                .setFirstName("Mark")
                .setLastName("Green")
                .setEmail("green" + i + "@email.com")// or z
                .setPassword("Green123456!");

        app.getHelperUser().openRegistrationForm();
        app.getHelperUser().fillRegistrationForm(user);
        app.getHelperUser().checkPolicy();
        app.getHelperUser().submit();

        Assert.assertEquals(app.getHelperUser().getMessage(),"You are logged in success");

    }
    //===== negative =====
 @Test
    public void regWrongEmail() {

        User user = new User()
                .setFirstName("Anna")
                .setLastName("Stone")
                .setEmail("stoneemail.com")
                .setPassword("Stone123456!");

        app.getHelperUser().openRegistrationForm();
        app.getHelperUser().fillRegistrationForm(user);
        app.getHelperUser().checkPolicy();

      //  Assert.assertEquals(app.getHelperUser().getErorrTextReg(), "Wrong email format");
    Assert.assertTrue(app.getHelperUser().getErorrText().contains("Wrong email format"));
        Assert.assertTrue(app.getHelperUser().isYallaBtnNotActive());



    }

    @Test
    public void regWrongPassword() {

        User user = new User()
                .setFirstName("Anna")
                .setLastName("Stone")
                .setEmail("stone@email.com")
                .setPassword("Stone11");

        app.getHelperUser().openRegistrationForm();
        app.getHelperUser().fillRegistrationForm(user);
        app.getHelperUser().checkPolicy();


        Assert.assertEquals(app.getHelperUser().getErorrText(), "Password must contain minimum 8 symbols\n" +
                "Password must contain 1 uppercase letter, 1 lowercase letter, 1 number and one special symbol of [@$#^&*!]");
        Assert.assertTrue(app.getHelperUser().isYallaBtnNotActive());

    }
    @Test
    public void regEmptyEmail() {

        User user = new User()
                .setFirstName("Anna")
                .setLastName("Stone")
                .setEmail("")
                .setPassword("Stone123456!");

        app.getHelperUser().openRegistrationForm();
        app.getHelperUser().fillRegistrationForm(user);
        app.getHelperUser().checkPolicy();

        Assert.assertEquals(app.getHelperUser().getErorrText(), "Email is required");
        Assert.assertTrue(app.getHelperUser().isYallaBtnNotActive());
    }
    @Test
    public void regEmptyPassword() {


        User user = new User()
                .setFirstName("Anna")
                .setLastName("Stone")
                .setEmail("stone@email.com")
                .setPassword("");

        app.getHelperUser().openRegistrationForm();
        app.getHelperUser().fillRegistrationForm(user);
        app.getHelperUser().checkPolicy();

        Assert.assertEquals(app.getHelperUser().getErorrText(), "Password is required");
        Assert.assertTrue(app.getHelperUser().isYallaBtnNotActive());
    }
    @Test
    public void regEmptyName() {

        User user = new User()
                .setFirstName("")
                .setLastName("Stone")
                .setEmail("stone@email.com")
                .setPassword("Stone123456!");

        app.getHelperUser().openRegistrationForm();
        app.getHelperUser().fillRegistrationForm(user);
       app.getHelperUser().checkPolicy();

        Assert.assertEquals(app.getHelperUser().getErorrText(), "Name is required");
        Assert.assertTrue(app.getHelperUser().isYallaBtnNotActive());
    }

    @Test
    public void regEmptyLastName() {

        User user = new User()
                .setFirstName("Anna")
                .setLastName("")
                .setEmail("stone@email.com")
                .setPassword("Stone123456!");

        app.getHelperUser().openRegistrationForm();
        app.getHelperUser().fillRegistrationForm(user);
      app.getHelperUser().checkPolicy();

        Assert.assertEquals(app.getHelperUser().getErorrText(), "Last name is required");
        Assert.assertTrue(app.getHelperUser().isYallaBtnNotActive());
    }

    @Test
    public void regNoCheckBox() {
        Random random = new Random();
        int i = random.nextInt(1000);
        System.out.println(i);

        User user = new User()
                .setFirstName("Anna")
                .setLastName("Stone")
                .setEmail("stone" + i + "@email.com")
                .setPassword("Stone123456!");

        app.getHelperUser().openRegistrationForm();
        app.getHelperUser().fillRegistrationForm(user);
        app.getHelperUser().submit();
      //  Assert.assertTrue(app.getHelperUser().isYallaBtnNotActive());
    }
    @Test
    public void regExistingUser() {

        User user = new User()
                .setFirstName("Leya")
                .setLastName("Bach")
                .setEmail("leya@bach.com")
                .setPassword("leyaBach9!");


        app.getHelperUser().openRegistrationForm();
        app.getHelperUser().fillRegistrationForm(user);
        app.getHelperUser().checkPolicy();
        app.getHelperUser().submit();

        Assert.assertEquals(app.getHelperUser().getMessage(), "\"User already exists\"");

    }






//===============================================================================
    @AfterMethod
    public void postCondition(){
        app.getHelperUser().okClick();
    }

}
