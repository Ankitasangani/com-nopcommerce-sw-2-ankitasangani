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
 * 1. LoginTest
 * <p>
 * 3. Write down the following test into ‘LoginTest’ class
 * 1. userShouldNavigateToLoginPageSuccessfully *
 * click on the ‘Login’ link
 * * Verify the text ‘Welcome, Please Sign
 * In!’
 * <p>
 * 2. userShouldLoginSuccessfullyWithValidCredentials
 * <p>
 * * click on the ‘Login’ link
 * * Enter valid username
 * * Enter valid password
 * * Click on ‘LOGIN’ button
 * * Verify the ‘Log out’ text is display
 * <p>
 * 3. verifyTheErrorMessage
 * <p>
 * * click on the ‘Login’ link
 * * Enter invalid username
 * * Enter invalid password
 * * Click on Login button
 * * Verify the error message ‘Login was unsuccessful.
 * Please correct the errors and try again. No customer account found’
 */

public class LoginTest extends BaseTest {

    String baseUrl = "https://demo.nopcommerce.com/";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test
    public void userShouldNavigateToLoginPageSuccessfully() {
        // Click on Login button
        driver.findElement(By.xpath("//a[@class='ico-login']")).click();

        // Verify the text “Welcome, Please Sign In!”
        String expectedText = "Welcome, Please Sign In!";
        String actualText = driver.findElement(By.xpath("//h1[text()='Welcome, Please Sign In!']")).getText();
        Assert.assertEquals("Text didn't Match!", expectedText, actualText);
    }

    @Test
    public void userShouldLoginSuccessfullyWithValidCredentials() {


        // Click on Login icon
        driver.findElement(By.xpath("//a[@class='ico-login']")).click();

        // Enter Username
        driver.findElement(By.xpath("//input[@id='Email']")).sendKeys("ankita123@gmail.com");
        // Enter password
        driver.findElement(By.xpath("//input[@id='Password']")).sendKeys("ankita123");
        // Click on Login button
        driver.findElement(By.xpath("//button[@class='button-1 login-button']")).click();

        // Verify the text “Log out”
        String expectedText = "Log out";
        String actualText = driver.findElement(By.xpath("//a[text()='Log out']")).getText();
        Assert.assertEquals("Text didn't Match!", expectedText, actualText);
    }

    @Test
    public void verifyTheErrorMessage() {
        // Click on Login icon
        driver.findElement(By.xpath("//a[@class='ico-login']")).click();

        // Enter Username
        driver.findElement(By.xpath("//input[@id='Email']")).sendKeys("prime123@gmail.co");
        // Enter password
        driver.findElement(By.xpath("//input[@id='Password']")).sendKeys("rime123");
        // Click on Login button
        driver.findElement(By.xpath("//button[@class='button-1 login-button']")).click();

        // Verify the text “Login was unsuccessful. Please correct the errors and try again. No customer account found”
        String expectedText = "Login was unsuccessful. Please correct the errors and try again.\n" +
                "No customer account found";
        String actualText = driver.findElement(By.xpath("//div[@class='message-error validation-summary-errors']")).getText();
        Assert.assertEquals("Text didn't Match!", expectedText, actualText);
    }

    @After
    public void tearDown() {
        closeBrowser();
    }
}
