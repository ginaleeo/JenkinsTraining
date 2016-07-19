package pokemon;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 * Created by o'connellg on 7/19/2016.
 */
public class SearchPokemonGoTest {
    @DataProvider(name = "myTest")
    public Object[][] createData(){
        return new Object[][]{
                {"Pokemon Go", "http://www.google.com"},
                {"Pokemon Go Egg Chart", "http://www.google.com"},
                {"Pokemon Go reddit", "http://www.google.com"}
        };
    }

    @Test(dataProvider = "myTest")
    public void PokemonGo(String searchText, String URL){

        // Create a new instance of the Firefox driver
        System.setProperty("webdriver.chrome.driver", "C:\\drivers\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        // Navigate to Google home page
        driver.get(URL);

        // Find the text input element by its name
        WebElement element = driver.findElement(By.name("q"));

        // Enter something to search for
        element.sendKeys(searchText);

        // Submit the form (WebDriver will find the form for us from the element)
        element.submit();

        WebDriverWait wait = new WebDriverWait(driver, 15);
                wait.until (ExpectedConditions.titleContains(searchText));

        // Should see: “Pokemon Go - Google Search"
        System.out.println("Page title is: " + driver.getTitle());

        // Close the browser
        driver.quit();

    }


    }

