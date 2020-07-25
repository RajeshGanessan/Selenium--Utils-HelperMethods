package Utils;

import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.util.Properties;

public class optionsManager {

    public ChromeOptions chromeoptions;
    public FirefoxOptions firefoxOptions;
    public Properties prop;


    public optionsManager(Properties prop){
        this.prop = prop;
    }
    //To get chromeOptions
    public ChromeOptions getChromeOptions(){

        chromeoptions =  new ChromeOptions();
        if(Boolean.parseBoolean(prop.getProperty("headless"))) chromeoptions.addArguments("--headless");
        if(Boolean.parseBoolean(prop.getProperty("incognito"))) chromeoptions.addArguments("incognito");
        return chromeoptions;
    }

    //To get FireFox options
    public FirefoxOptions getFirefoxOptions(){
        firefoxOptions = new FirefoxOptions();
        if(Boolean.parseBoolean(prop.getProperty("headless"))) firefoxOptions.addArguments("--headless");
        return firefoxOptions;
    }

}
