package pages.locators;

import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selenide.$;

public class FlightsLocators {

	private final SelenideElement departureField = $("#flight-from");
	private final SelenideElement destinationField = $("#flight-to");
	private final SelenideElement departureDateField = $("#departing");
	private final SelenideElement returnDateField = $("#returning");
	private final SelenideElement travelersField = $("#travelers");
	private final SelenideElement searchButton = $(".btn");

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
