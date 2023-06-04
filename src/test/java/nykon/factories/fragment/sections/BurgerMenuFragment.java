package nykon.factories.fragment.sections;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BurgerMenuFragment extends Fragment {
    @FindBy(xpath = "//a[@href='/web/index.php/admin/viewAdminModule']")
    private WebElement adminButton;

    public BurgerMenuFragment(WebDriver driver) {
        super(driver);
    }

    public void clickOnAdminOption() {
        adminButton.click();
    }
}
