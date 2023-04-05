package LoginScripts;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Gmail {
    private WebDriver driver;
    
    @BeforeTest
    public void setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Test
    public void testLogin() throws InterruptedException {
        driver.get("https://codesandbox.io/s/sweet-shockley-z3t0c9?file=/src/App.js");
        Thread.sleep(5000);
        
        driver.switchTo().frame(0);
        
        driver.findElement(By.xpath("//input[contains(@type,'text')]")).sendKeys("abhaygaikwad@gmail.com");
        driver.findElement(By.xpath("//input[contains(@type,'password')]")).sendKeys("Pass123@");
        driver.findElement(By.xpath("//button[text()='Submit']")).click();
        
        Thread.sleep(3000);
        String title = driver.getTitle();
        Assert.assertEquals(title, "sweet-shockley-z3t0c9 - CodeSandbox");
    }
    
    @AfterTest
    public void teardown() {
        driver.quit();
    }
}