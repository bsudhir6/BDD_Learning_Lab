package stepdefs;


import static org.junit.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class BrowsingAround {

	String petClinicURL="http://localhost:8080/petclinic";
	
	 WebDriver driver = null; 
		
	  
	 @Given("I have opened the browser")
	 public void i_have_opened_the_browser() {		 					
		 System.setProperty("webdriver.chrome.driver", "C://Users//Administrator//SeleniumWebDrivers//chromedriver.exe");
		   driver= new ChromeDriver();		   
		   driver.manage().window().maximize();
	 }

	 @And("I am on the home page")
	 public void i_am_on_the_home_page() {

	      driver.navigate().to(petClinicURL); 
	 }
	 
	 @When("I open veterinarians page")
	 public void i_open_veterinarians_page() {
		 driver.get(petClinicURL + "/vets.html");
			assertTrue(driver.getCurrentUrl().equals(petClinicURL + "/vets.html"));
	 }
	 
	 @Then("I search for text {string}")
	 public void i_search_for_text(String elementName) {
		 
		 assertTrue(driver.findElement(By.xpath("/html/body/div/h2")).getText().equalsIgnoreCase(elementName));
	 }
	 
	 @When("I search owner {string}")
	 public void i_search_owner(String ownerName) {
		 driver.get(petClinicURL + "/owners/find.html");
			assertTrue(driver.getCurrentUrl().equals(petClinicURL + "/owners/find.html"));
			WebElement search = driver.findElement(By.xpath("//*[@name='lastName']"));
			System.out.println("Element is :" + search.getText());
			search.sendKeys(ownerName);
			driver.findElement(By.xpath("//*[@id=\"search-owner-form\"]/fieldset/div[2]/button")).click();				
	 }
	 
	 @Then("I get owner {string} Informations")
	 public void i_get_owner_informations(String arg1) {
		 
		 String ownersName = driver.findElement(By.xpath("/html/body/div/table[1]/tbody/tr[1]/td/b")).getText();
			System.out.println("Owners name is: " + ownersName);
			assertTrue(ownersName.contains(arg1));
	 }
	 
	 @After
	 public void closeBrowser() {
		 driver.close();
	 }	 
	 
	 	
}