package internal

import com.kms.katalon.core.configuration.RunConfiguration
import com.kms.katalon.core.main.TestCaseMain


/**
 * This class is generated automatically by Katalon Studio and should not be modified or deleted.
 */
public class GlobalVariable {
     
    /**
     * <p>Profile default : website url</p>
     */
    public static Object Site_URL
     
    /**
     * <p>Profile default : search result in list</p>
     */
    public static Object searchResultList
     
    /**
     * <p>Profile default : search product</p>
     */
    public static Object searchTextFound
     

    static {
        try {
            def selectedVariables = TestCaseMain.getGlobalVariables("default")
			selectedVariables += TestCaseMain.getGlobalVariables(RunConfiguration.getExecutionProfile())
            selectedVariables += RunConfiguration.getOverridingParameters()
    
            Site_URL = selectedVariables['Site_URL']
            searchResultList = selectedVariables['searchResultList']
            searchTextFound = selectedVariables['searchTextFound']
            
        } catch (Exception e) {
            TestCaseMain.logGlobalVariableError(e)
        }
    }
}
