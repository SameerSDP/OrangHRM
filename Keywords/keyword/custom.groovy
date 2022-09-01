package keyword
import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.checkpoint.CheckpointFactory
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testcase.TestCaseFactory
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testdata.TestDataFactory
import com.kms.katalon.core.testobject.ObjectRepository
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords

import internal.GlobalVariable

import org.openqa.selenium.WebElement
import org.openqa.selenium.WebDriver
import org.openqa.selenium.By
import org.openqa.selenium.JavascriptExecutor

import com.kms.katalon.core.mobile.keyword.internal.MobileDriverFactory
import com.kms.katalon.core.webui.driver.DriverFactory

import com.kms.katalon.core.testobject.RequestObject
import com.kms.katalon.core.testobject.ResponseObject
import com.kms.katalon.core.testobject.ConditionType
import com.kms.katalon.core.testobject.TestObjectProperty

import com.kms.katalon.core.mobile.helper.MobileElementCommonHelper
import com.kms.katalon.core.util.KeywordUtil

import com.kms.katalon.core.webui.exception.WebElementNotFoundException


class custom {
	/**
	 * Refresh browser
	 */
	@Keyword
	def select_dropdown(String element) {

		String xpath= "//*[(text() = '"+element+"')]"
		WebDriver driver = DriverFactory.getWebDriver()
		driver.findElement(By.xpath(xpath)).click()
	}

	//label[text()='Name']/../following-sibling::div/input

	@Keyword
	def setText(String element,String text) {

		String xpath= "//label[text()='"+element+"']/../following-sibling::div/input"
		WebDriver driver = DriverFactory.getWebDriver()
		driver.findElement(By.xpath(xpath)).sendKeys(text)
	}

	@Keyword
	def dropdown(String element,String option) {

		String click_xpath= "//label[text()='"+element+"']/parent::div/following-sibling::div//i"
		WebDriver driver = DriverFactory.getWebDriver()
		driver.findElement(By.xpath(click_xpath)).click()

		String xpath_option= "//*[(text() = '"+option+"')]"
		driver.findElement(By.xpath(xpath_option)).click()
	}

	//div[@class='oxd-table-body']//div[contains(text(),'')]

	@Keyword
	def verifyTablebodyName(String actualName) {
		String xpath = "//div[@class='oxd-table-body']//div[contains(text(),'"+actualName+"')]"
		WebDriver driver = DriverFactory.getWebDriver()
		try {
			driver.findElement(By.xpath(xpath))

		} catch (Exception e) {
			e.printStackTrace()
		}

	}

	//div[text()='Aaliyah ']/ancestor::div[@class='oxd-table-card']
	@Keyword
	def selectEmployeeName(String name) {

		String xpath = "//div[text()='"+name+"']/ancestor::div[@class='oxd-table-card']"
		WebDriver driver = DriverFactory.getWebDriver()
		driver.findElement(By.xpath(xpath)).click()

	}

	//div[text()='Aaliyah ']/ancestor::div[@class='oxd-table-card']//input[@type='checkbox']

	@Keyword
	def checkEmployeeName(String name) {

		String xpath = "//div[text()='"+name+"']/ancestor::div[@class='oxd-table-card']//label"
		WebDriver driver = DriverFactory.getWebDriver()
		driver.findElement(By.xpath(xpath)).click()

	}



	@Keyword
	def login(String username, String password) {

		WebDriver driver = DriverFactory.getWebDriver()
		driver.manage().window().maximize()
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login")
		driver.findElement(By.xpath("//input[@name='username']")).sendKeys(username)
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys(password)
		driver.findElement(By.xpath("//button[@type='submit']")).click()


	}

	//label[text()='Joined Date']/parent::div/following-sibling::div//input

	@Keyword
	def setDate(String element, String date) {
		String xpath= "//label[text()='"+element+"']/parent::div/following-sibling::div//input"
		WebDriver driver = DriverFactory.getWebDriver()
		driver.findElement(By.xpath(xpath)).sendKeys(date)
	}

	@Keyword
	def javascriptclick() {
		String xpath= "//button[@type='submit']"

		WebDriver driver = DriverFactory.getWebDriver()
		WebElement element = driver.findElement(By.xpath(xpath))
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", element)
	}

	@Keyword
	def refreshBrowser() {
		KeywordUtil.logInfo("Refreshing")
		WebDriver webDriver = DriverFactory.getWebDriver()
		webDriver.navigate().refresh()
		KeywordUtil.markPassed("Refresh successfully")
	}

	/**
	 * Click element
	 * @param to Katalon test object
	 */
	@Keyword
	def clickElement(TestObject to) {
		try {
			WebElement element = WebUiBuiltInKeywords.findWebElement(to);
			KeywordUtil.logInfo("Clicking element")
			element.click()
			KeywordUtil.markPassed("Element has been clicked")
		} catch (WebElementNotFoundException e) {
			KeywordUtil.markFailed("Element not found")
		} catch (Exception e) {
			KeywordUtil.markFailed("Fail to click on element")
		}
	}

	/**
	 * Get all rows of HTML table
	 * @param table Katalon test object represent for HTML table
	 * @param outerTagName outer tag name of TR tag, usually is TBODY
	 * @return All rows inside HTML table
	 */
	@Keyword
	def List<WebElement> getHtmlTableRows(TestObject table, String outerTagName) {
		WebElement mailList = WebUiBuiltInKeywords.findWebElement(table)
		List<WebElement> selectedRows = mailList.findElements(By.xpath("./" + outerTagName + "/tr"))
		return selectedRows
	}


}