package com.training.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import AutoHackathon.Project.DataDriver.HashMapNew;

public class offerPage {

	WebDriver oDriver;
	ExtentReports oExtentReports;
	ExtentTest oExtentTest;
	HashMapNew dictionary;

	//Constructor
	public offerPage(WebDriver oDriver, ExtentReports oExtentReports, ExtentTest oExtentTest, HashMapNew dictionary) {
		this.oDriver=oDriver;
		this.oExtentReports=oExtentReports;
		this.oExtentTest=oExtentTest;
		this.dictionary=dictionary;
	}
	
	//objects
	By userName =By.xpath("//span[@class='user-name']");
	By signOutBtn =By.xpath("//a[@href='/users/sign_out']");
	
	//UI function
	
	public boolean fsignOut() {
		WebElement eUserName =oDriver.findElement(userName);
		WebElement eSignOutBtn =oDriver.findElement(signOutBtn);
		eUserName.click();
		oExtentTest.log(LogStatus.PASS, "Clicked on User name to sign Off");
		eSignOutBtn.click();
		return true;
	}
}
