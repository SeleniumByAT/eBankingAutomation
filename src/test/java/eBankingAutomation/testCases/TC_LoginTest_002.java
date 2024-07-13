package eBankingAutomation.testCases;

import java.io.IOException;

import org.openqa.selenium.NoAlertPresentException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import eBankingAutomation.pageObject.LoginPage;
import eBankingAutomation.testUtility.ExcelUtillity;
import junit.framework.Assert;

public class TC_LoginTest_002 extends BaseClass {

	@Test(dataProvider = "logindata")
	public void loginTDD(String username, String password) {

		LoginPage lp = new LoginPage(driver);
		lp.setUsername(username);
		lp.setPassword(password);

		lp.clickSubmit();

		if (isAlertPresent() == true) {
			Assert.assertTrue(false);
			driver.switchTo().alert().accept();
			captureScreenshot(driver, "loginTDD");
			driver.switchTo().defaultContent();
			
		} else {

			Assert.assertTrue(true);
			lp.clickLogout();
			driver.switchTo().alert().accept();
			driver.switchTo().defaultContent();
		}
	}

	@DataProvider(name = "logindata")
	String[][] LoginData() throws IOException {

		String file = System.getProperty("user.dir") + "/src/test/java/eBankingAutomation/testData/dataforlogin.xlsx";

		int rownum = ExcelUtillity.getRowNum(file, "Sheet1");
		int cellnum = ExcelUtillity.getCellNum(file, "Sheet1", 1);
		String login[][] = new String[rownum][cellnum];

		for (int r = 1; r <= rownum; r++) {
			for (int c = 0; c < cellnum; c++) {
				login[r - 1][c] = ExcelUtillity.getCellData(file, "Sheet1", r, c);
			}
		}
		return login;
	}

	public boolean isAlertPresent() {
		try {
			driver.switchTo().alert();
			return true;
		} catch (NoAlertPresentException e) {
			return false;
		}
	}
}
