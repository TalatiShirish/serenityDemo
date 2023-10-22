package com.serenity.pages_and_steps.pages.loginPage;

import com.serenity.annotations.PageName;
import com.serenity.annotations.XpathLabel;
import com.serenity.pages_and_steps.pages.BasePage;
import lombok.Getter;
import org.openqa.selenium.WebDriver;

import static com.serenity.pages_and_steps.pages.loginPage.Login.Controls.*;

@Getter
@PageName(CURRENT_PAGE_NAME)
public class Login extends BasePage {
    @XpathLabel(USERNAME)
    private String username= "//input[@name='username']";

    @XpathLabel(PASSWORD)
    private String password = "//input[@name='password']";

    @XpathLabel(LOGINBUTTON)
    private String loginButton = "//button [@type='submit']";


    public Login(WebDriver driver) {
        super(driver);
        setVerifyXpath(loginButton);
    }

    public interface Controls{
        String CURRENT_PAGE_NAME="Login";
        String USERNAME="User Name Textbox";
        String PASSWORD="Password Textbox";
        String LOGINBUTTON="Login Button";
    }
}
