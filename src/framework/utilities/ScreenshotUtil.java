package framework.utilities;

import java.io.File;
import java.io.IOException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class ScreenshotUtil {

    public static void captureScreenshot(WebDriver driver,String fileName) throws IOException
    {
        TakesScreenshot ts=(TakesScreenshot)  driver;
        File source=ts.getScreenshotAs((OutputType.FILE));

        File destination=new File("screenshots/"+ fileName +".png");
        FileHandler.copy(source,destination);
        System.out.println("Screenshot Captured:"+ fileName);
    }


}
