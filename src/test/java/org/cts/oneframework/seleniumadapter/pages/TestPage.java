package org.cts.oneframework.seleniumadapter.pages;

import org.cts.oneframework.utilities.AssertionLibrary;
import org.cts.oneframework.utilities.AssertionLibrary.Screenshot;
import org.cts.oneframework.utilities.BasePageObject;
import org.openqa.selenium.WebDriver;

import io.appium.java_client.MobileElement;
import io.appium.java_client.ios.IOSDriver;

public class TestPage extends BasePageObject {

	public TestPage(IOSDriver<MobileElement> webDriver) {
		super(webDriver);
	}
	public void assertTitle() {	
		AssertionLibrary.assertTrue(getText("//div[@id='logo']/a").contains("TestAutomationGuru"), "matched");
		AssertionLibrary.assertTrue(getText("//div[@id='logo']/a").contains("TestAutomationGuru"), "matched", Screenshot.NOT_REQUIRED);
	}

}
