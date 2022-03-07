import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class BasicSeleniumUpdate {
    ChromeDriver chromeDriver;
    @BeforeEach
    public void openBrowser(){
        System.setProperty("webdriver.chrome.driver","src/test/resources/driver/chromedriver.exe");
        chromeDriver = new ChromeDriver();
        // implicit wait
        chromeDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        chromeDriver.manage().window().maximize();
        chromeDriver.get("http://todo.ly/");
    }


    @Test
    public void verifyLoginTodoLyu() throws InterruptedException {
        String newP = "NewProject";
        String updP = "Update";
        String idP = "ItemId_3982449";
        String xpathP = "";
        xpathP = "//*[@id=\""+ idP +"\"]/table/tbody/tr/td[4]/div[2]";
        // click img login
        chromeDriver.findElement(By.xpath("//img[@src='/Images/design/pagelogin.png']")).click();
        // set text email
        chromeDriver.findElement(By.xpath("//input[@name='ctl00$MainContent$LoginControl1$TextBoxEmail']")).sendKeys("santiavctf@gmail.com");
        // set test pwd
        chromeDriver.findElement(By.xpath("//input[contains(@name,'LoginControl1$TextBoxPassword')]")).sendKeys("Santiago900");
        // click boton login
        chromeDriver.findElement(By.id("ctl00_MainContent_LoginControl1_ButtonLogin")).click();
        Thread.sleep(3000);
        Assertions.assertTrue( chromeDriver.findElement(By.xpath("//a[text()='Logout']")).isDisplayed(),"ERROR! no se pudo hacer el login");

        chromeDriver.findElement(By.id(idP)).click();
        Thread.sleep(500);
        chromeDriver.findElement(By.xpath(xpathP)).click();
        Thread.sleep(1000);
        chromeDriver.findElement(By.xpath("//*[@id=\"projectContextMenu\"]/li[1]")).click();
        Thread.sleep(1000);
        chromeDriver.findElement(By.xpath("//*[@id=\"ItemEditTextbox\"]")).sendKeys(updP);
        Thread.sleep(2000);
        chromeDriver.findElement(By.xpath("//*[@id=\"ItemEditSubmit\"]")).click();
        Thread.sleep(2000);
        //sendKeys(Keys.TAB)
        // verificacion : para saber si el login fue satisfactorio
        Assertions.assertEquals( chromeDriver.findElement(By.id("CurrentProjectTitle")).getText(),newP+updP,"ERROR! no se pudo hacer el login");

    }

    @AfterEach
    public void closeBrowser(){
        chromeDriver.quit();
    }


}