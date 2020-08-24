import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Set;

public class SwitchToActiveWindow {
    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "/usr/local/Caskroom/chromedriver/83.0.4103.39/chromedriver");

        WebDriver driver = new ChromeDriver();

        driver.get("https://formy-project.herokuapp.com/switch-window");

        WebElement newTabButton = driver.findElement(By.id("new-tab-button"));
        newTabButton.click();

        // fetches ID of original window
        String currentWindow = driver.getWindowHandle();
        /* additional check
        System.out.println("The current window is "+ currentWindow);
         */

        // returns a set of IDs of all opened windows
        Set<String> allWindows = driver.getWindowHandles();

        // iterates over all windows and switches to last opened
        for (String newWindow : allWindows) {
            if (newWindow != currentWindow) {
                driver.switchTo().window(newWindow);
                //System.out.println("The new window is "+ newWindow);
            }
        }

        // switches back to original window
        driver.switchTo().window(currentWindow);

        driver.quit();
    }
}
