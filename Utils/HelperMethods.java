package Utils;

import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.util.Date;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.ExecutionException;

import Base.Base;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.*;
import org.openqa.selenium.OutputType;
import Base.BaseTest;
import Base.basePage;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

public class HelperMethods  {

	 WebDriver driver;

	public HelperMethods(WebDriver driver)  {
		this.driver = driver;
	}

	static String currentWindow = "";

	public String takeScreenshot() throws IOException {
		Date date = new Date();
		long currentTime = date.getTime();
		File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String path = System.getProperty("user.dir") + "/resources/FailureScreenshots/Scshot" + currentTime
				+ ".png";
		System.out.println("captured Screenshot and exporting to path " + path);
		FileUtils.copyFile(screenshot, new File(path));
		return path;
	}

	public void ScrollDownComplete() throws InterruptedException {
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
//		js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
		js.executeScript("scroll(0, 700);");
		Thread.sleep(3000);
	}

	//Scrolling to the Top of the page
	public void ScrollUp() throws InterruptedException {
		JavascriptExecutor js = ((JavascriptExecutor)driver);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		js.executeScript("scroll(0,-250);");
		Thread.sleep(2000);
	}

	// Scrolls till the bottom of page
	public  void ScrolltoBottomOfPage() {
		try {
			long Height = Long.parseLong(
					((JavascriptExecutor) driver).executeScript("return document.body.scrollHeight").toString());

			while (true) {
				((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight);");
				Thread.sleep(500);

				long newHeight = Long.parseLong(
						((JavascriptExecutor) driver).executeScript("return document.body.scrollHeight").toString());
				if (newHeight == Height) {
					break;
				}
				Height = newHeight;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public  void scrollIntoView(WebElement element) {
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		BaseTest.test.get().info("Scrolling to the element " + element.toString());
		js.executeScript("arguments[0].scrollIntoView(true);", element);
	}

	// getting currentURL
	public  String getCurrentURL() {
		return driver.getCurrentUrl();
	}

	// get random Number
	public int getRandomNumber() {
		Random rand = new Random();
		return rand.nextInt(10000);
	}

	// get random Number with Value
	public  String getRandomNumberValue(int value) {
		Random rand = new Random();
		int randomNum = rand.nextInt(value);
		return Integer.toString(randomNum);
	}

	// Getting modded file
	public  String lastFileModified(String dir) {
		File fl = new File(dir);
		File[] files = fl.listFiles(new FileFilter() {
			public boolean accept(File file) {
				return file.isFile();
			}
		});
		long lastMod = Long.MIN_VALUE;
		File choice = null;
		for (File file : files) {
			if (file.lastModified() > lastMod) {
				choice = file;
				lastMod = file.lastModified();
			}
		}
		return choice.getAbsoluteFile().toString();
	}

	// Get randomFile from directory
	public  String getRandomFile() {

		String testDocsPath = System.getProperty("user.dir") + "/resources/TestDocs";
		File Directory = new File(testDocsPath);

		if (Directory.exists()) {

			String[] files = Directory.list();
			Random randomGenerator = new Random();

			if (files == null) {
				throw new AssertionError();
			}
			int randomFile = randomGenerator.nextInt(files.length);
			return testDocsPath + "/" + files[randomFile];
		} else {
			System.out.println("TestDocs Directory not found");
			return null;
		}
	}

	// for dynamic dropdown;
	public  void getDynamicValue(String searchTerm, WebElement Fieldelement, String valueXpath) {
		try {
			Fieldelement.sendKeys(searchTerm);
//			test.get().info("Entered the searchTerm" + searchTerm + "in the field");
			driver.findElement((DynamicXpath.get(valueXpath, searchTerm))).click();
//			test.get().info("Selected the option " + searchTerm + " from the list");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("failed to select the option, check the element");
		}
	}

	//for dynamic Drop - Select using Option Index;
	public  void SelectDynamicValue(String optionToSelect, String valueXpath) {
		try {
//			test.get().info("Clicked on the fieldElement");
			driver.findElement((DynamicXpath.get(valueXpath, optionToSelect))).click();
//			test.get().info("Selected the option from the list");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("failed To select the otion, Check the element");
		}
	}

	// Switching to Next Window
	public  boolean switchToChildWindow() {

		boolean flag = false;

		currentWindow = driver.getWindowHandle();
		try {

			Set<String> allWindows = driver.getWindowHandles();

			for (String actual : allWindows) {

				if (!actual.equalsIgnoreCase(currentWindow)) {

					driver.switchTo().window(actual);
//					test.get().info("Switched to the SignEasy Window");
					flag = true;
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
//			test.get().info("Something went wrong when switching to SignEasy window");
		}
		return flag;
	}

	// Switching back to parent Window
	public  void switchToParentWindow() {
		try {
			driver.switchTo().window(currentWindow);
//			test.get().info("Switched to the Parent window sucessFully");
		} catch (Exception e) {
			e.printStackTrace();

		}
	}

}
