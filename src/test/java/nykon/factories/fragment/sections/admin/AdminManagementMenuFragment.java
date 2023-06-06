package nykon.factories.fragment.sections.admin;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import nykon.factories.fragment.sections.Fragment;


public class AdminManagementMenuFragment extends Fragment {
    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div[1]/header/div[2]/nav/ul/li[2]")
    private WebElement jobDropDown;

    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div[1]/header/div[2]/nav/ul/li[2]/ul/li[1]/a")
    private WebElement jobTitlesOption;

    public AdminManagementMenuFragment(WebDriver driver) {
        super(driver);
    }

    public void clickOnJobDropdown() {
        jobDropDown.click();
    }

    public void clickOnJobTitlesOption(){
        jobTitlesOption.click();
    }
}
