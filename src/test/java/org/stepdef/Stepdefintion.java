package org.stepdef;

import java.io.IOException;

import org.base.Basics;
import org.openqa.selenium.WebElement;
import org.pojo.PojoClassLogin;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Stepdefintion extends Basics {
	
	PojoClassLogin p;

	@Given("open the browser and hit the url")
	public void openTheBrowserAndHitTheUrl() {
		
		browserLaunch();
		windowsMax();
		urlLaunch("https://www.facebook.com/");
	

	}

	@When("user enter the {string}")
	public void userEnterThe(String username) {
		
		p = new PojoClassLogin();
				
				WebElement txtmail = p.getTxtmail();
				
				fillText(txtmail, username);
		

	}

	@Then("user enters the {string}")
	public void userEntersThe(String password) {
		
		WebElement txtpass = p.getTxtpass();
		
		fillText(txtpass, password);

	}

	@Then("user clicks the login button")
	public void userClicksTheLoginButton() {
		
		WebElement loginbtn = p.getLoginbtn();
		
		click(loginbtn);

	}

	@Then("User close the browser")
	public void userCloseTheBrowser() {
		
		System.out.println("Done");

	
	}	
}
