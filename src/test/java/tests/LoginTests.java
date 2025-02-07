package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTests extends TestBase{

  @BeforeMethod
   public void preCondition() {
       //if SignOut present --> logout
        if (app.getHelperUser().isLogged())
            app.getHelperUser().logout();
    }
        @Test
        public void loginSuccess() {
            app.getHelperUser().openLogRegForm();
            app.getHelperUser().fillLogRegForm("leya@bach.com", "leyaBach9!");
            app.getHelperUser().submitLogin();

            Assert.assertTrue(app.getHelperUser().isLogged());

            app.getHelperUser().okClick();

        }

    @Test
    public void loginSuccessModel() {
        app.getHelperUser().openLogRegForm();
        app.getHelperUser().fillLogRegForm("leya@bach.com", "leyaBach9!");
        app.getHelperUser().submitLogin();

        Assert.assertTrue(app.getHelperUser().isLogged());

        app.getHelperUser().okClick();

    }
    }

