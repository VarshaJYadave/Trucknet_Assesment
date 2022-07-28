package src.com.assesment;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/*
 * 
 */
public class Util {
	public static WebDriver driver;

	public Util() {

		// change the file path of driver accordingly
		System.setProperty("webdriver.chrome.driver",
				"E:\\Eclipse_SeleniumWorkSpace\\Trucknet_Assesment\\Trucknet_Assesment\\Drivers\\chromedriver.exe");
		driver = new ChromeDriver();
	}

	public void setupBrowser(String Url) {
		driver.get(Url);
	}
	
     //This logic can be used if we want to test in different browsers
	public void setupBrowser(String browser, String url) {
		String currDir = System.getProperty("user.dir");
		String fs = System.getProperty("file.separator");
		String driverPath = currDir + fs + "drivers" + fs;

		// browser opening
		if (browser.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", driverPath + "chromedriver.exe");
			driver = new ChromeDriver();
		} else if (browser.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", driverPath + "geckodriver.exe");
			driver = new FirefoxDriver();
		} else if (browser.equalsIgnoreCase("edge")) {
			System.setProperty("webdriver.edge.driver", driverPath + "msedgedriver.exe");
			driver = new EdgeDriver();
		} else {
			System.out.println("Valid browser was not provided, hence quitting the automation run");
			System.exit(0);
		}

		// url management
		if (url != "")
			driver.get(url);
		else
			driver.get("about:blank");
	}
}
