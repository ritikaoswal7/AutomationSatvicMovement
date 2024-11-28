package com.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
/**
 * Hello world!
 *
 */
public class App extends BasePage
{
    public App(WebDriver driver) {
        super(driver);
        //TODO Auto-generated constructor stub
    }

    public void NavigateToSatvicMovementPage() throws InterruptedException{
        driver.get("https://detox.satvicmovement.org/");
        //Telling the driver to wait till Register Now button is displayed
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div//a[@class='btn-get-started scrollto register-now-track-btn']")));
        Thread.sleep(3000);
    }

    public void RegisterWithValidCredentials(String name, String email, String Mobile,String City) throws InterruptedException{
        driver.findElement(By.xpath("//div//a[@class='btn-get-started scrollto register-now-track-btn']")).click();
        //wait till the form is displayed
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h3[contains(text(),'Register Now')]")));
        //Enter the name 
        driver.findElement(By.xpath("//input[@name='reg-name']")).sendKeys(name);
        //Enter the email
        driver.findElement(By.xpath("//input[@name='reg-email']")).sendKeys(email);
        //Enter mobileno
        driver.findElement(By.xpath("//input[@name='reg-mob']")).sendKeys(Mobile);
        //Enter City
        driver.findElement(By.xpath("//input[@name='reg-city']")).sendKeys(City);
        //Choose time slot
        Thread.sleep(3000);
        driver.findElement(By.xpath("//select[@id='time_slot']")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//select[@id='time_slot']//option[contains(text(),'Choose your time slot*')]")));
        Thread.sleep(6000);
        driver.findElement(By.xpath("//select[@id='time_slot']//option[2]")).click();
        //check the terms and conditions
        driver.findElement(By.xpath("//input[@class='form-check-input']")).click();
        Thread.sleep(5000);
        //click on Register now button
        driver.findElement(By.xpath("//button[@id='pay_button']")).click();
        Thread.sleep(5000);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[@id='registration_confirm']")));
        String result = driver.findElement(By.xpath("//h1[@id='registration_confirm']")).getText();
        String Expectedresult = "Registration confirmed!";
        result.equals(Expectedresult);
    }

    public void RegisterWithInValidCredentials(String name, String email, String Mobile,String City) throws InterruptedException{
        Thread.sleep(3000);
        driver.findElement(By.xpath("//div//a[@class='btn-get-started scrollto register-now-track-btn']")).click();
        //wait till the form is displayed
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h3[contains(text(),'Register Now')]")));
        //Enter the name 
        driver.findElement(By.xpath("//input[@name='reg-name']")).sendKeys(name);
        //Enter the email
        driver.findElement(By.xpath("//input[@name='reg-email']")).sendKeys(email);
        //Enter mobileno
        driver.findElement(By.xpath("//input[@name='reg-mob']")).sendKeys(Mobile);
        //Enter City
        driver.findElement(By.xpath("//input[@name='reg-city']")).sendKeys(City);
        //Choose time slot
        Thread.sleep(3000);
        driver.findElement(By.xpath("//select[@id='time_slot']")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//select[@id='time_slot']//option[contains(text(),'Choose your time slot*')]")));
        Thread.sleep(6000);
        driver.findElement(By.xpath("//select[@id='time_slot']//option[3]")).click();
        //check the terms and conditions
        driver.findElement(By.xpath("//input[@class='form-check-input']")).click();
        Thread.sleep(5000);
        //click on Register now button
        driver.findElement(By.xpath("//button[@id='pay_button']")).click();
        Thread.sleep(5000);
        //Verify email field error message
        String result = driver.findElement(By.xpath("//div[@id='email_error']")).getText();
        String Expectedresult = "Please enter valid email";
        result.equals(Expectedresult);
    }

}
