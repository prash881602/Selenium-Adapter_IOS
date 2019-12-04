package org.cts.oneframework.seleniumadapter.tests;

import org.cts.oneframework.seleniumadapter.utils.BaseTest;
import org.testng.annotations.Test;

public class VerifyURL_2 extends BaseTest {

	@Test
	public void verifyUrl_2test() {
		launchApplication("https://google.com/");
	}
}
