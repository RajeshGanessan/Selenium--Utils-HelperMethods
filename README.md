# Selenium--Utils-HelperMethods
I have created some utils classes which has generic/common  methods which can be used in the framework.


**Excel Utils**
* Excel utils contains generic excel utils method using ApachePOI to getData, SetData, GetDataFromSheet,GetRowCount etc

**MailTriggerAPI**
* Using Mail trigger API you can email the report to your project team after every build. If you are not using jenkins to send report, this API would be better alternative which fetches the latest file from the report Directory. 
* Call this method in the @AfterSuite to send the email to the team
