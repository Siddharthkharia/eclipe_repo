package com.training.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import AutoHackathon.Project.DataDriver.HashMapNew;

public class landingPage {
	

	WebDriver oDriver;
	ExtentReports oExtentReports;
	ExtentTest oExtentTest;
	HashMapNew dictionary;

	//Constructor
	public landingPage(WebDriver oDriver, ExtentReports oExtentReports, ExtentTest oExtentTest, HashMapNew dictionary) {
		this.oDriver=oDriver;
		this.oExtentReports=oExtentReports;
		this.oExtentTest=oExtentTest;
		this.dictionary=dictionary;
	}
	
	//objects
	By signInBtn = By.xpath("//a[@href='/users/sign_in']");
	
	//UI Function
	
	public boolean fcheckLastPage() {
		WebElement eSignInBtn = oDriver.findElement(signInBtn);
		
		if(eSignInBtn.isDisplayed()){
			
			oExtentTest.log(LogStatus.PASS, "Sign Out is Successful");
			return true;
			
		}
		else {
			oExtentTest.log(LogStatus.FAIL, "Sign Out was unsuccessful");
			return false;
		}
	}

}
