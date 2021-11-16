package PK;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Register {
    public static void main(String[] args) throws InterruptedException {


        System.setProperty("webdriver.chrome.driver", "C:\\Users\\sana.rizvi\\Downloads\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://dev74.onlinetestingserver.com/compass_furniture/");

        //double click dropdown
        Actions ac = new Actions(driver);
        WebElement dClick = driver.findElement(By.xpath("//div[@class='collapse navbar-collapse']//ul//li[7]//div//a//i"));
        ac.doubleClick(dClick).perform();

        //login
        driver.findElement(By.xpath("//div[@class='collapse navbar-collapse']//ul//li[7]//div//div//a[1]")).click();

        driver.findElement(By.xpath("//input[@name='email']")).sendKeys("xyz123@mailinator.com");
        driver.findElement(By.xpath("//input[@name='password']")).sendKeys("Testing@123");
        driver.findElement(By.xpath("//label[@class='form-check-label']")).click();
        driver.findElement(By.xpath("//button[contains(text(),'SIGN IN')]")).click();
        //navigate home from dashboard
        driver.findElement(By.linkText("Home")).click();
        Thread.sleep(1000);
        //scroll down the home page to find a show products button
        JavascriptExecutor je = (JavascriptExecutor) driver;
        WebElement element = driver.findElement(By.xpath("//body/div[@id='app']/section[3]/div[1]/div[1]/div[2]/a[1]"));
        je.executeScript("arguments[0].scrollIntoView(true);",element);
        element.click();
        //select product and add to cart
        Thread.sleep(1000);
        driver.findElement(By.xpath("//div[@class='list-product-card-inner']//div[2]//div[4]//button//i")).click();
        driver.findElement(By.xpath("//div[@class='list-product-card-inner']//div[2]//button")).click();
        driver.findElement(By.xpath("//div[@class='collapse navbar-collapse']//ul//li[8]//a//i")).click();

        //locate and logout from account
        //double click dropdown
        Thread.sleep(1000);
        Actions ac1 = new Actions(driver);
        WebElement dClick1 = driver.findElement(By.xpath("//div[@class='col-12']//nav//div//ul//li[7]//div//a//i"));
        ac1.doubleClick(dClick1).perform();
        Thread.sleep(1000);
        driver.findElement(By.linkText("Account")).click();
        driver.findElement(By.linkText("Logout")).click();

    }
}
