package com.cybermart.tests;

import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.cybermart.pages.ForgotPasswordPage;
import com.cybermart.pages.HeaderPage;
import com.cybermart.pages.LoginPage;

public class UserTypesTest extends BaseClass {

	ForgotPasswordPage forgotPasswordPage;
	LoginPage loginPage;
	HeaderPage headerPage;
	SoftAssert softAssert = new SoftAssert();

	public static final String expectedEmailRequiredError = "Please enter the email.";
	public static final String expectedMalformedEmailError = "Email is invalid.";
	public static final String expectedErrorAccountNotRegistered = "No user registered against this email";
	public static final String expectedEmailPlaceholder = "Email";
	public static final String forgotPasswordPageURL = "https://admin.cybermart.com/auth/forget-password";
	public static final String loginPageURL = "https://admin.cybermart.com/auth/login";
	public static final String forgotPasswordPageTitle = "Cyber Mart";
	public static String actualErrorAccountNotRegistered;


	@Test(priority = 1, enabled = true)
	public void verifyIsLoginSuccessfull() {

		loginPage = new LoginPage();
		forgotPasswordPage = new ForgotPasswordPage();

		loginPage.loginUserSuccessfull();

	}

	@Test(priority = 2, enabled = true)
	public void verifyUserTypesPageLoaded() {

		headerPage = new HeaderPage();

		headerPage.clickAtSystemTab();
		headerPage.clickAtUserTypesTab();

		Assert.assertTrue(jsPageLoadingStatus());

	}

	@Test(priority = 2, enabled = true)
	public void verifyForgotPasswordPageURL() {

		myWait(Duration.ofSeconds(5)).until(ExpectedConditions.urlToBe(forgotPasswordPageURL));

	}

	@Test(priority = 3, enabled = true)
	public void verifyForgotPasswordPageTitle() {

		myWait(Duration.ofSeconds(5)).until(ExpectedConditions.titleIs(forgotPasswordPageTitle));

	}

	@Test(priority = 4, enabled = true)
	public void verifyForgotPasswordPageHeadingDisplayed() {

		String pageHeading = forgotPasswordPage.getPageHeadingText();
		Assert.assertEquals(pageHeading, "Forget Password");

	}

	@Test(priority = 5, enabled = true)
	public void verifyEmailPlaceholder() {

		String actualEmailPlaceholder = forgotPasswordPage.getEmailPlaceholder();
		Assert.assertEquals(actualEmailPlaceholder, expectedEmailPlaceholder);

	}

	@Test(priority = 6, enabled = true)
	public void verifyCursorPosition() {

		WebElement activeElement = driver.switchTo().activeElement();

		Assert.assertTrue(forgotPasswordPage.getInputFieldEmail().equals(activeElement));

	}

	@Test(priority = 7, enabled = true)
	public void verifyEmailRequiredErrorMessage() {

		forgotPasswordPage.clickSendOTPButton();

		String actualEmailRequiredError = forgotPasswordPage.getEmailErrorText();
		Assert.assertEquals(actualEmailRequiredError, expectedEmailRequiredError);

	}

	@Test(priority = 8, enabled = true)
	public void verifyMalformedEmailErrorMessage(){

		forgotPasswordPage.enterListOfStaticInvalidEmails();

	}

	@Test(priority = 9, enabled = true)
	public void verifyUnRegisteredEmailErrorMessage(){

		for (int i = 0; i < 3; i++) {

			forgotPasswordPage.enterThreeRandomUnRegisteredEmails();

			actualErrorAccountNotRegistered = forgotPasswordPage.getUnregisteredEmailErrorMessage();
			Assert.assertEquals(actualErrorAccountNotRegistered, expectedErrorAccountNotRegistered);

			forgotPasswordPage.verifyUnregisteredEmailErrorMessageIsInvisible();

		}

	}

	@Test(priority = 10, enabled = true)
	public void verifyBackButtonFunctionality(){

		forgotPasswordPage.clickBackButton();

		myWait(Duration.ofSeconds(5)).until(ExpectedConditions.urlToBe(loginPageURL));

	}

	@Test(priority = 11, enabled = true)
	public void verifyForgetImageDisplayed(){

		Assert.assertTrue(forgotPasswordPage.getPageImage().isDisplayed(), "Image not displayed");

	}
}