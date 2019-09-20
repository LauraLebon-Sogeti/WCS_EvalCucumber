package Outils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverManager {
	
	public static WebDriver driver;
	public static String urlSite = "http://demowebshop.tricentis.com";
	
	public WebDriver OuvrirNavigateur(String nomDriver){
		if (nomDriver == "chrome") {
			//System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\chromedriver.exe");
			driver = new ChromeDriver();
		}
		else
		{
			driver = new FirefoxDriver();
		}
		return driver;
	}

}
