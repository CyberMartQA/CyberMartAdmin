package com.cybermart.pages;

import java.time.Duration;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.cybermart.tests.BaseClass;

public class LoginPage extends BaseClass {

	public LoginPage() {

		elementsInitializer();

	}


//	PAGE ELEMENTS

	@FindBy(css = ".MuiTypography-root.MuiTypography-body2.muiltr-1dzy9q8")
	WebElement forgetLink;

	@FindBy(name = "email")
	WebElement inputFieldEmail;

	@FindBy(name = "password")
	WebElement inputFieldPassword;

	@FindBy(id = "mui-4")
	WebElement buttonLogin;









	@FindBy(id = "loginForm-emailinput-label")
	WebElement labelInputFieldEmail;

	@FindBy(id = "loginForm-passwordInput-label")
	WebElement labelInputFieldPassword;

	@FindBy(xpath = "//*[@id=\"login\"]/div/div[1]/div/h3")
	WebElement labelLogin;

	@FindBy(id = "loginForm-emailinput-helper-text")
	WebElement errorEmail;

	@FindBy(id = "loginForm-passwordInput-helper-text")
	WebElement errorPassword;

	@FindBy(id = "loginForm-serverError")
	WebElement errorEmailOrPassword;

	@FindBy(id = "togglePassword")
	WebElement buttonTogglePassword;

	@FindBy(id = "loginForm-forgotPassword")
	WebElement linkForgot;

	@FindBy(id = "loginForm-registerLink")
	WebElement linkRegister;

	@FindBy(id = "loginForm-googleBtn")
	WebElement buttonLoginWithGoogle;

	@FindBy(id = "loginForm-facebookBtn")
	WebElement buttonLoginWithFacebook;

	@FindBy(id = "identifierId")
	WebElement inputFieldGoogleEmail;

	@FindBy(id = "identifierNext")
	WebElement buttonNextGoogleEmail;

	@FindBy(name = "password")
	WebElement inputFieldGooglePassword;

	@FindBy(id = "passwordNext")
	WebElement buttonNextGooglePassword;

	@FindBy(id = "email")
	WebElement inputFieldFacebookEmail;

	@FindBy(id = "pass")
	WebElement inputFieldFacebookPassword;

	@FindBy(id = "loginbutton")
	WebElement buttonFacebookLogin;


//	PAGE ELEMENTS

	public void clickForgotLink() {

		forgetLink.click();

	}

	public void loginUserSuccessfull() {

		setEmail("airas.mangotech@gmail.com");
		setPassword("123456");
		clickLoginButton();

	}











	public void clickEmailField() {

		inputFieldEmail.click();

	}

	public void clickPasswordField() {

		inputFieldPassword.click();

	}

	public void clickLoginButton() {

		buttonLogin.click();

	}

	public void clickTogglePasswordButton() {

		buttonTogglePassword.click();

	}

	public void clickRegisterLink() {

		linkRegister.click();

	}

	public void setEmail(String email) {

		this.clearFieldData(inputFieldEmail);
		inputFieldEmail.sendKeys(email);

	}

	public void setPassword(String password) {

		clearFieldData(inputFieldPassword);
		inputFieldPassword.sendKeys(password);

	}

	public WebElement getInputFieldEmail() {

		return inputFieldEmail;

	}

	public WebElement getInputFieldPassword() {

		return inputFieldPassword;

	}

	public void submitPassword() {

		inputFieldPassword.submit();

	}

	public String getEmailFieldLabel() {

		return inputFieldEmail.getText();

	}

	public String getPasswordFieldLabel() {

		return inputFieldPassword.getText();

	}

	public String getEmailFieldPlaceholder() {

		return inputFieldEmail.getAttribute("placeholder");

	}

	public String getPasswordFieldPlaceholder() {

		return inputFieldPassword.getAttribute("placeholder");

	}

	public boolean isLoginLabelVisible() {

		try {
			labelLogin.isDisplayed();
			return true;
		} catch (NoSuchElementException e) {
			e.printStackTrace();
			return false;
		}

	}

	public boolean isEmailFieldVisible() {

		try {
			inputFieldEmail.isDisplayed();
			return true;
		} catch (NoSuchElementException e) {
			e.printStackTrace();
			return false;
		}

	}

	public boolean isPasswordFieldVisible() {

		try {
			inputFieldPassword.isDisplayed();
			return true;
		} catch (NoSuchElementException e) {
			e.printStackTrace();
			return false;
		}

	}

	public boolean isRegisterLinkVisible() {

		try {
			linkRegister.isDisplayed();
			return true;
		} catch (NoSuchElementException e) {
			e.printStackTrace();
			return false;
		}

	}

	public boolean isLoginButtonVisible() {

		try {
			buttonLogin.isDisplayed();
			return true;
		} catch (NoSuchElementException e) {
			e.printStackTrace();
			return false;
		}

	}

	public boolean isGoogleButtonVisible() {

		try {
			buttonLoginWithGoogle.isDisplayed();
			return true;
		} catch (NoSuchElementException e) {
			e.printStackTrace();
			return false;
		}

	}

	public boolean isFacebookButtonVisible() {

		try {
			buttonLoginWithFacebook.isDisplayed();
			return true;
		} catch (NoSuchElementException e) {
			e.printStackTrace();
			return false;
		}

	}

	public boolean isTogglePasswordButtonVisible() {

		try {
			buttonTogglePassword.isDisplayed();
			return true;
		} catch (NoSuchElementException e) {
			e.printStackTrace();
			return false;
		}

	}

	public boolean isForgotPasswordLinkVisible() {

		try {
			linkForgot.isDisplayed();
			return true;
		} catch (NoSuchElementException e) {
			e.printStackTrace();
			return false;
		}

	}

	public String getEmailError() {

		return errorEmail.getAttribute("innerHTML");

	}

	public String getPasswordError() {

		return errorPassword.getAttribute("innerHTML");

	}

	public String getInvalidEmailOrPasswordError() {

		myWait(Duration.ofSeconds(5)).until(ExpectedConditions.visibilityOf(errorEmailOrPassword));
		return errorEmailOrPassword.getAttribute("innerHTML");

	}

	public String getPasswordVisibilityStatus() {

		return inputFieldPassword.getAttribute("type");

	}

	public void clickGoogleLoginButton() {

		buttonLoginWithGoogle.click();

	}

	public void setGoogleEmail(String email) {

		inputFieldGoogleEmail.sendKeys(email);

	}

	public void clickNextGoogleEmail() {

		buttonNextGoogleEmail.click();

	}

	public void setGooglePassword(String password) {

		inputFieldGooglePassword.sendKeys(password);

	}

	public void clickNextGooglePassword() {

		buttonNextGooglePassword.click();

	}

	public void clickFacebookLoginButton() {

		buttonLoginWithFacebook.click();

	}

	public void setFacebookEmail(String email) {

		inputFieldFacebookEmail.sendKeys(email);

	}

	public void setFacebookPassword(String password) {

		inputFieldFacebookPassword.sendKeys(password);

	}

	public void clickLoginFacebook() {

		buttonFacebookLogin.click();

	}

}