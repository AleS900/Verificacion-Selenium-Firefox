import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BasicFirefoxSelenium {
    FirefoxDriver firefoxDriver;

    @BeforeEach
    public void openBrowser(){
        System.setProperty("webdriver.gecko.driver","src/test/resources/driver/geckodriver.exe");
        firefoxDriver = new FirefoxDriver();
        firefoxDriver.get("https://skynet.lp.upb.edu/~svargas19/register/login.php");
        firefoxDriver.manage().window().maximize();
    }

    @Test
    public void goToFirefox() throws InterruptedException{
        firefoxDriver.findElement(By.xpath("/html/body/main/section/div/div/div[3]/form/div[1]/div/input")).sendKeys("test@gmail.com");
        firefoxDriver.findElement(By.xpath("/html/body/main/section/div/div/div[3]/form/div[2]/div/input")).sendKeys("test123");
        Thread.sleep(5000);
        firefoxDriver.findElement(By.xpath("/html/body/main/section/div/div/div[3]/form/div[3]/button")).click();
        Thread.sleep(6000);
    }

    @AfterEach
    public void closeBrowser(){
        firefoxDriver.quit();
    }
}
