package org.cts.oneframework.seleniumadapter.utils;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.cts.oneframewok.seleniumadapter.drivers.DriverManager;
import org.cts.oneframewok.seleniumadapter.drivers.DriverManagerFactory;
import org.cts.oneframework.configprovider.ConfigProvider;
import org.cts.oneframework.excelreader.ExcelDataProvider;
import org.cts.oneframework.utilities.Screenshots;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;

import io.appium.java_client.MobileElement;
import io.appium.java_client.ios.IOSDriver;

@Listeners(org.cts.oneframework.listeners.TestListener.class)
public class BaseTest {

	private static ThreadLocal<DriverManager> driverManager = new ThreadLocal<>();
	private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();
	public static Logger logger = LogManager.getLogger(BaseTest.class.getName());
	private String browserName = ConfigProvider.getAsString("browser");

	public void folderCleanup() throws IOException {
		File file = new File(Screenshots.getScreenshotsFolderPath());
		if (file.exists())
			FileUtils.cleanDirectory(file);
	}

	@DataProvider(name = "data")
	public Object[][] readExcelData(Method method) {
		logger.debug("Reading data from excel.");
		return new ExcelDataProvider(getClass()).data(method);
	}

	public IOSDriver<MobileElement> getDriver() {
		if (driverManager.get() == null)
			driverManager.set(DriverManagerFactory.getManager(browserName));
		driver.set(driverManager.get().getDriver());
		driver.get().manage().timeouts().implicitlyWait(ConfigProvider.getAsInt("ImplicitWait"), TimeUnit.SECONDS);
		if (!browserName.equalsIgnoreCase("chrome"))
			driver.get().manage().window().maximize();
		return (IOSDriver<MobileElement>) driver.get();
	}

	@AfterSuite(alwaysRun = true)
	public void stopDriverService() {
		driverManager.get().stopService();
	}

	public void launchApplication(String url) {
		getDriver().get(url);
		Screenshots.addStepWithScreenshotInReport((IOSDriver<MobileElement>) driver.get(), "Application launched: <a href=\"" + url + "\">" + url + "</a>");
	}

}
