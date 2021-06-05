package com.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AccountsPage {
	private WebDriver driver;
	private By accountsSection = By.cssSelector("div#center_column span");

	public AccountsPage(WebDriver driver) {
		this.driver = driver;
	}

	public int getAccountsSection() {
		return driver.findElements(accountsSection).size();
	}
	
	public String AccountsPageTitle() {
		return driver.getTitle();
	}
public List<String> getAccountsSectionList() {
	List<WebElement> accountsHeaderList = driver.findElements(accountsSection);
	List<String> accountlist = new ArrayList<>();
	for(WebElement ele: accountsHeaderList) {
		String text = ele.getText();
		System.out.println(text);
		accountlist.add(text);
	}
	 
	return accountlist;
}
}
