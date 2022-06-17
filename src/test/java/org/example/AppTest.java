package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

public class AppTest {
    WebDriver driver = new ChromeDriver();
    @Test
    public void testingCaptiveSiteSuccesfulConnection() throws Exception {
        driver.get("http://captive.apple.com/");

        WebElement labelMessage = driver.findElement(By.xpath("//body[contains(text(), 'Success')]"));

        String message = labelMessage.getText();

        Thread.sleep(1000);

        Assert.assertEquals(message, "Success", "Internet Issues");
    }

    @Test
    public void verifyIntranetSuccessfulLogin() throws Exception {
        driver.get("https://oktana.force.com/s/");

        Thread.sleep(1000);

        WebElement oktanaGmailLoginButton = driver.findElement(By.xpath("//button[@title='Oktana_Gmail']"));
        oktanaGmailLoginButton.click();

        Thread.sleep(2000);

        WebElement emailField = driver.findElement(By.xpath("//input[@type='email']"));
        emailField.sendKeys("roger.ruiz@oktana.com");

        WebElement nextButton = driver.findElement(By.xpath("//span[contains(text(), 'Next')]"));
        nextButton.click();

        Thread.sleep(2000);

        WebElement passwordField = driver.findElement(By.xpath("//input[@type='password']"));
        passwordField.sendKeys("Oktana@987632149");

        WebElement passwordNextButton = driver.findElement(By.xpath("//span[contains(text(), 'Next')]/ancestor::button"));
        passwordNextButton.click();

        Thread.sleep(25000);

        String pageTitle = driver.getTitle();

        Assert.assertEquals(pageTitle, "Home", "You didn't accept the 2 verification step with your phone");

    }

    @AfterTest
    public void tearDown() {
        driver.quit();
    }
}
