package pages;

import com.codeborne.selenide.SelenideElement;
import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;
import pages.locators.ResultsLocators;

import static com.codeborne.selenide.Condition.disappear;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;


import org.testng.Assert;

public class ResultsPage {

	private SelenideElement sortList;
	private List<SelenideElement> prices;

	public ResultsPage(ResultsLocators locators) {
		this.sortList = locators.getSortList();
		this.prices = locators.getPrices();
	}

	public void openPage() {
		open("results.html");
	}

	public void selectSort(String sort) {
		$(".preloader-animation").should(disappear, Duration.ofSeconds(7));
		sortList.selectOptionByValue(sort);
		Assert.assertTrue(isSortSelected(sort), "Sort option '" + sort + "' was not selected correctly.");
	}

	public void validateResultsSortedByPrice(String sort) {
		List<Integer> priceList = prices.stream()
				.map(SelenideElement::getText)
				.map(text -> text.replaceAll("[^0-9]", ""))
				.filter(s -> !s.isEmpty())
				.map(Integer::parseInt)
				.collect(Collectors.toList());

		Assert.assertFalse(priceList.isEmpty(), "Price list is empty, no prices found on the page.");

		List<Integer> expectedPrices;
		if ("asc".equals(sort)) {
			expectedPrices = priceList.stream().sorted().collect(Collectors.toList());
			Assert.assertEquals(priceList, expectedPrices, "Prices are not sorted in ascending order.");
		} else if ("desc".equals(sort)) {
			expectedPrices = priceList.stream().sorted((a, b) -> b.compareTo(a)).collect(Collectors.toList());
			Assert.assertEquals(priceList, expectedPrices, "Prices are not sorted in descending order.");
		} else {
			Assert.fail("Invalid sort option: Use \"asc\" or \"desc\", but got: " + sort);
		}
	}

	private boolean isSortSelected(String sort) {
		return sortList.getSelectedOption().getValue().equals(sort);
	}
}
