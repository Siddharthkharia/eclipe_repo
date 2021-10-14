package com.training.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import AutoHackathon.Project.DataDriver.HashMapNew;

public class homePage {
	
	//initialization
	WebDriver oDriver;
	ExtentReports oExtentReports;
	ExtentTest oExtentTest;
	HashMapNew dictionary;
	
	//Constructor
	public homePage(WebDriver oDriver, ExtentReports oExtentReports, ExtentTest oExtentTest, HashMapNew dictionary) {
		this.oDriver=oDriver;
		this.oExtentReports=oExtentReports;
		this.oExtentTest=oExtentTest;
		this.dictionary=dictionary;
	}
	
	
	//Objects
	//By searchForm= By.id("search-form");
	By searchOffer= By.xpath("//div[@class='published card course-card']");
	
	//UI Functions
	public boolean fvalidPage() {
		WebElement eSearchElement= oDriver.findElement(searchOffer);
		if (eSearchElement.isDisplayed()) {
			oExtentTest.log(LogStatus.PASS, "HomePage is Visible");
			return true;
		}
		else {
			oExtentTest.log(LogStatus.FAIL, "HomePage was not Found !! ");
			return false;
		}
		
	}
	
	public boolean fSelectOffer() {
		
		WebElement eSearchElement= oDriver.findElement(searchOffer);
		
		eSearchElement.click();
		oExtentTest.log(LogStatus.PASS, "Successfully Selected the Offer");
		
		return true;
	}

}
