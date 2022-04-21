package allureReport;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;
import static org.openqa.selenium.By.linkText;
import static org.openqa.selenium.By.partialLinkText;

public class LambdaStepTest {

    private static final String repository = "tonn1oo/AllureReports";
    private static final int issue_number = 1;

    @Test
    public void testGithubIssue(){
      SelenideLogger.addListener("allure", new AllureSelenide());

        step("Open the main page", () -> {
            open("http://github.com");
                });

        step("Looking for a repository" + repository , () -> {
            $(".header-search-input").click();
            $(".header-search-input").sendKeys(repository);
            $(".header-search-input").submit();
        });
        step("click on the repository link" + repository, () -> {
            $(linkText(repository)).click();
        });
        step("click on tab issue", () -> {
            $(partialLinkText("Issue")).click();
        });
        step("check that there is an issue with the number" + issue_number, () -> {
            $(withText("#1")).should(Condition.visible);
        });


    }
}
