package tests;

import models.User;
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
        // int i = random.nextInt(1000)+1000;   to make the random number bigger - might have repeted numbers
        System.out.println(i);

        System.out.println(System.currentTimeMillis());  // to avoid repeted numbers
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
    @AfterMethod
    public void postCondition(){
        app.getHelperUser().okClick();
    }

}
