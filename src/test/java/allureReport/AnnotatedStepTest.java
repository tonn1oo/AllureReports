package allureReport;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Test;

public class AnnotatedStepTest {

    private static final String repository = "tonn1oo/AllureReports";
    private static final int issue_number = 1;

    @Test
    public void testGithubIssue() {
        SelenideLogger.addListener("allure", new AllureSelenide());
        WebSteps steps = new WebSteps();

        steps.openMainPage();
        steps.searchForRepository(repository);
        steps.clickOnRepositoryLink(repository);
        steps.openIssueTab();
        steps.shouldSeeIssueWithNumber(issue_number);


    }
}
