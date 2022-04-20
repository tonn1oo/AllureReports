package allureReport;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.openqa.selenium.By.linkText;
import static org.openqa.selenium.By.partialLinkText;

public class SelenideTest {

    @Test
    public void testGithubIssue(){
        open("https://github.com");

        $(".header-search-input").click();
        $(".header-search-input").sendKeys("tonn1oo/AllureReports");
        $(".header-search-input").submit();

        $(linkText("tonn1oo/AllureReports")).click();
        $(partialLinkText("Issue")).click();
        $(withText("#1")).click();


    }
}
