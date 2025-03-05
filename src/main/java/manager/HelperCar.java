package manager;

import models.Car;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class HelperCar extends HelperBase {


    public HelperCar(WebDriver wd) {
        super(wd);
    }

    public void openCarForm() {
        pause(500);
        click(By.xpath("//a[text()=' Let the car work ']"));

    }

    public void fillCarForm(Car car) {
        typeLocation(car.getLocation());
        type(By.id("make"), car.getManufacture());
        type(By.id("model"), car.getModel());
        type(By.id("year"), car.getYear());
        select(By.id("fuel"), car.getFuel());
        type(By.id("seats"), String.valueOf(car.getSeats()));
        type(By.id("class"), car.getCarClass());
        type(By.id("serialNumber"), car.getCarRegNum());
        //   type(By.id("price"),String.valueOf(car.getPrice()));
        type(By.id("price"), car.getPrice() + ""); //add string -- all turns to string
        type(By.id("about"), car.getAbout());
    }


    private void select(By locator, String option) {
        Select select = new Select(wd.findElement(locator));
        select.selectByValue(option);
        //     select.selectByIndex(5);
        //    select.selectByVisibleText(" Gas ");
        //    select.selectByValue("Gas");

    }

    private void typeLocation(String location) {
        type(By.id("pickUpPlace"), location);
        click(By.cssSelector("div.pac-item"));
    }

    public void returnToHomePage() {
        click(By.xpath("//button[text()='Search cars']"));

    }

    public void attachPhoto(String link) {
        wd.findElement(By.id("photos")).sendKeys(link);
    }

    //===============================================================
    public void searchCurrentMonth(String city, String dateFrom, String dateTo) {
        typeCity(city);
        click(By.id("dates"));
        //"3/10/2024","3/27/2025"

        String[] from = dateFrom.split("/");

        String locatorFrom = "//div[text()=' " + from[1] + " ']"; //take from index 1
        click(By.xpath(locatorFrom));

        String[] to = dateTo.split("/");
        click(By.xpath("//div[text()=' " + to[1] + " ']"));


    }

    private void typeCity(String city) {
        type(By.id("city"), city);
        click(By.cssSelector("div.pac-item"));

    }

    public boolean isCarListAppeared() {
        return isElementPresent(By.cssSelector("a.car-container"));
    }

    ;

    public void searchCurrentYear(String city, String dateFrom, String dateTo) {
        typeCity(city);
        click(By.id("dates"));
        //"4/27/2024","6/28/2025"

        LocalDate now = LocalDate.now();  //format yyyy-mm-dd
        int year = now.getYear();
        int month = now.getMonthValue();
        int day = now.getDayOfMonth();

        LocalDate from = LocalDate.parse(dateFrom, DateTimeFormatter.ofPattern("M/dd/yy")); //M - month w/o 01,02 - > 1,2 ---     turn date string into int
// LocalDate from1 = LocalDate.parse("2013:23/02", DateTimeFormatter.ofPattern("yyyy:dd/MM")); //change any date to needed format

        int diffMonth = from.getMonthValue() - month; // difference today from start date
        if (diffMonth >0)
        clickNextMthBtn(diffMonth);
        click(By.xpath("//div[text()=' " + from.getDayOfMonth() + " ']"));


    }

    private void clickNextMthBtn(int diffMonth) {
        for (int i = 0; i < diffMonth ; i++) {
            click(By.cssSelector("button[aria-label='Next month']"));
            
        }

    }


}
