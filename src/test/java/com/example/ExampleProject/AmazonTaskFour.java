package com.example.ExampleProject;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import javax.security.auth.x500.X500Principal;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AmazonTaskFour {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\ELCOT\\Selenium-workspace\\ExampleProject\\Driver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.amazon.in/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(1000, TimeUnit.SECONDS);
		String handles = driver.getWindowHandle();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement search = driver.findElement(By.id("twotabsearchtextbox"));
		search.sendKeys("oneplus 7");
		WebElement submitBtn = driver.findElement(By.xpath("//input[@value='Go']"));
		submitBtn.click();
		List<WebElement> list = driver
				.findElements(By.xpath("//span[@class='a-size-medium a-color-base a-text-normal']"));
		List<WebElement> data = new ArrayList<WebElement>();
		for (int i = 0; i < list.size(); i++) {
			data.addAll(list);
			String name = data.get(i).getText();
			System.out.println(name);
		}
		js.executeScript("arguments[0].click();", data.get(0));
		driver.switchTo().window(handles);
		js.executeScript("arguments[0].click();", data.get(1));
		driver.switchTo().window(handles);
		js.executeScript("arguments[0].click();", data.get(2));
		Set<String> handle = driver.getWindowHandles();
		List<String> tab = new ArrayList<String>(handle);
		for (String x : tab) {	
		}
		driver.switchTo().window(tab.get(2));	
		System.out.println("========Specification of the Phone===========");
		
		WebElement txtData = driver.findElement(By.xpath("//div[@id='feature-bullets']"));
		String txtValue = txtData.getText();
		System.out.println(txtValue);
		driver.quit();
		}

	}
