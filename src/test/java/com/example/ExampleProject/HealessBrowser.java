package com.example.ExampleProject;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriverService;
import org.openqa.selenium.remote.DesiredCapabilities;

public class HealessBrowser {

	public static void main(String[] args) throws Throwable {
		Logger log = Logger.getLogger(ReadProperties.class);

		String fileName = "C:\\Users\\ELCOT\\Selenium-workspace\\ExampleProject\\Config\\Config.properties";
		Properties prop = new Properties();
		FileInputStream input = new FileInputStream(fileName);
		prop.load(input);
		String userName = prop.getProperty("user");
		String Pass = prop.getProperty("pass");
		String browsername = prop.getProperty("browser");
		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setJavascriptEnabled(true); // not really needed: JS enabled by default
		caps.setCapability(PhantomJSDriverService.PHANTOMJS_EXECUTABLE_PATH_PROPERTY,
				"C:\\Users\\ELCOT\\Selenium-workspace\\ExampleProject\\src\\test\\resources\\phantomjs.exe");
		WebDriver driver = new PhantomJSDriver(caps);
		driver.get("https://www.facebook.com/");
		log.info("browser launchedn Sucessfully");
		driver.get(prop.getProperty("url"));
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(1000, TimeUnit.SECONDS);
		driver.findElement(By.id("email")).sendKeys(userName);
		driver.findElement(By.id("pass")).sendKeys(Pass);
		log.info("Sucessfullt Launched to the facebook page");
		String url = driver.getCurrentUrl();
		log.info("The current Url" + url);

	}

}
