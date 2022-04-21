package allureReport;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;

import java.security.PublicKey;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;
import static org.openqa.selenium.By.linkText;
import static org.openqa.selenium.By.partialLinkText;

public class WebSteps {
    @Step("Open the main page")
    public void openMainPage(){
        open("http://github.com");

    }
    @Step("looking for a repository {repo}")
    public void searchForRepository(String repo){
        $(".header-search-input").click();
        $(".header-search-input").sendKeys(repo);
        $(".header-search-input").submit();

    }
    @Step("click on the repository link {repo}")
    public void clickOnRepositoryLink(String repo){
        $(linkText(repo)).click();

    }
    @Step("click on tab issue")
    public void openIssueTab(){
        $(partialLinkText("Issue")).click();

    }
    @Step("check that there is an issue with the number {number}")
    public void shouldSeeIssueWithNumber(int number){
        $(withText("#" + number)).should(Condition.visible);


    }
}
