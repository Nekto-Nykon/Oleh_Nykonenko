package nykon.cucumber;

import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lombok.extern.slf4j.Slf4j;
import nykon.factories.fragment.FragmentFactory;
import nykon.factories.fragment.PageFactoryHolder;
import nykon.factories.fragment.sections.admin.job_dropdown.job_titles.AddingJobTitleFragment;

@Slf4j
public class StepsImpl {
    private final FragmentFactory fragmentFactory;
    public StepsImpl(){
        fragmentFactory = PageFactoryHolder.getImpl1InstanceWithEdgeDriver();
    }

    @Given("user went onto login page")
    public void enterLoginPage() {
        fragmentFactory.getLoginFragment().redirectToLoginPage();
    }

    @When("user logs in")
    public void logIn() {
        fragmentFactory.getLoginFragment().loginWithGivenTips();
    }

    @When("user enters Admin page")
    public void loadAdmin() {
        fragmentFactory.getBurgerMenuFragment().clickOnAdminOption();
    }

    @And("user selects 'Job' dropdown")
    public void getJobTitlesPage() {
        fragmentFactory.getAdminManagementMenuFragment().clickOnJobDropdown();
    }

    @And("user selects 'Job titles' option")
    public void selectJobTitles(){
        fragmentFactory.getAdminManagementMenuFragment().clickOnJobTitlesOption();
    }

    @And("user clicks on the Add button")
    public void getAddJobTitlePage() {
        fragmentFactory.getJobTitlesFragment().clickOnAddJobTitleButton();
    }

    @And("user creates new job with title {string}, description {string}, and note {string}")
    public void addJobTitle(String jobTitle, String description, String note) {
        AddingJobTitleFragment addingJobTitleFragment = fragmentFactory.getAddingJobTitleFragment();
        addingJobTitleFragment.injectData(jobTitle, description, note);
        addingJobTitleFragment.saveJobTitle();
    }


    @Then("new {string} job title appears on the the 'Job Titles' page")
    public void verifyNewJobTitleCreation(String jobTitle) {
        fragmentFactory.getJobTitlesFragment().assertNewJobTitleHasBeenAdded(jobTitle);
    }

    @When("user selects job titled {string}")
    public void selectJobTitle(String jobTitle) {
        fragmentFactory.getJobTitlesFragment().selectJobTitle(jobTitle);
    }

    @And("user clicks on 'Delete selected'")
    public void deleteSelectedTitles(){
        fragmentFactory.getJobTitlesFragment().clickOnDeleteSelectedButton();
    }

    @And("user confirms deletion by clicking 'Yes, Delete'")
    public void confirmDeletion() {
        fragmentFactory.getJobTitlesFragment().clickOnYesDeleteButton();
    }

    @Then("the job {string} is removed")
    public void verifyJobTitleDeletion(String jobTitle) {
        fragmentFactory.getJobTitlesFragment().assertJobTitleDeleted(jobTitle);
    }

    @After
    public void closeBrowser() {
        log.info("Closing browser...");
        fragmentFactory.closeDriver();
        log.info("Browser has been closed");
    }
}
