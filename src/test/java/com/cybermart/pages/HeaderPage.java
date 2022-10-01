package com.cybermart.pages;

import java.util.List;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.ui.Select;

import com.cybermart.tests.BaseClass;

public class HeaderPage extends BaseClass {

	public HeaderPage() {

		elementsInitializer();

	}

	@FindBy(xpath = "//span[normalize-space()='Settings']")
	WebElement mainTabSettings;

	@FindBy(xpath = "//div[@class='MuiBox-root muiltr-1164y75']")
	WebElement subTabSystem;

	@FindBy(xpath = "//div[@class='MuiBox-root muiltr-1qjfp49']//div[3]")
	WebElement tabUserTypes;













	@FindBy(xpath = "//*[@id=\"topbar_main\"]/div/div[3]/div/span/a[1]")
	WebElement login;

	@FindBy(xpath = "//*[@id=\"topbar_main\"]/div/div[3]/div/span/a[2]")
	WebElement register;

	@FindBy(xpath = "//*[@id=\"topbar_main\"]/div/div[3]/div/div[2]")
	WebElement btnProfile;

	@FindBys(@FindBy(xpath = "//*[@id=\"popover-contained\"]/div[2]/span/a"))
	List<WebElement> profileDDMenu;

	@FindBy(xpath = "/html/body/div/div[1]/div[1]/div/div[1]/div/div/div[2]/div/div[3]/div/button")
	WebElement btnChangeLanguage;

	@FindBys(@FindBy(xpath = "//*[@id=\"topbar_main\"]/div/div[2]/div/div[3]/div/ul/li"))
	List<WebElement> listLanguages;

	@FindBy(xpath = "//*[@id=\"topbar_main\"]/div/div[1]/div[1]/div[1]/span[2]")
	WebElement lblShipTo;

	@FindBy(id = "all_dropdown_set")
	WebElement searchBarCategoryDDMenu;

	@FindBy(xpath = "/html/body/div/div[1]/div[1]/div/div[1]/div/div/div[2]/div/div[3]/div/button/span/span[2]")
	WebElement lblSelectedLanguage;

	@FindBy(xpath = "//*[@id=\"SearchHeader_SearchForm__N8uFa\"]/div/div[2]/input")
	WebElement searchBar;

	@FindBy(className = "SearchHeader_advance_search__jvNHt")
	WebElement btnSearch;

	@FindBy(xpath = "//*[@id=\"topbar_main\"]/div/div[3]/div/button[1]/span")
	WebElement WishlistCount;

	@FindBy(xpath = "//*[@id=\"topbar_main\"]/div/div[3]/div/button[1]")
	WebElement btnWishlist;

	@FindBy(xpath = "//*[@id=\"topbar_main\"]/div/div[3]/div/div[1]/button")
	WebElement btnShoppingCart;

	public void clickAtSystemTab() {

		mainTabSettings.click();

		subTabSystem.click();

	}

	public void clickAtUserTypesTab() {

		tabUserTypes.click();

	}













	public void setSearchKeyword(String keyword) {

		searchBar.clear();
		searchBar.sendKeys(keyword);

	}

	public void clickLogin() {

		login.click();

	}

	public void clickRegister() {

		register.click();

	}

	public boolean isLoggedIn() {

		boolean result = false;

		try {

			result = btnProfile.isDisplayed();
			return result;

		} catch (NoSuchElementException e) {

			return result;

		}
	}

	public boolean isLoggedOut() {

		return login.isDisplayed();

	}

	public void clickProfile() {

		btnProfile.click();

	}

	public void clickChangeLanguage() {

		btnChangeLanguage.click();

	}

	public void clickSearch() {

		btnSearch.click();

	}

	public void clickWishlistButton() {

		btnWishlist.click();

	}

	public void clickShoppingCartButton() {

		btnShoppingCart.click();

	}

	public int getWishlistCount() {

		String wishlistCount = WishlistCount.getAttribute("innerHTML");
		int count = Integer.parseInt(wishlistCount);
		return count;

	}

	public String getShipToText() throws InterruptedException {

		Thread.sleep(1000);

		String ShipToText = lblShipTo.getText();
		return ShipToText;

	}

	public String getFrenchCategoryDDText() {

		Select category = new Select(searchBarCategoryDDMenu);
		String searchCategoryDDFrenchlabel = category.getFirstSelectedOption().getText();

		return searchCategoryDDFrenchlabel;

	}

	public String getSearchBarPlaceholder() {

		String placeholderText = searchBar.getAttribute("placeholder");
		return placeholderText;

	}

	public String getSelectedLanguage() {

		String language = lblSelectedLanguage.getText();
		return language;

	}

	public void clickProfileMenuOption(String option) {

		for (WebElement element : profileDDMenu) {

			String currentOption = element.getText();

			if (currentOption.equals(option)) {

				element.click();
				break;

			}
		}
	}

	public void selectCategorySearchDD() {

		Select category = new Select(searchBarCategoryDDMenu);
		category.selectByIndex(1);

	}

	public void selectLanguageEnglish() {

		for (WebElement element : listLanguages) {

			String language = element.getText();

			if (language.equals("English")) {

				element.click();
				break;

			}
		}
	}

	public void selectLanguageFrench() {

		for (WebElement element : listLanguages) {

			String language = element.getText();

			if (language.contains("French")) {

				element.click();
				break;

			}
		}
	}

}
