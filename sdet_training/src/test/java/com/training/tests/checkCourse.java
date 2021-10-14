package com.training.tests;

import com.training.pages.homePage;
import com.training.pages.landingPage;
import com.training.pages.logInPage;
import com.training.pages.offerPage;

import AutoHackathon.Project.AutomationConstants;
import AutoHackathon.Project.DataDriver;
import AutoHackathon.Project.DataDriver.HashMapNew;
import AutoHackathon.Project.MyTestNGBaseClass;
import org.testng.Assert;
import org.testng.annotations.Test;

public class checkCourse extends MyTestNGBaseClass{
	static DataDriver obj= new DataDriver();
	static HashMapNew dataMap= null;
	
	public static void getData() {
		dataMap=obj.fGetData(AutomationConstants.testDataPath + "Calendar.xlsx", "Check Course");
	}
	
	@Test
	public void validation() throws Throwable {
		
		getData();
		oExtentTest=oExtentReport.startTest("Create New Contract");
		
		//objects
		logInPage obj= new logInPage(oDriver, oExtentReport, oExtentTest, dataMap);
		
		Assert.assertTrue(obj.fCheckLogin());
		Assert.assertTrue(obj.fLogin());

		homePage homeObj= new homePage(oDriver, oExtentReport, oExtentTest, dataMap);
		Assert.assertTrue(homeObj.fvalidPage());
		Assert.assertTrue(homeObj.fSelectOffer());

		offerPage userObj= new offerPage(oDriver, oExtentReport, oExtentTest, dataMap);
		Assert.assertTrue(userObj.fsignOut());
		
		landingPage landingObj= new landingPage(oDriver, oExtentReport, oExtentTest, dataMap);
		Assert.assertTrue(landingObj.fcheckLastPage());
	}

}
