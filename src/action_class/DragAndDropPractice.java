package action_class;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class DragAndDropPractice {
    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();

        driver.get("https://demoqa.com/droppable");
        driver.manage().window().maximize();

        Actions actions = new Actions(driver);

        WebElement source = driver.findElement(By.id("draggable"));
        WebElement target = driver.findElement(By.id("droppable"));

        actions.dragAndDrop(source, target).perform();

        String message = target.getText();

        System.out.println("Drop message: " + message);

        driver.quit();
    }
}