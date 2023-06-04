package nykon.factories.fragment;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

import java.time.Duration;
import java.time.temporal.ChronoUnit;

public class PageFactoryHolder {
    private static volatile FragmentFactory pageFactory;

    public static FragmentFactory getImpl1InstanceWithEdgeDriver() {
        if (pageFactory == null) {
            synchronized (FragmentFactory.class) {
                if (pageFactory == null) {
                    pageFactory = new FragmentFactoryImpl1(createManagedEdgeDriver());
                }
            }
        }
        return pageFactory;
    }

    private static WebDriver createManagedEdgeDriver(){
        EdgeOptions edgeOptions = new EdgeOptions();
        edgeOptions.addArguments("--remote-allow-origins=*");
        WebDriver webDriver = new EdgeDriver(edgeOptions);
        webDriver.manage().deleteAllCookies();
        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(Duration.of(5, ChronoUnit.SECONDS));
        return webDriver;
    }
}