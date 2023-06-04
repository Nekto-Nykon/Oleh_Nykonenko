package nykon.factories.fragment.sections;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class LoginFragment extends Fragment {
    @FindBy(name = "username")
    private WebElement usernameField;

    @FindBy(name = "password")
    private WebElement passwordField;

    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[3]/button")
    private WebElement loginButton;

    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/div/div/p[1]")
    private WebElement usernameHint;

    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/div/div/p[2]")
    private WebElement passwordHint;

    public LoginFragment(WebDriver driver) {
        super(driver);
    }

    public void redirectToLoginPage() {
        getWebDriver().get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
    }

    public String getUsernameHint() {
        return usernameHint.getText()
                .replace("Username : ", "");
    }

    public String getPasswordHint() {
        return passwordHint.getText()
                .replace("Password : ", "");
    }

    public void loginWithGivenTips() {
        usernameField.sendKeys(getUsernameHint());
        passwordField.sendKeys(getPasswordHint());
        loginButton.click();
    }
}
