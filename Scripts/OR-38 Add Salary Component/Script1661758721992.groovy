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

WebUI.click(findTestObject('Page_OrangeHRM/employee_card_1'))

WebUI.waitForElementPresent(findTestObject('Page_OrangeHRM/pim_salary'), GlobalVariable.setTimeout)

WebUI.click(findTestObject('Page_OrangeHRM/pim_salary'))

WebUI.click(findTestObject('Page_OrangeHRM/button_add_Assigned Salary Components'))

CustomKeywords.'keyword.custom.setText'('Salary Component', GlobalVariable.salary_component)

CustomKeywords.'keyword.custom.dropdown'('Pay Grade', GlobalVariable.pay_grade)

CustomKeywords.'keyword.custom.dropdown'('Pay Frequency', GlobalVariable.pay_freaquency)

CustomKeywords.'keyword.custom.dropdown'('Currency', GlobalVariable.currency)

CustomKeywords.'keyword.custom.setText'('Amount', GlobalVariable.amount)

WebUI.click(findTestObject('Page_OrangeHRM/button_Save'))

WebUI.verifyElementPresent(findTestObject('Page_OrangeHRM/verify_salary_component'), GlobalVariable.setTimeout)

WebUI.closeBrowser()

