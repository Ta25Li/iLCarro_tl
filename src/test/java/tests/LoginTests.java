package tests;

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
        app.getHelperUser().submitLogin();
        Assert.assertEquals(app.getHelperUser().getMessage(), "Logged in success");
      //  app.getHelperUser().okClick();

    }

    @Test
    public void loginSuccessModel() {
        app.getHelperUser().openLogForm();
        app.getHelperUser().fillLogForm("leya@bach.com", "leyaBach9!");
        app.getHelperUser().submitLogin();
        Assert.assertTrue(app.getHelperUser().isLogged());
    //    app.getHelperUser().okClick();
    }

    @AfterMethod
    public void postCondition(){
        app.getHelperUser().okClick();
    }
    }

