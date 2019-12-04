package org.cts.oneframework.seleniumadapter.tests;

import org.cts.oneframework.configprovider.ConfigProvider;
import org.cts.oneframework.seleniumadapter.utils.BaseTest;
import org.cts.oneframework.utilities.RecordScreen;
import org.cts.oneframework.utilities.WaitUtils;
import org.testng.annotations.Test;

public class VerifyScreenRecordingTest extends BaseTest {

	@Test
	public void verifyScreenRecordingTest() throws InterruptedException {
		RecordScreen.starts("VerifyScreenRecordingTest");
		launchApplication(ConfigProvider.getAsString("url"));
		WaitUtils.sleep(5000);
		launchApplication(ConfigProvider.getAsString("url"));
		RecordScreen.stops();
	}
}
