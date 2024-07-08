package AutomationUI;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

@Test
public class registerUserPO {

    public void Setup() {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*");
        chromeOptions.addArguments("--incognito");
//        chromeOptions.addArguments("--headless");
        chromeOptions.addArguments("--start-maximized");
        chromeOptions.addArguments("window-size=1366,768");
        chromeOptions.addArguments("--no-sandbox");

        WebDriver driver = new ChromeDriver(chromeOptions);


        //register user

        //open website
        driver.get("https://automationexercise.com/");

        //click button signup / login
        driver.findElement(By.xpath("//a[contains(.,'Signup / Login')]")).click();

        //input name in signup section
        driver.findElement(By.xpath("//input[@name='name']")).sendKeys("Esmeralda");

        //input email address in signup section
        driver.findElement(By.xpath("//div[@class='signup-form']//input[@name='email']")).sendKeys("markicob@gmail.com");

        //click button signup
        driver.findElement(By.xpath("//button[.='Signup']")).click();

        //choose title Mrs
        driver.findElement(By.xpath("//input[@value='Mrs']")).click();

        //input password register
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("Automation01!");

        //input day of birth
        driver.findElement(By.xpath("//select[@id='days']")).sendKeys("14");

        //input month of birth
        driver.findElement(By.xpath("//select[@id='months']")).sendKeys("03");

        //input year of birth
        driver.findElement(By.xpath("//select[@id='years']")).sendKeys("1990");

        //checklist newsletter
        driver.findElement(By.xpath("//input[@id='newsletter']")).click();

        //checklist special offers
        driver.findElement(By.xpath("//input[@id='optin']")).click();

        //input first name register
        driver.findElement(By.xpath("//input[@id='first_name']")).sendKeys("Esmeralda");

        //input last name register
        driver.findElement(By.xpath("//input[@id='last_name']")).sendKeys("Ayamor");

        //input company register
        driver.findElement(By.xpath("//input[@id='company']")).sendKeys("Daydream.co");

        //input address 1 register
        driver.findElement(By.xpath("//input[@id='address1']")).sendKeys("Anggrek street");

        //input address 2 register
        driver.findElement(By.xpath("//input[@id='address2']")).sendKeys("blok b2");

        //input country register
        driver.findElement(By.xpath("//select[@id='country']")).sendKeys("singapore");

        //input state register
        driver.findElement(By.xpath("//input[@id='state']")).sendKeys("SIN");

        //input city register
        driver.findElement(By.xpath("//input[@id='city']")).sendKeys("Kranji");

        //input zip code register
        driver.findElement(By.xpath("//input[@id='zipcode']")).sendKeys("739462");

        //input mobile number register
        driver.findElement(By.xpath("//input[@id='mobile_number']")).sendKeys("+6528839212");

        //checklist button create account register
        driver.findElement(By.xpath("//button[.='Create Account']")).click();

        WebElement successMessage = driver.findElement(By.xpath("//p[.='Congratulations! Your new account has been successfully created!']"));
        if (successMessage.isDisplayed()){
            System.out.println("Success create account" + successMessage.getText());
        } else {
            System.out.println("Failed create account");
        }

        //click button continue
        driver.findElement(By.xpath("//a[.='Continue']")).click();

        //after a successful signup for automation, the newly created account will be deleted for repeated use.
        driver.findElement(By.xpath("//a[contains(.,'Delete Account')]")).click();

        //then success deleted account
        WebElement deleteUser = driver.findElement(By.xpath("//b[.='Account Deleted!']"));
        if (deleteUser.isDisplayed()) {
            System.out.println("Account delete success message " + deleteUser.getText());
        } else {
            System.out.println("Account failed delete");
        }
        driver.findElement(By.xpath("//a[.='Continue']")).click();

        //close the driver
        driver.quit();
    }

}
