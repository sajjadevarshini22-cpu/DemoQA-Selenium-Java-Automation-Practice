package webelements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.JavascriptExecutor;
public class DemoQAWebElementActions {
    public static void main(String[] args) {

        WebDriver driver=new ChromeDriver();

        driver.get("https://demoqa.com/automation-practice-form");
        driver.manage().window().maximize();

        JavascriptExecutor js = (JavascriptExecutor) driver;

        //First Name
        WebElement firstName=driver.findElement(By.id("firstName"));
        System.out.println(firstName.isDisplayed());
        System.out.println(firstName.isEnabled());

        firstName.sendKeys("WrongName");
        firstName.clear();
        firstName.sendKeys("Devarshini");

        String firstNameValue=firstName.getAttribute("value");
        System.out.println("Entered First Name:"+ firstNameValue);

        //LastName

        WebElement lastName=driver.findElement(By.id("lastName"));
        lastName.sendKeys("Sajja");

        //Email
        WebElement email=driver.findElement(By.id("userEmail"));
        email.sendKeys("devarshini@gmail.com");

        String emailPlaceholder=email.getAttribute("placeholder");
        System.out.println("Email Placeholder:"+emailPlaceholder);


        //Gender-Female

        driver.findElement(By.xpath("//label[text()='Female']")).click();

        WebElement femaleRadio=driver.findElement(By.id("gender-radio-2"));
        System.out.println("Female selected:"+femaleRadio.isSelected());

        //Mobile Number
        WebElement mobileNumber=driver.findElement(By.id("userNumber"));
        mobileNumber.sendKeys("9876543210");

        //Hobby-Reading
        WebElement readingLabel = driver.findElement(By.xpath("//label[text()='Reading']"));

        js.executeScript("arguments[0].scrollIntoView({block: 'center'});", readingLabel);
        js.executeScript("arguments[0].click();", readingLabel);

        WebElement readingCheckbox = driver.findElement(By.id("hobbies-checkbox-2"));
        System.out.println("Reading Selected: " + readingCheckbox.isSelected());

        //Current Address
        WebElement address=driver.findElement(By.id("currentAddress"));
        address.sendKeys("Bangalore");

        //Submit
        WebElement submitButton=driver.findElement(By.id("submit"));
        String buttonText=submitButton.getText();

        System.out.println("Submit Button Text:"+buttonText);
        System.out.println("Submit button Displayed:"+submitButton.isDisplayed());
        System.out.println("Submit button Enabled:"+ submitButton.isEnabled());

        driver.quit();
    }
}

