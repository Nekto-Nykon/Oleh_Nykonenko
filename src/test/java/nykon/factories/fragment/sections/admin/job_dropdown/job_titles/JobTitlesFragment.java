package nykon.factories.fragment.sections.admin.job_dropdown.job_titles;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import nykon.factories.fragment.sections.Fragment;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class JobTitlesFragment extends Fragment {
    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/div[1]/div/button")
    private WebElement addJobButton;

    @FindBy(xpath = "/html/body/div/div[1]/div[2]/div[2]/div/div/div[2]/div/div/button")
    private WebElement deleteJobButton;

    @FindBy(xpath = "//*[@id=\"app\"]/div[3]/div/div/div/div[3]/button[2]")
    private WebElement deleteConfirmationButton;

    public JobTitlesFragment(WebDriver driver) {
        super(driver);
    }

    public void clickOnAddJobTitleButton() {
        addJobButton.click();
    }

    public void assertNewJobTitleHasBeenAdded(String jobTitle) {
        assertTrue(getWebDriver()
                                      .findElements(By.xpath("//div[.='" + jobTitle + "']"))
                                      .size() > 0
        );
    }

    public void selectJobTitle(String jobTitle){
        getWebDriver()
                .findElement(
                        By.xpath("//div[.='" + jobTitle + "']/ancestor::div[2]/div/div[1]/div/div/label/span/i")
                ).click();
    }
    public void clickOnDeleteSelectedButton() {
        Actions action = new Actions(getWebDriver());
        action.moveToElement(deleteJobButton).click().build().perform();
    }

    public void clickOnYesDeleteButton(){
        deleteConfirmationButton.click();
    }

    public void assertJobTitleDeleted(String jobTitle) {
        assertTrue(getWebDriver()
                .findElements(
                        By.xpath("//div[.='" + jobTitle + "']")
                )
                .isEmpty()
        );
    }
}
