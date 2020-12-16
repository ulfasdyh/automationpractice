package PageObject;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {
	protected WebDriver driver;
	JavascriptExecutor executor;
	protected WebDriverWait wait;
	Action action;
	
	//MENU
	private By CONTACTUS = By.id("contact-link");
	
	public HomePage (WebDriver driver) {
		this.driver = driver;
		this.executor = (JavascriptExecutor)driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		this.action = new Action(driver);
	}
	
	public void GoToContactUsPage() throws InterruptedException {
		Thread.sleep(10000);
		action.PressButton(CONTACTUS);
	}
}
