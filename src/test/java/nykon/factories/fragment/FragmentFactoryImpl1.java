package nykon.factories.fragment;

import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebDriver;
import nykon.factories.fragment.sections.BurgerMenuFragment;
import nykon.factories.fragment.sections.LoginFragment;
import nykon.factories.fragment.sections.admin.AdminManagementMenuFragment;
import nykon.factories.fragment.sections.admin.job_dropdown.job_titles.AddingJobTitleFragment;
import nykon.factories.fragment.sections.admin.job_dropdown.job_titles.JobTitlesFragment;

@Slf4j
public class FragmentFactoryImpl1 implements FragmentFactory {

    private final WebDriver webDriver;

    public FragmentFactoryImpl1(WebDriver webDriver) {
        System.setProperty("webdriver.gecko.drivers", "src/test/resources/drivers/geckodriver");
        this.webDriver = webDriver;
    }

    @Override
    public AdminManagementMenuFragment getAdminManagementMenuFragment() {
        return new AdminManagementMenuFragment(webDriver);
    }

    @Override
    public AddingJobTitleFragment getAddingJobTitleFragment() {
        return new AddingJobTitleFragment(webDriver);
    }

    @Override
    public JobTitlesFragment getJobTitlesFragment() {
        return new JobTitlesFragment(webDriver);
    }

    @Override
    public LoginFragment getLoginFragment() {
        return new LoginFragment(webDriver);
    }

    @Override
    public BurgerMenuFragment getBurgerMenuFragment() {
        return new BurgerMenuFragment(webDriver);
    }


    @Override
    public void closeDriver() {
        log.info("Closing driver");
        webDriver.quit();
    }
}