package KeywordBase;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Base {
	
	public WebDriver driver;
	public Properties prop;
	
	public WebDriver init_driver(String BrowserName) {
		if (BrowserName.equals("chrome")) {
			
		System.setProperty("webdriver.chrome.driver", "D:\\ChromeDriver\\chromedriver.exe");
		 if (prop.getProperty("headless").equals("Yes")){
			 ChromeOptions options = new ChromeOptions();
			 options.addArguments("--headless");
			 driver = new ChromeDriver(options);
			
		}else {
			driver = new ChromeDriver();
		}
			
		}
		
		return driver;
	}
	
	public Properties init_properties() {
		prop = new Properties();
		
		try {
			FileInputStream ip = new FileInputStream("C:\\Users\\dell\\eclipse-workspace\\SeleniumSessionsClasses\\src\\main\\java\\KeywordDriven\\config.properties");
			try {
				prop.load(ip);
			} catch (IOException e) {
				
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		}
		
		return prop;
		
		
	}
	

}
