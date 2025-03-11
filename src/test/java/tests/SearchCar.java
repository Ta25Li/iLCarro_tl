package tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class SearchCar extends TestBase {

    @Test
    public void searchCurrentMonthSuccess(){
        app.getHelperCar().searchCurrentMonth("Rehovot","03/20/2025","03/27/2025");
        app.getHelperCar().getScreen("src/test/screenshots/currentMth.png");
        app.getHelperCar().submit();

        Assert.assertTrue(app.getHelperCar().isCarListAppeared());

    }

    @Test
    public void searchCurrentYearSuccess(){
            app.getHelperCar().searchCurrentYear("Rehovot","4/27/2025","6/28/2025");
          app.getHelperCar().getScreen("src/test/screenshots/currentYear.png");
           app.getHelperCar().submit();

            Assert.assertTrue(app.getHelperCar().isCarListAppeared());

        }
    @Test
    public void searchAnyPeriodSuccess(){
    app.getHelperCar().searchAnyPeriod("Rehovot","11/15/2025","2/10/2026");
        app.getHelperCar().getScreen("src/test/screenshots/anyPeriod.png");
        app.getHelperCar().submit();

        Assert.assertTrue(app.getHelperCar().isCarListAppeared());

    }

    @Test
    public void negativeSearch(){
        app.getHelperCar().searchNotValidPeriod("Rehovot","2/15/2025","2/10/2026");
        app.getHelperCar().submit();
        Assert.assertTrue(app.getHelperUser().isYallaBtnNotActive());
        Assert.assertTrue(app.getHelperUser().getErorrText().contains("You can't pick date before today"));

    }

    @AfterMethod
    public void postCondition(){
        app.getHelperCar().navigateByLogo();
    }
}
