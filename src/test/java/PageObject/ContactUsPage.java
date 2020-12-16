package PageObject;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ContactUsPage {
	protected WebDriver driver;
	JavascriptExecutor executor;
	protected WebDriverWait wait;
	Action action;
	
	//Form
	private By SUBJECT = By.id("id_contact");
	private By SUBJECTINFO = By.id("desc_contact2");
	private By EMAIL = By.id("email");
	private By ORDERREFERENCE = By.id("id_order");
	private By FILEUPLOAD = By.id("fileUpload");
	private By MESSAGE = By.id("message");
	private By SEND = By.id("submitMessage");
	private By ALERTMESSAGE = By.cssSelector("#center_column > p");
	
	public ContactUsPage (WebDriver driver) {
		this.driver = driver;
		this.executor = (JavascriptExecutor)driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		this.action = new Action(driver);
	}
	
	public void SelectSubjectHeading(String subject) {
		action.SelectOption(SUBJECT, subject);
	}
	
	public String GetSubjectHeadingInfo() {
		return action.GetText(SUBJECTINFO);
	}
	
	public void EnterEmailAddress(String email) {
		action.EnterText(EMAIL, email);
	}
	
	public void EnterOrderReference(String orderref) {
		action.EnterText(ORDERREFERENCE, orderref);
	}
	
	public void AttachFile(String filename) {
		action.SetText(FILEUPLOAD, filename);
	}
	
	public void EnterMessage(String message) {
		action.EnterText(MESSAGE, message);
	}
	
	public void SendMessage() {
		action.PressButton(SEND);
	}
	
	public String GetAlertMessage() {
		return action.GetText(ALERTMESSAGE);
	}

	public String GetSelectedSUbject() {
		return action.GetSelectedOption(SUBJECT);	
	}
}
