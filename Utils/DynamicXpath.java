package Utils;

import org.openqa.selenium.By;

public class DynamicXpath {

	
	
	public static By get(String xpath, String data) {
		
		String rawXapth = xpath.replaceAll("%replaceable%", data);
		return By.xpath(rawXapth);
	}
}
