# Selenium--Utils-HelperMethods
I have created some utils classes which has generic/common  methods which can be used in the framework.


**Excel Utils**
* Excel utils contains generic excel utils method using ApachePOI to getData, SetData, GetDataFromSheet,GetRowCount etc

**MailTriggerAPI**
* Using Mail trigger API you can email the report to your project team after every build. If you are not using jenkins to send report, this API would be better alternative which fetches the latest file from the report Directory. 
* Call this method in the @AfterSuite to send the email to the team

**Faker Data**
* Java Faker is a library that can be used to generate a wide array of real-looking data from addresses to phone numbers , till gameOfThrones reference.
* Here there are few methods like generating address based upon region, Phonenumbers, Random ID's, And few more

**ElementUtils**
* Element utils contains all the commonMethods related to pageObjectHandling which we would use in our Framework to reduce the redundancy

**OptionsManager**
* OptionManager is for configuring the Chrome and firefoxOptions options to pass it as argument during driver initialisation

**DynamicXpath**
* Dynamic Xpath is used to replace any text just by passing xpath as an argument and the replaceable text to choose any element dynamically

**HelperMethods**
* HelperMethods are similar to elementUtils but contains all the commonMethods related to your whole framework like Switching Windows, Selecting a randomFile to upload, TakeScreenShotMethod,Page scroll Related methods etc

**ReadProperty**
* ReadProperty for Reading data from propertiesFile using a commonClass which can be used Anywhere in the framework.
