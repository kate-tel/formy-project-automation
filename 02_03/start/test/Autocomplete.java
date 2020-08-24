import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;

public class Autocomplete {
    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "/usr/local/Caskroom/chromedriver/83.0.4103.39/chromedriver");

        WebDriver driver = new ChromeDriver();

        driver.get("https://formy-project.herokuapp.com/autocomplete");

        WebElement autocomplete = driver.findElement(By.id("autocomplete"));
        autocomplete.sendKeys("2323 East ApAche Boulevard Tempe, AZ, USA");
        Thread.sleep(1000);

        WebElement autocompleteHint = driver.findElement(By.className("pac-item"));
        autocomplete.click();

        driver.quit();
    }
}
