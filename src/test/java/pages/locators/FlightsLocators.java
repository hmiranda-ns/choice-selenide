package pages.locators;

import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selenide.$;

public class FlightsLocators {

	private SelenideElement departureField = $("#flight-from");
	private SelenideElement destinationField = $("#flight-to");
	private SelenideElement departureDateField = $("#departing");
	private SelenideElement returnDateField = $("#returning");
	private SelenideElement travelersField = $("#travelers");
	private SelenideElement searchButton = $(".btn");

	public SelenideElement getDepartureField() {
		return departureField;
	}

	public SelenideElement getDestinationField() {
		return destinationField;
	}

	public SelenideElement getDepartureDateField() {
		return departureDateField;
	}

	public SelenideElement getReturnDateField() {
		return returnDateField;
	}

	public SelenideElement getTravelersField() {
		return travelersField;
	}

	public SelenideElement getSearchButton() {
		return searchButton;
	}
	public String flightsURL() {
		return "flights.html";
	}
}
