package demoqa.pages.components;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class ResultModal {
    private final static String TITLE_TEXT = "Thanks for submitting the form";
    private final SelenideElement
            resultTable = $(".table"),
            modalHeader = $(".modal-header");

    public ResultModal checkResult(String key, String value) {
        $(resultTable).$(byText(key)).parent().lastChild().shouldHave(text(value));
        return this;
    }

    public ResultModal checkResultsVisible() {
        $(modalHeader).shouldHave(text(TITLE_TEXT));
        return this;
    }
}
