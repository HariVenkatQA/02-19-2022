package org.pojo;

import org.base.Basics;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PojoClassLogin extends Basics{
	
	public PojoClassLogin() {
		
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(id="email")
	private WebElement txtmail;
	
	@FindBy(id="pass")
	private WebElement txtpass;
	
	@FindBy(name="login")
	private WebElement loginbtn;

	public WebElement getTxtmail() {
		return txtmail;
	}

	public WebElement getTxtpass() {
		return txtpass;
	}

	public WebElement getLoginbtn() {
		return loginbtn;
	}
	
	
	
	
}
