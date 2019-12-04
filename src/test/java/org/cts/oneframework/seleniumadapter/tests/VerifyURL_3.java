package org.cts.oneframework.seleniumadapter.tests;

import org.cts.oneframework.seleniumadapter.utils.BaseTest;
import org.testng.annotations.Test;

public class VerifyURL_3 extends BaseTest {

	@Test
	public void verifyUrl_3test() {
		launchApplication("https://gmail.com/");
	}
}

