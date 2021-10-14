package com.training.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import AutoHackathon.Project.DataDriver.HashMapNew;

public class logInPage {

	WebDriver oDriver;
	ExtentReports oExtentReports;
	ExtentTest oExtentTest;
	HashMapNew dictionary;


	public logInPage(WebDriver oDriver, ExtentReports oExtentReports, ExtentTest oExtentTest, HashMapNew dictionary) {
		this.oDriver=oDriver;
		this.oExtentReports=oExtentReports;
		this.oExtentTest=oExtentTest;
		this.dictionary=dictionary;
	}


	//objects

	By txtEmail = By.id("user_email");
	By txtPass = By.id("user_password");
	By btnSignIn = By.id("btn-signin");


	//UI Methods

	public boolean fCheckLogin() {
		WebElement eTextEmail =oDriver.findElement(txtEmail);

		if (eTextEmail.isDisplayed()) {
			oExtentTest.log(LogStatus.PASS, "Login is Sucessful");
			return true;
		}
		else {
			oExtentTest.log(LogStatus.FAIL, "Login is Failed");
			return false;
		}
	}

	public boolean fLogin() {
		WebElement eTextEmail =oDriver.findElement(txtEmail);
		WebElement eTxtPass =oDriver.findElement(txtPass);
		WebElement eBtnSignIn =oDriver.findElement(btnSignIn);
		
		eTextEmail.sendKeys(dictionary.get("EMAIL_ID"));
		oExtentTest.log(LogStatus.INFO, "Entering User Name");
		eTxtPass.sendKeys(dictionary.get("PASSWORD"));
		oExtentTest.log(LogStatus.INFO, "Entering Password");
		eBtnSignIn.click();
		
		
		return true;
	}

}
