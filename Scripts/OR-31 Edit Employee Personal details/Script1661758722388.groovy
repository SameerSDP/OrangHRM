import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys

WebUI.callTestCase(findTestCase('OR-26 Add new employee'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('Page_OrangeHRM/select_Nationality'))

CustomKeywords.'keyword.custom.select_dropdown'(GlobalVariable.nationality)

WebUI.click(findTestObject('Page_OrangeHRM/select_marital_status'))

CustomKeywords.'keyword.custom.select_dropdown'(GlobalVariable.marital_status)

WebUI.setText(findTestObject('Page_OrangeHRM/input_nick_name'), GlobalVariable.nick_name)

WebUI.click(findTestObject('Page_OrangeHRM/button_Save'))

WebUI.verifyElementText(findTestObject('Page_OrangeHRM/verify_dropdown_nationality'), GlobalVariable.nationality)

WebUI.verifyElementText(findTestObject('Page_OrangeHRM/verify_dropdown_marital_status'), GlobalVariable.marital_status)

