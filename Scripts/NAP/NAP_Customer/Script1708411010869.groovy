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

TestData input = findTestData('Data Files/Data_Customer')

for (int baris = 1; baris <= input.getRowNumbers(); baris++) {
    WebUI.switchToDefaultContent()

    if (input.getValue('type', baris) == 'personal') {
        WebUI.click(findTestObject('Object Repository/NAP_Customer/Input_' + input.getValue('type', baris)))

        WebUI.click(findTestObject('Object Repository/NAP_Customer/Search_custname'))

        WebUI.setText(findTestObject('Object Repository/NAP_Customer/Input_custname'), input.getValue('nama', baris))

        WebUI.click(findTestObject('Object Repository/NAP_Customer/Button_search'))

        WebUI.click(findTestObject('Object Repository/NAP_Customer/Button_select'))

        id = WebUI.getAttribute(findTestObject('Object Repository/NAP_Customer/Input_idno'), 'Value')

        println(id)

        //KeywordUtil.LogInfo(id)
        if (id == input.getValue('id', baris)) {
            println('benar')
        }
        
        npwp = WebUI.getAttribute(findTestObject('Object Repository/NAP_Customer/Input_npwp'), 'Value')

        println(npwp)

        //KeywordUtil.LogInfo(npwp)
        if (npwp == input.getValue('npwp', baris)) {
            println('benar' //step step
                )
        }
    } else if (input.getValue('type', baris) == 'company') {
        println('yes')
    }
}

WebUI.click(findTestObject('NAP_ApplicationData/Button_savecontinue'))

WebUI.delay(2)

WebUI.click(findTestObject('NAP_ApplicationData/Button_savecontinue'))

WebUI.delay(2)

WebUI.click(findTestObject('NAP_ApplicationData/Button_savecontinue'))

