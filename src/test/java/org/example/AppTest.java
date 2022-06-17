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

        Thread.sleep(5000);

        Assert.assertEquals(message, "Success", "Internet Issues");

        driver.quit();
    }
}
