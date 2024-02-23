import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
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
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys

TestData input = findTestData('Data Files/Application_Data')

WebUI.switchToDefaultContent()

number = WebUI.getText(findTestObject('Object Repository/NAP_ApplicationData/Select_appno'))

println(number)

GlobalVariable.application_number = number

WebUI.setText(findTestObject('Object Repository/NAP_ApplicationData/Input_appno'), number)

WebUI.setText(findTestObject('Object Repository/NAP_ApplicationData/Input_tenor'), input.getValue('tenor', 1))

WebUI.delay(2)

WebUI.click(findTestObject('Object Repository/NAP_ApplicationData/Select_paymentfreq'))

//WebUI.switchToFrame(findTestObject('NAP_ApplicationData/iframe_Term  Condition_appForm'), 0)

payreq = input.getValue('payment frequency', 1)

WebUI.click(findTestObject('Object Repository/NAP_ApplicationData/Button_' + payreq))

//WebUI.switchToDefaultContent()

WebUI.delay(2)

WebUI.click(findTestObject('Object Repository/NAP_ApplicationData/Select_interest'))

WebUI.switchToFrame(findTestObject('NAP_ApplicationData/iframe_Term  Condition_appForm'), 0)

interest = input.getValue('interest type', 1)

if (interest == 'Float Rate') {
    WebUI.click(findTestObject('Object Repository/NAP_ApplicationData/Button_floatrate'))

    WebUI.click(findTestObject('Object Repository/NAP_ApplicationData/Select_floatingperiod'))

    WebUI.click(findTestObject('Object Repository/NAP_ApplicationData/Button_floatingperiod'))
} else {
    WebUI.click(findTestObject('Object Repository/NAP_ApplicationData/Button_fixedrate'))
}

WebUI.switchToDefaultContent()

WebUI.delay(2)

WebUI.click(findTestObject('Object Repository/NAP_ApplicationData/Select_instscheme'))

//WebUI.switchToFrame(findTestObject('NAP_ApplicationData/iframe_Term  Condition_appForm'), 0)

instscheme = input.getValue('installment scheme', 1)

WebUI.click(findTestObject('Object Repository/NAP_ApplicationData/Button_' + instscheme))

//WebUI.switchToDefaultContent()

WebUI.delay(2)

WebUI.click(findTestObject('Object Repository/NAP_ApplicationData/Select_mktid'))

moid = input.getValue('marketing officer', 1)

WebUI.switchToFrame(findTestObject('NAP_ApplicationData/iframe_Term  Condition_appForm'), 0)

WebUI.click(findTestObject('Object Repository/NAP_ApplicationData/Button_' + moid))

WebUI.switchToDefaultContent()

WebUI.delay(2)

WebUI.click(findTestObject('Object Repository/NAP_ApplicationData/Select_soa'))

soa = input.getValue('application source', 1)

WebUI.switchToFrame(findTestObject('NAP_ApplicationData/iframe_Term  Condition_appForm'), 0)

WebUI.click(findTestObject('Object Repository/NAP_ApplicationData/Button_' + soa))

WebUI.switchToDefaultContent()

WebUI.delay(2)

WebUI.click(findTestObject('Object Repository/NAP_ApplicationData/Select_wop'))

WebUI.switchToFrame(findTestObject('NAP_ApplicationData/iframe_Term  Condition_appForm'), 0)

WebUI.click(findTestObject('Object Repository/NAP_ApplicationData/Button_wop'), input.getValue('way of payment', 1))

WebUI.switchToDefaultContent()

WebUI.delay(2)

WebUI.click(findTestObject('Object Repository/NAP_ApplicationData/Select_notif'))

WebUI.switchToFrame(findTestObject('NAP_ApplicationData/iframe_Term  Condition_appForm'), 0)

WebUI.click(findTestObject('Object Repository/NAP_ApplicationData/Button_notif'), input.getValue('customer notification', 1))

WebUI.switchToDefaultContent()

WebUI.delay(2)

WebUI.click(findTestObject('Object Repository/NAP_ApplicationData/Select_copyaddr'))

WebUI.switchToFrame(findTestObject('NAP_ApplicationData/iframe_Term  Condition_appForm'), 0)

WebUI.click(findTestObject('Object Repository/NAP_ApplicationData/Button_selectaddr'), input.getValue('copy address', 1))

WebUI.click(findTestObject('Object Repository/NAP_ApplicationData/Button_copyaddr'))

WebUI.switchToDefaultContent()

WebUI.delay(2)

WebUI.click(findTestObject('Object Repository/NAP_ApplicationData/Select_distance'))

WebUI.switchToFrame(findTestObject('NAP_ApplicationData/iframe_Term  Condition_appForm'), 0)

WebUI.click(findTestObject('Object Repository/NAP_ApplicationData/Button_distance'), input.getValue('address distance', 1))

WebUI.switchToDefaultContent()

Thread.sleep(2500)

WebUI.click(findTestObject('Object Repository/NAP_ApplicationData/Select_characteristic'))

WebUI.switchToFrame(findTestObject('NAP_ApplicationData/iframe_Term  Condition_appForm'), 0)

WebUI.click(findTestObject('Object Repository/NAP_ApplicationData/Button_distance'), input.getValue('characteristic credit', 1))

WebUI.switchToDefaultContent()

WebUI.delay(2)

WebUI.scrollToElement(findTestObject('Object Repository/NAP_ApplicationData/Button_savecontinue'), 3, FailureHandling.STOP_ON_FAILURE)

WebUI.delay(2)

WebUI.click(findTestObject('NAP_ApplicationData/Button_savecontinue'))

