package lelongweb

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import org.openqa.selenium.WebDriver
import com.kms.katalon.core.webui.driver.DriverFactory
import org.openqa.selenium.By

import internal.GlobalVariable
import sun.util.logging.resources.logging

public class keyword {

	//Method to count element
	@Keyword
	def countElement(String element) {
		WebDriver driver = DriverFactory.getWebDriver()
		return driver.findElements(By.xpath(element)).size()
	}

	//method to verify element contains string
	//	@Keyword
	//	def checkElementContains(TestObject to, String text) {
	//		try {
	//			WebUI.getText(to).contains(text)
	//		} catch(Exception e) {
	//			println "failed"
	//		}
	//	}

	//Method to set text
	@Keyword
	def setText(TestObject to, String text) {
		try {
			WebUI.setText(to, text)
		} catch (Exception e) {
			println "failed"
		}
	}
}
