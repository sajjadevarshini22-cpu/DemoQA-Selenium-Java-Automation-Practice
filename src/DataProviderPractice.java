import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderPractice {

    @DataProvider(name="loginData")
    public Object[][] getLoginData()
    {
        return new Object[][]{
                {"standard_user", "secret_sauce"},
                {"locked_out_user", "secret_sauce"},
                {"problem_user", "secret_sauce"},
                {"invalid_user", "wrong_password"}

        };
    }
    @Test(dataProvider="loginData")
    public void loginTest(String username,String password)
    {
        System.out.println("Username: " + username);
        System.out.println("Password: " + password);
        System.out.println("----------------------");
    }
}
