package tests;

import models.User;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTests extends TestBase {

    @BeforeMethod
    public void preCondition() {
        //   if SignOut present --> logout
        if (app.getHelperUser().isLogged())
            app.getHelperUser().logout();
    }

    @Test
    public void loginSuccess() {
        app.getHelperUser().openLogForm();
        app.getHelperUser().fillLogForm("leya@bach.com", "leyaBach9!");
        app.getHelperUser().submit();
        Assert.assertEquals(app.getHelperUser().getMessage(), "Logged in success");
      //  app.getHelperUser().okClick();

    }
    @Test
    public void loginSuccess1() {
        User user = new User().setEmail("leya@bach.com").setPassword("leyaBach9!");

        app.getHelperUser().openLogForm();
        app.getHelperUser().fillLogForm(user);
        app.getHelperUser().submit();
        Assert.assertEquals(app.getHelperUser().getMessage(), "Logged in success");


    }

    @Test
    public void loginSuccessModel() {
        app.getHelperUser().openLogForm();
        app.getHelperUser().fillLogForm("leya@bach.com", "leyaBach9!");
        app.getHelperUser().submit();
        Assert.assertTrue(app.getHelperUser().isLogged());
    //    app.getHelperUser().okClick();
    }
//==============negative==================


     @Test
        public void wrongEmail() {
            User user = new User().setEmail("leyabach.com").setPassword("leyaBach9!");

            app.getHelperUser().openLogForm();
            app.getHelperUser().fillLogForm(user);
            app.getHelperUser().submit();

            Assert.assertEquals(app.getHelperUser().getErorrText(), "It'snot look like email");
Assert.assertTrue(app.getHelperUser().isYallaBtnNotActive());

    }
    @Test
    public void wrongPassword() {
        User user = new User().setEmail("leya@bach.com").setPassword("leyaBach9");

        app.getHelperUser().openLogForm();
        app.getHelperUser().fillLogForm(user);
        app.getHelperUser().submit();

        Assert.assertEquals(app.getHelperUser().getMessage(), "\"Login or Password incorrect\"");

    }
    @Test
    public void emptyEmail() {
        User user = new User().setEmail("").setPassword("leyaBach9!");

        app.getHelperUser().openLogForm();
        app.getHelperUser().fillLogForm(user);
        app.getHelperUser().submit();

        Assert.assertEquals(app.getHelperUser().getErorrText(), "Email is required");
        Assert.assertTrue(app.getHelperUser().isYallaBtnNotActive());
    }
    @Test
    public void emptyPassword() {
        User user = new User().setEmail("leya@bach.com").setPassword("");

        app.getHelperUser().openLogForm();
        app.getHelperUser().fillLogForm(user);
        app.getHelperUser().submit();
        app.getHelperUser().pause(5000);

        Assert.assertEquals(app.getHelperUser().getErorrText(), "Password is required");
        Assert.assertTrue(app.getHelperUser().isYallaBtnNotActive());
    }
    @Test
    public void unregedUser() {
        User user = new User().setEmail("unreged@bach.com").setPassword("unreged9!");

        app.getHelperUser().openLogForm();
        app.getHelperUser().fillLogForm(user);
        app.getHelperUser().submit();

        Assert.assertEquals(app.getHelperUser().getMessage(), "\"Login or Password incorrect\"");
    }



   @AfterMethod
  public void postCondition(){
        app.getHelperUser().okClick();
   }
    }

