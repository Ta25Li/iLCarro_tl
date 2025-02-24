package tests;

import models.Car;
import models.User;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class AddNewCar extends TestBase {

    @BeforeClass
    public void preCondition() { // login 1 time to perform all the test
        if (!app.getHelperUser().isLogged()) {
            app.getHelperUser().login(new User()
                    .setEmail("leya@bach.com").setPassword("leyaBach9!"));
        }
    }


    @Test
    public void addNewCarSuccessAllFields() {
        int i = (int) (System.currentTimeMillis() / 1000) % 3600;

        Car car = Car.builder()
                .location("Rehovot, Israel")
                .manufacture("Bugatti")
                .model("Veyron")
                .year("2024")
                .fuel("Petrol")
                .seats(4)
                .carClass("C")
                .carRegNum("678-900-" + i)
                .price(50)
                .about("own car")

                .build();

        app.getHelperCar().openCarForm();
        app.getHelperCar().fillCarForm(car);
        app.getHelperCar().attachPhoto("D:\\Study\\QA\\Auto\\Selenium project\\iLCarro_tl\\bugatti-veyron.jpg");
        app.getHelperCar().submit();

        app.getHelperCar().pause(5000);
        Assert.assertTrue(app.getHelperCar().getMessage().contains("added successful"));
        Assert.assertEquals(app.getHelperCar().getMessage(),
                car.getManufacture() + " " + car.getModel() + " added successful");
    }

    @Test
    public void addNewCarSuccessReq() {
        int i = (int) (System.currentTimeMillis() / 1000) % 3600;

        Car car = Car.builder()
                .location("Rehovot, Israel")
                .manufacture("KIA")
                .model("Sportage")
                .year("2020")
                .fuel("Petrol")
                .seats(4)
                .carClass("C")
                .carRegNum("456-900-" + i)
                .price(50)

                .build();

        app.getHelperCar().openCarForm();
        app.getHelperCar().fillCarForm(car);
        app.getHelperCar().submit();
        app.getHelperCar().pause(5000);

        Assert.assertTrue(app.getHelperCar().getMessage().contains("added successful"));
        Assert.assertEquals(app.getHelperCar().getMessage(),
                car.getManufacture() + " " + car.getModel() + " added successful");
    }


    @AfterMethod
    public void postCondition(){
        app.getHelperCar().returnToHomePage();
    }
}
