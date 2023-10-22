package com.serenity.pages_and_steps.pages.dashboardPage;

import com.serenity.annotations.PageName;
import com.serenity.annotations.XpathLabel;
import com.serenity.pages_and_steps.pages.BasePage;
import lombok.Getter;
import org.openqa.selenium.WebDriver;

import static com.serenity.pages_and_steps.pages.dashboardPage.DashboardPage.Controls.*;

@Getter
@PageName(CURRENT_PAGE_NAME)
public class DashboardPage extends BasePage  {
    @XpathLabel(DASHBOARD_LABEL)
    private String dashboard_label= "//h1";

    public DashboardPage(WebDriver driver) {
        super(driver);
        setVerifyXpath(dashboard_label);
    }
    public interface Controls{
        String CURRENT_PAGE_NAME = "Dashboard";
        String DASHBOARD_LABEL = "Dashboard Label";
    }
}


