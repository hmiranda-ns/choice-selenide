package pages.locators;

import com.codeborne.selenide.SelenideElement;

import java.util.List;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class ResultsLocators {

	private SelenideElement sortList = $("#sort");
	private List<SelenideElement> prices = $$(".price");

	public SelenideElement getSortList() {
		return sortList;
	}

	public List<SelenideElement> getPrices() {
		return prices;
	}

	public String resultsURL() {
		return "results.html";
	}
}