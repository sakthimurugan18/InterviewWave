package com.example.ExampleProject;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AmazonTaskOne {

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\ELCOT\\Selenium-workspace\\ExampleProject\\Driver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.amazon.in/");
		driver.manage().window().maximize();
		WebElement search = driver.findElement(By.id("twotabsearchtextbox"));
		search.sendKeys("oneplus 7");
		WebElement submitBtn = driver.findElement(By.xpath("//input[@value='Go']"));
		submitBtn.click();
		List<WebElement> list = driver
				.findElements(By.xpath("//span[@class='a-size-medium a-color-base a-text-normal']"));

		List<WebElement> data = new ArrayList<WebElement>();

		for (int i = 0; i < list.size(); i++) {
			data.addAll(list);

		}
		System.out.println(data.get(0).getText());

		 for (WebElement listData : list) {
		 String ModelData = listData.getText();
		 System.out.println(ModelData);
		 }
		driver.quit();
	}

}
