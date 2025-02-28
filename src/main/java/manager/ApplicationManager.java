package manager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.TimeUnit;

public class ApplicationManager {

    Logger logger = LoggerFactory.getLogger(ApplicationManager.class);

    WebDriver wd;
    HelperUser helperUser;
    HelperCar helperCar;

    public void init() {
        wd = new ChromeDriver();
        logger.info("All tests run in ChromeBrowser");

        wd.manage().window().maximize();
        wd.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        wd.navigate().to("https://ilcarro.web.app");
        logger.info("The link--->"+ wd.getCurrentUrl());

        helperUser = new HelperUser(wd);
        helperCar = new HelperCar(wd);
    }
    public void stop() {
        wd.quit();
    }

    public HelperUser getHelperUser() { //generate-> getter-> helperUser
        return helperUser;
    }



    public HelperCar getHelperCar() {
        return helperCar;
    }
}
