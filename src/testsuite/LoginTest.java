package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginTest extends BaseTest {
    String baseUrl = "http://the-internet.herokuapp.com/login";
    @Before
    public void setUp(){
        openBrowser(baseUrl);
    }
    @Test
    public void userShouldLoginSuccessfullyWithValidCredentials(){
        //Find username field and enter username
        driver.findElement(By.name("username")).sendKeys("tomsmith1");
        // Find password field and enter password
        driver.findElement(By.id("password")).sendKeys("SuperSecretPassword!");
        // find login link and click login link
        WebElement loginLink = driver.findElement(By.xpath("//i[starts-with(@class,'fa')]"));
        loginLink.click();
     String expectedMessage=  "Your username is invalid!\n" + "×";
        WebElement actualTextElement = driver.findElement(By.xpath("//*[contains(text(),'Your username is invalid!')]"));
      String actualMessage = actualTextElement.getText();
        Assert.assertEquals(expectedMessage,actualMessage);
    }
    @Test
    public void verifyThePasswordErrorMessage(){
        //Find username field and enter username
        driver.findElement(By.name("username")).sendKeys("tomsmith");
        // Find password field and enter password
        driver.findElement(By.id("password")).sendKeys("SuperSecretPassword");
        // find login link and click login link
        WebElement loginLink = driver.findElement(By.xpath("//i[starts-with(@class,'fa')]"));
        loginLink.click();
        String expectedMessage=   "Your password is invalid!\n" + "×";
        WebElement actualTextElement = driver.findElement(By.xpath("//*[contains(text(),'Your password is invalid')]"));
        String actualMessage = actualTextElement.getText();
        Assert.assertEquals(expectedMessage,actualMessage);

    }
    @After
    public void tearDown(){
        closeBrowser();
    }


}
