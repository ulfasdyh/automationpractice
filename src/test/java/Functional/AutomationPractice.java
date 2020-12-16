package Functional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import PageObject.ContactUsPage;
import PageObject.HomePage;
import io.cucumber.java.*;
import io.cucumber.java.en.*;

public class AutomationPractice {
	WebDriver driver;
	ContactUsPage contactus;
	HomePage home;
	
	@Before
	public void SetProperty() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:/Users/Formulatrix/eclipse-workspace/Tiga/src/test/resources/drivers/chromedriver.exe");

		driver = new ChromeDriver();
		contactus = new ContactUsPage(driver);
		home = new HomePage(driver);
	}
	
	//@After
	public void CloseBrowser() {
		driver.close();
	}
	
	@Given("I navigated to automationpractice landing page")
	public void i_navigated_to_automationpractice_landing_page() {
		driver.navigate().to("http://automationpractice.com/index.php");
		driver.manage().window().maximize();
	}

	@Given("I go to contact us page")
	public void i_go_to_contact_us_page() throws InterruptedException {
	    home.GoToContactUsPage();
	    assertEquals("Contact us - My Store", driver.getTitle());
	    assertTrue(driver.getCurrentUrl().contains("contact"));
	}

	@When("I select {string} on subject heading")
	public void i_select_on_subject_heading(String subject) {
	    contactus.SelectSubjectHeading(subject);
	    assertEquals("For any question about a product, an order", contactus.GetSubjectHeadingInfo());
	}

	@When("I enter {string} on email field")
	public void i_enter_on_email_field(String email) {
	    contactus.EnterEmailAddress(email);
	}

	@When("I enter {string} on order reference field")
	public void i_enter_on_order_reference_field(String orderref) {
	    contactus.EnterOrderReference(orderref);
	}

	@When("I attach {string} file")
	public void i_attach_file(String filename) {
	    contactus.AttachFile(filename);
	}

	@When("I enter {string} on message field")
	public void i_enter_on_message_field(String message) {
	    contactus.EnterMessage(message);
	}

	@When("I send the message")
	public void i_send_the_message() {
	    contactus.SendMessage();
	}

	@Then("{string} message displayed")
	public void message_displayed(String result) {
	    assertEquals(result, contactus.GetAlertMessage());
	}
}
