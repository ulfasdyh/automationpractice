package PageObject;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Action {
	protected WebDriver driver;
	JavascriptExecutor executor;
	protected WebDriverWait wait;
	
	public Action (WebDriver driver) {
		this.driver = driver;
		this.executor = (JavascriptExecutor)driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));
	}
	
	public void EnterText(By textbox, String input) {
		WebElement element = driver.findElement(textbox);
		element.clear();
		element.sendKeys(input);
	}
	
	public void SetText(By textbox, String input) {
		WebElement element = driver.findElement(textbox);
		element.sendKeys(input);
	}
	
	public void SelectOption(By combobox, String option) {
		WebElement element = driver.findElement(combobox);
		Select select = new Select( element );
		select.selectByVisibleText(option);
	}
	
	public String GetSelectedOption(By combobox) {
		String selectedOption = new Select(driver.findElement(combobox)).getFirstSelectedOption().getText();
		return selectedOption;
	}
	
	public String GetText(By element) {
		return driver.findElement(element).getText();
	}
	
	public void PressButton(By button) {
		wait.until(ExpectedConditions.elementToBeClickable(button)).click();
	}

}
