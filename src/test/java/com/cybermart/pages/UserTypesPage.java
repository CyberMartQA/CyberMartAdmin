package com.cybermart.pages;

import java.time.Duration;
import java.util.Locale;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.cybermart.tests.BaseClass;
import com.github.javafaker.Faker;

public class UserTypesPage extends BaseClass {

	Faker faker = new Faker(new Locale("en"));

	public UserTypesPage() {

		elementsInitializer();

	}


//	PAGE ELEMENTS

	@FindBy(css = ".MuiTypography-root.MuiTypography-h6.muiltr-4pzalf")
	WebElement pageHeading;

	@FindBy(xpath = "//span[normalize-space()='Email']")
	WebElement emailPlaceholder;

	@FindBy(id = "mui-9")
	WebElement btnSendOTP;

	@FindBy(css = ".MuiTypography-root.MuiTypography-body1.muiltr-99u0v6")
	WebElement errorEmail;

	@FindBy(name = "email")
	WebElement emailField;

	@FindBy(xpath = "//div[contains(text(),'No user registered against this email')]")
	WebElement errorEmailNotRegistered;

	@FindBy(id = "mui-7")
	WebElement backBtn;

	@FindBy(css = ".MuiGrid-root.MuiGrid-item.MuiGrid-grid-md-4.muiltr-9kaoqg")
	WebElement pageImage;


//	PAGE METHODS

	public String getPageHeadingText() {

		return pageHeading.getText();

	}

	public String getEmailPlaceholder() {

		return emailPlaceholder.getAttribute("innerHTML");

	}

	public void clickSendOTPButton() {

		btnSendOTP.click();

	}

	public String getEmailErrorText() {

		return errorEmail.getAttribute("innerHTML");

	}

	public void setEmail(String email) {

		clearFieldData(emailField);
		emailField.sendKeys(email);

	}

	public void enterListOfStaticInvalidEmails() {

		staticInvalidEmailGenerator(emailField, btnSendOTP, errorEmail, "Email is invalid.");

	}

	public String getUnregisteredEmailErrorMessage() {

		myWait(Duration.ofSeconds(5)).until(ExpectedConditions.visibilityOf(errorEmailNotRegistered));
		return errorEmailNotRegistered.getAttribute("innerHTML");

	}

	public Boolean verifyUnregisteredEmailErrorMessageIsInvisible() {

		return myWait(Duration.ofSeconds(5)).until(ExpectedConditions.invisibilityOf(errorEmailNotRegistered));

	}

	public void enterThreeRandomUnRegisteredEmails() {

		setEmail(faker.internet().emailAddress());
		clickSendOTPButton();

	}

	public WebElement getInputFieldEmail() {

		return emailField;

	}

	public void clickBackButton() {

		backBtn.click();

	}

	public WebElement getPageImage() {

		return pageImage;

	}

}