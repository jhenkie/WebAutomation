import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable

//Create reusable method because we will perform positive and negative scenario
void loginAction(String username, String password) {
	//Fill in username
	WebUI.setText(findTestObject('Login/Page_SignIn/input_UserName'), username)
	
	//Fill in password
	WebUI.setEncryptedText(findTestObject('Login/Page_SignIn/input_Password'), password)
	
	//Click sign in button
	WebUI.click(findTestObject('Login/Page_SignIn/btn_signIn'))
}

//Open browser
WebUI.openBrowser('')

//Navigate to URL
WebUI.navigateToUrl(GlobalVariable.Site_URL)

//Verify the url is correct
WebUI.verifyMatch(WebUI.getUrl(), GlobalVariable.Site_URL, false)

//Click login link
WebUI.click(findTestObject('Login/Page_Index/link-Login'))

//Call login method to perform failed scenario
loginAction(userInvalid, passwordInvalid)

//Verify invalid credential error message
WebUI.verifyElementText(findTestObject('Login/Page_SignIn/label_errorMessage'),errorInvalid)

//Call login method to perform success scenario
loginAction(userValid, passwordValid)

//Verify successfully login and check username
WebUI.verifyElementText(findTestObject('Login/Page_Member/link-Username'), userName)

//Close browser
WebUI.closeBrowser()

