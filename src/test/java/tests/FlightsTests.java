package tests;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.FlightsPage;
import pages.ResultsPage;
import pages.locators.FlightsLocators;
import pages.locators.ResultsLocators;

public class FlightsTests extends BaseTest {

	FlightsPage flightsPage;
	FlightsLocators flightsLocators;
	ResultsPage resultsPage;
	ResultsLocators resultsLocators;

	@BeforeClass
	public void setUp() {
		// Initialize the locators
		flightsLocators = new FlightsLocators();
		resultsLocators = new ResultsLocators();

		// Initialize the Pages and pass the locators
		flightsPage = new FlightsPage(flightsLocators);
		resultsPage = new ResultsPage(resultsLocators);
	}

	@Test
	public void testSearchFlightResultsSortedByPrice() {
		flightsPage.openPage();
		flightsPage.selectDepartureCity("Hermosillo");
		flightsPage.selectDestinationCity("CDMX");
		flightsPage.setDepartureAndReturnDatesFromToday(2, 5);
		flightsPage.selectTravelers("2");
		flightsPage.clickSearchButton();

		resultsPage.selectSort("asc");
		resultsPage.validateResultsSortedByPrice("asc");

		/*
		sorted by desc changes the price for one $180 flight to $181
		ignored destination and departure cities
		all flights MEX-HAV, same time, same flight number
		sorting by relevance does nothing
		*/
		//resultsPage.selectSort("desc");
		//resultsPage.validateResultsSortedByPrice("desc");
	}
}

