package org.cts.oneframework.seleniumadapter.tests;

import org.cts.oneframework.seleniumadapter.utils.BaseTest;
import org.testng.annotations.Test;

public class VerifyUrl extends BaseTest {

	@Test
	public void verifyUrl_test() {
		launchApplication("https://stackoverflow.com/");
	}
}
