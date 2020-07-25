package Utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ElementUtils {

    WebDriver driver;

    public ElementUtils(WebDriver driver){
        this.driver = driver;
    }

    //getting element
    public WebElement getElement(By locator){
        WebElement element = null;
        try{
            System.out.println("Locator is " + locator);
            element = driver.findElement(locator);
        } catch (Exception e){
            System.out.println("Some exception occured when getting the element");
        }
        return element;
    }

    public void doSendKeys(By locator,String dataToEnter){
        waitForElementPresence(locator,10);
        getElement(locator).sendKeys(dataToEnter);
    }

    //Click element
    public void doClick(By locator){
        waitForElementPresence(locator,10);
        getElement(locator).click();
    }

    //get text
    public String doGetText(By locator) {
        waitForElementPresence(locator, 10);
        return getElement(locator).getText();
    }

    //check element is displayed
    public boolean doIsDisplayed(By locator) {
        waitForElementPresence(locator, 10);
        return getElement(locator).isDisplayed();
    }

    //getting title
    public String waitForTitleToBePresent(String title, int timeOut){
        WebDriverWait wait = new WebDriverWait(driver,timeOut);
        wait.until(ExpectedConditions.titleContains(title));
        return driver.getTitle();
    }

    //staticWait
    public void staticWait(int timeOut) throws InterruptedException {
        Thread.sleep(timeOut);
    }


    //wait till element is clickable
    public void waitForElementClickable(By locator,int timeOut) {
        try{
        WebDriverWait wait =  new WebDriverWait(driver,timeOut);
        wait.until(ExpectedConditions.elementToBeClickable(locator));
        } catch (Exception e) {
            System.out.println("Some error/exception while waiting for element to click -> " + locator.toString());
            e.printStackTrace();
        }
    }

    public void waitForElementPresence(By locator,int timeOut) {
        try {
            WebDriverWait wait = new WebDriverWait(driver,timeOut);
            wait.until(ExpectedConditions.presenceOfElementLocated(locator));
        } catch (Exception e) {
            System.out.println("Some error/exception while waiting for locator -> " + locator.toString());
            e.printStackTrace();
        }
    }

    //wait till element is visible
    public void waitForElementVisibility(By locator) {
        try {
            WebDriverWait wait =  new WebDriverWait(driver,15);
            wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        } catch (Exception e) {
            System.out.println("Some error/exception while waiting for element Visibility -> " + locator.toString());
            e.printStackTrace();
        }
    }


}
