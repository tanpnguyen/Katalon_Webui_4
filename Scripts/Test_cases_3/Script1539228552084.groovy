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
import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable
import com.kms.katalon.core.logging.KeywordLogger as KeywordLogger
import org.openqa.selenium.Keys as Keys
import org.openqa.selenium.WebElement as WebElement
import org.testng.Assert as Assert
import org.openqa.selenium.WebDriver as WebDriver
import org.openqa.selenium.By as By

WebUI.openBrowser('http://demo.prestashop.com/en/?view=front')

WebUI.maximizeWindow()

WebUI.switchToFrame(findTestObject('Object Repository/Page_PrestaShop Demo/iframe_Show_framelive'), 60)

WebUI.setText(findTestObject('Page_PrestaShop Demo/txt_search'), 'Mug')

WebUI.click(findTestObject('Page_PrestaShop Demo/btn_search'))

//WebUI.delay(5)
WebUI.waitForElementVisible(findTestObject('Object Repository/Page_PrestaShop Demo/label_product'),5)

KeywordLogger log = new KeywordLogger()

WebDriver driver = DriverFactory.getWebDriver()

List<WebElement> mug_title = driver.findElements(By.xpath('//h2[@class=\'h3 product-title\']/a'))

Assert.assertTrue(mug_title.size() > 0)

if (mug_title.size() != 0) {
	for (int i = 0; i <= (mug_title.size() - 1); i++) {
		Assert.assertTrue(mug_title[i].getText().contains('Mug'))
	}
}
WebUI.closeBrowser()