package com.example;
import com.example.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AppTest extends BaseTest{
   
        App AppPage;
        @Test
        public void Login_With_Valid_Credintials() throws InterruptedException {
            AppPage = new App(driver);
            AppPage.NavigateToSatvicMovementPage();
            String name = "ritika";
            String email = "ritikaoswal63@gmail.com";
            String mobile = "8888261097";
            String city = "Pune";
            AppPage.RegisterWithValidCredentials(name, email, mobile,city);
        }

        @Test
        public void Login_With_Invalid_Credintials() throws InterruptedException{
            AppPage = new App(driver);
            AppPage.NavigateToSatvicMovementPage();
            String name = "ritika";
            String email = "test";
            String mobile = "8888261097";
            String city = "Pune";
            AppPage.RegisterWithInValidCredentials(name, email, mobile,city);
        }
    

    
}



