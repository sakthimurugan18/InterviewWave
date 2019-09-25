package com.example.ExampleProject;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;

public class ReadProperties {

	public static void main(String[] args) throws IOException {

		Logger log = Logger.getLogger(ReadProperties.class);

		String fileName = "C:\\Users\\ELCOT\\Selenium-workspace\\ExampleProject\\Config\\Config.properties";
		Properties prop = new Properties();
		FileInputStream input = new FileInputStream(fileName);
		prop.load(input);
		String userName = prop.getProperty("user");
		String Pass = prop.getProperty("pass");
		String browsername = prop.getProperty("browser");

		if (browsername.equals("panthomjs")) {
			System.setProperty("webdriver.chrome.driver",
					"C:\\Users\\ELCOT\\Selenium-workspace\\ExampleProject\\Driver\\chromedriver.exe");
			ChromeOptions option = new ChromeOptions();
			option.addArguments("window-size-1000-400");
			option.addArguments("headless");
			WebDriver driver = new ChromeDriver(option);
			log.info("browser launchedn Sucessfully");
			driver.get(prop.getProperty("url"));
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(1000, TimeUnit.SECONDS);
			driver.findElement(By.id("email")).sendKeys(userName);
			driver.findElement(By.id("pass")).sendKeys(Pass);
			log.info("Sucessfullt Launched to the facebook page");
			String url = driver.getCurrentUrl();
			log.info("The current Url" + url);
			if (prop.getProperty("url").equals(url)) {
				System.out.println("Testcase got passed");
				log.info("Loop enter in the if contion condition working fine");
			}
			log.info("*****Condition get failed ******");
			driver.quit();
		} else if (browsername.equals("Firefox")) {
			System.setProperty("webdriver.gecko.driver",
					"C:\\Users\\ELCOT\\Selenium-workspace\\ExampleProject\\Driver\\geckodriver.exe");
			WebDriver driver = new FirefoxDriver();
		} else {
			System.out.println("No Browser Found");
		}
	}

}
