package tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class SearchCar extends TestBase {

    @Test
    public void searchCurrentMonthSuccess(){
        app.getHelperCar().searchCurrentMonth("Rehovot","10/10/2025","10/27/2025");
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
    @AfterMethod
    public void postCondition(){
        app.getHelperCar().navigateByLogo();
    }
}
