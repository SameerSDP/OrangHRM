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

WebUI.openBrowser('')

CustomKeywords.'keyword.custom.login'(GlobalVariable.valid_usernme, GlobalVariable.valid_password)

WebUI.click(findTestObject('Object Repository/Page_OrangeHRM/button_Add'))

WebUI.setText(findTestObject('Object Repository/Page_OrangeHRM/input_Employee Full Name_firstName'), GlobalVariable.employee_fname)

WebUI.setText(findTestObject('Object Repository/Page_OrangeHRM/input_Employee Full Name_middleName'), GlobalVariable.employee_lname)

WebUI.setText(findTestObject('Object Repository/Page_OrangeHRM/input_Employee Full Name_lastName'), GlobalVariable.employee_mName)

CustomKeywords.'keyword.custom.setText'('Employee Id', GlobalVariable.employee_id)

WebUI.click(findTestObject('Object Repository/Page_OrangeHRM/button_Save'))

WebUI.waitForElementPresent(findTestObject('Page_OrangeHRM/Employee_Name'), GlobalVariable.setTimeout)

WebUI.verifyElementText(findTestObject('Page_OrangeHRM/Employee_Name'), GlobalVariable.employee_fname_lname)

