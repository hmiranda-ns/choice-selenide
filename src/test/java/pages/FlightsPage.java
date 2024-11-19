package pages;

import com.codeborne.selenide.SelenideElement;
import pages.locators.FlightsLocators;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import static com.codeborne.selenide.Selenide.open;

public class FlightsPage {

	// Locators (injected through constructor)
	private SelenideElement departureField;
	private SelenideElement destinationField;
	private SelenideElement departureDateField;
	private SelenideElement returnDateField;
	private SelenideElement travelersField;
	private SelenideElement searchButton;

	// Constructor that accepts an instance of FlightsLocators
	public FlightsPage(FlightsLocators locators) {
		this.departureField = locators.getDepartureField();
		this.destinationField = locators.getDestinationField();
		this.departureDateField = locators.getDepartureDateField();
		this.returnDateField = locators.getReturnDateField();
		this.travelersField = locators.getTravelersField();
		this.searchButton = locators.getSearchButton();
	}

	public void openPage() {
		open("flights.html");
	}

	public void selectDepartureCity(String departure) {
		departureField.selectOption(departure);
	}

	public void selectDestinationCity(String destination) {
		destinationField.selectOption(destination);
	}

	public void setDepartureAndReturnDatesFromToday(int departureDays, int tripLength) {
		Calendar calendar = Calendar.getInstance();

		calendar.add(Calendar.DATE, departureDays);
		String formattedDepartureDate = new SimpleDateFormat("yyyy-MM-dd").format(calendar.getTime());

		calendar.add(Calendar.DATE, tripLength);
		String formattedReturnDate = new SimpleDateFormat("yyyy-MM-dd").format(calendar.getTime());

		departureDateField.setValue(formattedDepartureDate);
		returnDateField.setValue(formattedReturnDate);
	}

	public void selectTravelers(String travelers) {
		travelersField.selectOption(travelers);
	}

	public void clickSearchButton() {
		searchButton.click();
	}
}

