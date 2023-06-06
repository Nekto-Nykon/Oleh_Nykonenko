package nykon.factories.fragment.sections.admin.job_dropdown.job_titles;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import nykon.factories.fragment.sections.Fragment;


public class AddingJobTitleFragment extends Fragment {
    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[1]/div/div[2]/input")
    private WebElement jobTitleInput;

    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[2]/div/div[2]/textarea")
    private WebElement jobDescriptionTextArea;

    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[4]/div/div[2]/textarea")
    private WebElement noteTextArea;

    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[5]/button[2]")
    private WebElement saveButton;

    public AddingJobTitleFragment(WebDriver driver) {
        super(driver);
    }

    public void injectData(String title,
                           String description,
                           String note) {
        jobTitleInput.sendKeys(title);
        jobDescriptionTextArea.sendKeys(description);
        noteTextArea.sendKeys(note);
    }

    public void saveJobTitle() {
        saveButton.click();
    }
}
