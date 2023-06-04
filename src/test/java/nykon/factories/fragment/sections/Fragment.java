package nykon.factories.fragment.sections;

import lombok.Getter;
import org.openqa.selenium.WebDriver;
@Getter
public class Fragment {
    private final WebDriver webDriver;

    public Fragment(WebDriver driver) {
        this.webDriver = driver;
        org.openqa.selenium.support.PageFactory.initElements(driver, this);
    }
}
