
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Selectors.withTagAndText;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.*;



public class TestFiveLessonSelenide {
    @BeforeAll
    static void beforeAll(){
        Configuration.browserSize = "1920x1080";
    }

    @Test
    void testTittleAI(){
        open("https://github.com");
        $(withTagAndText("button", "Solution")).hover();
        $(withTagAndText("button", "Solution")).sibling(0).$(withText("Enterprises"))
                .click();
        $("#hero-section-brand-heading").shouldHave(exactText("The AI-powered\ndeveloper platform"));

    }

    @Test
    void testDragAndDrop(){
        open("https://the-internet.herokuapp.com/drag_and_drop");
        actions().moveToElement($("#column-a")).clickAndHold().moveToElement($("#column-b")).
                release().perform();
        $("#column-a").shouldHave(exactText("B"));


    }

}


