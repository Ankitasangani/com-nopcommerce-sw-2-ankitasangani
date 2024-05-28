package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

/**
 * 2. Create the package ‘testsuite’ and create the
 * following classes inside the ‘testsuite’ package.
 * <p>
 * 3. RegisterTest
 * <p>
 * 5. Write down the following test into ‘RegisterTest’
 * class
 * 1. userShouldNavigateToRegisterPageSuccessful
 * ly
 * * click on the ‘Register’ link
 * * Verify the text ‘Register’
 * <p>
 * 2. userShouldRegisterAccountSuccessfully *
 * click on the ‘Register’ link
 * * Select gender radio button
 * * Enter First name
 * * Enter Last name
 * * Select Day Month and Year
 * * Enter Email address
 * * Enter Password
 * * Enter Confirm password
 * * Click on REGISTER button
 * * Verify the text 'Your registration
 * completed’
 */

public class RegisterTest extends BaseTest {
    String baseUrl = "https://demo.nopcommerce.com/";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }


    @Test
    public void userShouldNavigateToRegisterPageSuccessfully() {
        // click on the "Register" link
        driver.findElement(By.xpath("//a[text()='Register']")).click();

        // Verify the text “Register”
        String expectedText = "Register";
        String actualText = driver.findElement(By.xpath("//div[@class='page-title']//h1[text()='Register']")).getText();
        Assert.assertEquals("Text didn't Match!", expectedText, actualText);
    }

    @Test
    public void userShouldRegisterAccountSuccessfully() {
        String userName = "" + (int) (Math.random() * Integer.MAX_VALUE);            //Create random username
        String emailID = "User" + userName + "@example.com";                        //Create random email Id

        // click on the "Register" link
        driver.findElement(By.xpath("//a[text()='Register']")).click();

        // Select gender radio button
        driver.findElement(By.xpath("//input[@id='gender-female']")).click();

        // Enter First Name
        driver.findElement(By.xpath("//input[@id='FirstName']")).sendKeys("Ankita");
        // Enter Last name
        driver.findElement(By.xpath("//input[@id='LastName']")).sendKeys("Sangani");

        // Select Day Month and Year
        driver.findElement(By.xpath("//select[@name='DateOfBirthDay']")).click();
        driver.findElement(By.xpath("//option[text()='3']")).click();
        driver.findElement(By.xpath("//select[@name='DateOfBirthMonth']")).click();
        driver.findElement(By.xpath("//option[text()='February']")).click();
        driver.findElement(By.xpath("//select[@name='DateOfBirthYear']")).click();
        driver.findElement(By.xpath("//option[text()='1997']")).click();

        // Enter Email address
        driver.findElement(By.xpath("//input[@id='Email']")).sendKeys(emailID);
        // Enter Password
        driver.findElement(By.xpath("//input[@id='Password']")).sendKeys("ankita123");
        // Enter Confirm password
        driver.findElement(By.xpath("//input[@id='ConfirmPassword']")).sendKeys("ankita123");
        // Click on REGISTER button
        driver.findElement(By.xpath("//button[@id='register-button']")).click();

        //Verify the text "Your registration completed"
        String expectedText = "Your registration completed";
        String actualText = driver.findElement(By.xpath("//div[text()='Your registration completed']")).getText();
        Assert.assertEquals("Text didn't Match!", expectedText, actualText);

    }

    @After
    public void tearDown() {
        closeBrowser();
    }

}


























