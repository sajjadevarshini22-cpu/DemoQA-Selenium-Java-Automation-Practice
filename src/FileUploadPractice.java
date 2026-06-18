import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FileUploadPractice {

    public static void main(String[]args)
    {
        WebDriver driver=new ChromeDriver();
        driver.get("https://demoqa.com/automation-practice-form");
        driver.manage().window().maximize();

        String filePath=System.getProperty("user.dir")+ "/testdata/demoqa.png";

        driver.findElement(By.id("firstName")).sendKeys("Devarshini");
        driver.findElement(By.id("lastName")).sendKeys("Sajja");
        driver.findElement(By.id("userEmail")).sendKeys("devarshini@gmail.com");
        driver.findElement(By.xpath("//label[text()='Female']")).click();
        driver.findElement(By.id("userNumber")).sendKeys("9876543210");

        //File Upload
        driver.findElement(By.id("uploadPicture")).sendKeys(filePath);
        System.out.println("Uploaded file path:"+ filePath);

        driver.quit();

    }
}
