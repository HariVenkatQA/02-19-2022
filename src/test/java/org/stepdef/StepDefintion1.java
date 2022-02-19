package org.stepdef;

import java.util.List;

import org.base.Basics;
import org.openqa.selenium.WebElement;
import org.pojo.PojoClassLogin;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDefintion1 extends Basics{
	
	PojoClassLogin z;
	
	@When("Customer Enters the username")
	public void customerEntersTheUsername(io.cucumber.datatable.DataTable d) {
		
		z = new PojoClassLogin();
		
		WebElement txtmail = z.getTxtmail();
		
		List<String> li = d.asList();
		
		String data = li.get(2);
		
		fillText(txtmail, data);
		
		
	}

	@Then("Customer Enters the password")
	public void customerEntersThePassword() {
		
		WebElement txtpass = z.getTxtpass();
		
		fillText(txtpass, "123");

	}

	@Then("Customer clicks the login button")
	public void customerClicksTheLoginButton() {
		
		WebElement loginbtn = z.getLoginbtn();
		
		click(loginbtn);
		
	}

	@Then("Exits the from the Application")
	public void exitsTheFromTheApplication() {

		System.out.println("Done");
		
	}
	

}
