import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.DragAndDropOptions.to;
import static com.codeborne.selenide.Selectors.withTagAndText;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.*;

public class TestFiveLessonSelenide {
    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
    }

    @Test
    void tittleAITest() {
        open("https://github.com");
        $(withTagAndText("button", "Solution")).hover();
        $(withTagAndText("button", "Solution")).sibling(0).$(withText("Enterprises"))
                .click();
        $("#hero-section-brand-heading").shouldHave(exactText("The AI-powered\ndeveloper platform"));
    }

    @Test
    void moveToElementTest() {
        open("https://the-internet.herokuapp.com/drag_and_drop");
        actions().moveToElement($("#column-a")).clickAndHold().moveToElement($("#column-b")).
                release().perform();
        $("#column-a").shouldHave(exactText("B"));
    }

    @Test
    void dragAndDropTest() {
        open("https://the-internet.herokuapp.com/drag_and_drop");
        $("#column-a").shouldHave(text("A"));
        $("#column-b").shouldHave(text("B"));
        $("#column-a").dragAndDrop(to("#column-b"));

        $("#column-a").shouldHave(exactText("B"));
    }
}

