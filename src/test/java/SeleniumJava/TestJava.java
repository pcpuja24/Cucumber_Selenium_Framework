package SeleniumJava;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestJava {
    public WebDriver driver;

    public void setUp(String url)
    {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(url);
        System.out.println("Url opened");
    }
    public void teardown(){

        driver.quit();
        System.out.println("Browser closed");
    }
    public void login(){
        System.out.println("Login successfully");
    }
}
