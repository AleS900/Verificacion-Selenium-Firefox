import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class BasicSelenium {
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

        chromeDriver.findElement(By.id("Div2")).click();
        Thread.sleep(1000);
        chromeDriver.findElement(By.id("NewProjNameInput")).sendKeys("NewProject");
        chromeDriver.findElement(By.id("NewProjNameButton")).click();
        Thread.sleep(5000);
        //NewProjNameInput
        // verificacion : para saber si el login fue satisfactorio
        Assertions.assertEquals( chromeDriver.findElement(By.id("CurrentProjectTitle")).getText(),"NewProject","ERROR! no se pudo hacer el login");

    }

    @AfterEach
    public void closeBrowser(){
        chromeDriver.quit();
    }


}