package com.example.ExampleProject;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SnapDealThird {

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\ELCOT\\Selenium-workspace\\ExampleProject\\Driver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.snapdeal.com");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(1000, TimeUnit.SECONDS);
		String handles = driver.getWindowHandle();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement serachData = driver.findElement(By.id("inputValEnter"));
		serachData.sendKeys("oneplus 7");
		WebElement goText = driver.findElement(By.xpath("//span[@class='searchTextSpan']"));
		goText.click();
		List<WebElement> listData = driver.findElements(By.xpath("//p[@class='product-title']"));
		List<WebElement> data = new ArrayList<WebElement>();

		for (int i = 0; i < listData.size(); i++) {
			data.addAll(listData);
			String name = data.get(i).getText();
			System.out.println(name);
		}
		js.executeScript("arguments[0].click();", data.get(0));
		driver.switchTo().window(handles);
		js.executeScript("arguments[0].click();", data.get(1));
		driver.switchTo().window(handles);
		js.executeScript("arguments[0].click();", data.get(2));
	}
}
