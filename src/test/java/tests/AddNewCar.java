package tests;

import models.Car;
import org.testng.annotations.Test;

public class AddNewCar extends TestBase{

    @Test
    public void addNewCarSuccess(){
        int i = (int) (System.currentTimeMillis()/1000)%3600;

        Car car = Car.builder()
                .location("TLV, Israel")
                .manufacture("Mazda")
                .model("M3")
                .fuel("Petrol")
                .seats(4)
                .carClass("C")
                .carRegNum("678-900-"+i)
                .price(50)
                .about("own car")


                .build();
    }
}
