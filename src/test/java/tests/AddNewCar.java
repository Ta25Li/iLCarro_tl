package tests;

import models.Car;
import models.User;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class AddNewCar extends TestBase{

    @BeforeClass
    public void preCondition(){ // login 1 time to perform all the test
        if (!app.getHelperUser().isLogged()){
            app.getHelperUser().login(new User()
                    .setEmail("leya@bach.com").setPassword("leyaBach9!"));
        }
    }


    @Test
    public void addNewCarSuccess(){
        int i = (int) (System.currentTimeMillis()/1000)%3600;

        Car car = Car.builder()
                .location("Rehovot, Israel")
                .manufacture("Mazda")
                .model("M3")
                .fuel("Petrol")
                .seats(4)
                .carClass("C")
                .carRegNum("678-900-"+i)
                .price(50)
                .about("own car")

                .build();

        app.getHelperCar().openCarForm();
        app.getHelperCar().fillCarForm(car);
     //   app.getHelperCar().submitCarForm();

    }
}
