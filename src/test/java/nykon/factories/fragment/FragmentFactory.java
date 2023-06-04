package nykon.factories.fragment;

import nykon.factories.fragment.sections.BurgerMenuFragment;
import nykon.factories.fragment.sections.LoginFragment;
import nykon.factories.fragment.sections.admin.AdminManagementMenuFragment;
import nykon.factories.fragment.sections.admin.job_dropdown.job_titles.AddingJobTitleFragment;
import nykon.factories.fragment.sections.admin.job_dropdown.job_titles.JobTitlesFragment;

public interface FragmentFactory {
    AdminManagementMenuFragment getAdminManagementMenuFragment();

    AddingJobTitleFragment getAddingJobTitleFragment();

    JobTitlesFragment getJobTitlesFragment();

    LoginFragment getLoginFragment();

    BurgerMenuFragment getBurgerMenuFragment();
    void closeDriver();
}
