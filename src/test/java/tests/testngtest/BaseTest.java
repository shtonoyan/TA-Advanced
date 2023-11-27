package tests.testngtest;

import org.example.core.PropertyReader;
import org.testng.annotations.BeforeSuite;

public abstract class BaseTest {
    @BeforeSuite
    public void loadProperties() {
        PropertyReader.loadConfig("webRP");
    }
}
