import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;
@Listeners (ITestListener.class)

public class FashionPos {

    public static WebDriver driver;
    static String BaseURL =  "http://rfh.posspot.com/dashboard";
    static JavascriptExecutor Js;

    @BeforeTest
    public static void WebSetup() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","D:\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get((BaseURL));
        Thread.sleep(3000);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        Assert.assertTrue(driver.getPageSource().contains("Posspot.com"));

    }

    @Test(priority = 0)
    public static void LoginPage() throws InterruptedException {
        driver.findElement( By.xpath("//input[@id='login_name']")).click();
        driver.findElement(By.xpath("//input[@id='login_name']")).sendKeys("rfh");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//input[@id='login_password']")).click();
        driver.findElement(By.xpath("//input[@id='login_password']")).sendKeys("pos2019x");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//button[contains(text(),'Log me in')]")).click();
        driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
        Assert.assertTrue(driver.getCurrentUrl().contains("dashboard"));
        Thread.sleep(3000);
    }

    @Test(priority = 1)
    public static void Dashbord() throws InterruptedException {
        driver.findElement(By.tagName("img")).click();
        Thread.sleep(3000);
        ((JavascriptExecutor) driver).executeScript("window.scrollBy(0,1200)","");
        Thread.sleep(3000);
        ((JavascriptExecutor) driver).executeScript("window.scrollBy(1200,0)","");
        Thread.sleep(3000);

    }

    @Test (priority = 2)
    public static void GetMore() throws InterruptedException {
        driver.findElement(By.xpath("//a[contains(text(),'get more...')]")).click();
        Thread.sleep(3000);
    }




    @AfterTest
    public static void TestCloser(){
        driver.quit();
    }



}
