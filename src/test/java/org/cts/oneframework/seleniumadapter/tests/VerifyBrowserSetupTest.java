package org.cts.oneframework.seleniumadapter.tests;

import java.util.Map;

import org.cts.oneframework.annotation.ExcelDetails;
import org.cts.oneframework.configprovider.ConfigProvider;
import org.cts.oneframework.seleniumadapter.pages.TestPage;
import org.cts.oneframework.seleniumadapter.utils.BaseTest;
import org.testng.annotations.Test;

@ExcelDetails
public class VerifyBrowserSetupTest extends BaseTest {

	@Test(dataProvider = "data")
	public void verifyBrowserSetup_Test(Map<String, String> input) {
		System.out.println(input.get("Name"));
		launchApplication(ConfigProvider.getAsString("url"));
		new TestPage(getDriver()).assertTitle();
	}
}