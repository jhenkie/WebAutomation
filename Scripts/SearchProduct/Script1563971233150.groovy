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

//Create reusable method to perform search
void searchAction(String text) {
	//Fill in text in search text field (something with no result)
	CustomKeywords.'lelongweb.keyword.setText'(findTestObject('SearchProduct/Page_Index/input_searchText'), text)
	
	//Click on search button
	WebUI.click(findTestObject('SearchProduct/Page_Index/span_searchButton'))
}

//Open browser
WebUI.openBrowser('')

//Navigate to URL
WebUI.navigateToUrl(GlobalVariable.Site_URL)

//Verify the url is correct
WebUI.verifyMatch(WebUI.getUrl(), GlobalVariable.Site_URL, false)

//Call search method to perform no result scenario
searchAction(searchInvalid)

//Verify no result found text
WebUI.verifyElementText(findTestObject('SearchProduct/Page_Result/span_noResult'), searchNotFound)

//Call search method to perform available result scenario
searchAction(searchValid)

//count item of search results and store in variable
def countResult = CustomKeywords.'lelongweb.keyword.countElement'(GlobalVariable.searchResultList)

//verify item is greater than certain number
WebUI.verifyGreaterThan(countResult, 6)

//verify item's title contains search text
WebUI.getText(findTestObject('SearchProduct/Page_Result/span_resultInItems')).contains(searchValid)

//Close browser
WebUI.closeBrowser()

