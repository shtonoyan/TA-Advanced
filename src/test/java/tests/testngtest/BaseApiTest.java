package tests.testngtest;

import org.example.api.services.AuthApi;
import org.example.core.PropertyReader;
import org.testng.annotations.BeforeSuite;

public abstract class BaseApiTest extends BaseTest{
    protected static String accessToken;
    @BeforeSuite
    public void login(){
        accessToken = AuthApi.authCall(PropertyReader.getProperty("username"), PropertyReader.getProperty("password"));
    }
}
