import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class SignUpTest {

    @Test
    public void validZipCodeShouldBeAccepted() {
        //Open https://www.sharelane.com/cgi-bin/register.py
        //Enter 11111 into ZIP-code
        //Click continue
        //Check that "Register" button exists
        //<input type="submit" value="Register">

        System.setProperty("webdriver.gecko.driver", "src/test/resources/geckodriver.exe");
        WebDriver driver = new FirefoxDriver();
        driver.get("https://www.sharelane.com/cgi-bin/register.py");
        driver.findElement(By.name("zip_code")).sendKeys("11111");
        driver.findElement(By.cssSelector("[value=Continue]")).click();
        boolean isPageOpened = driver.findElement(By.cssSelector("[value=Register]")).isDisplayed();
        assertTrue(isPageOpened, "Sign Up page was not opened");
        driver.quit();
    }

    @Test
    public void zipCodeShouldBeRequired() {

        System.setProperty("webdriver.gecko.driver", "src/test/resources/geckodriver.exe");
        WebDriver driver = new FirefoxDriver();
        driver.get("https://www.sharelane.com/cgi-bin/register.py");
        driver.findElement(By.cssSelector("[value=Continue]")).click();
        String error = driver.findElement(By.cssSelector("[class=error_message]")).getText();
        assertEquals(error, "Oops, error on page. ZIP code should have 5 digits", "Error text is not correct");
        driver.quit();

    }

    @Test
    public void zipCodeWithMoreThanSixCharsShouldBeRequired() {

        System.setProperty("webdriver.gecko.driver", "src/test/resources/geckodriver.exe");
        WebDriver driver = new FirefoxDriver();
        driver.get("https://www.sharelane.com/cgi-bin/register.py");
        driver.findElement(By.name("zip_code")).sendKeys("111111");
        driver.findElement(By.cssSelector("[value=Continue]")).click();
        String error = driver.findElement(By.cssSelector("[class=error_message]")).getText();
        assertEquals(error, "Oops, error on page. ZIP code should have 5 digits", "Error text is not correct");
        driver.quit();

    }

    @Test
    public void zipCodeWithUnvaluedCharsShouldNotBeCreated() {

        System.setProperty("webdriver.gecko.driver", "src/test/resources/geckodriver.exe");
        WebDriver driver = new FirefoxDriver();
        driver.get("https://www.sharelane.com/cgi-bin/register.py");
        driver.findElement(By.name("zip_code")).sendKeys("aaaaa");
        driver.findElement(By.cssSelector("[value=Continue]")).click();
        String error = driver.findElement(By.cssSelector("[class=error_message]")).getText();
        assertEquals(error, "Oops, error on page. ZIP code should have 5 digits", "Error text is not correct");
        driver.quit();

    }


    @Test
    public void firstNameShouldBeRequired() {

        System.setProperty("webdriver.gecko.driver", "src/test/resources/geckodriver.exe");
        WebDriver driver = new FirefoxDriver();
        driver.get("https://www.sharelane.com/cgi-bin/register.py?page=1&zip_code=11111");
        driver.findElement(By.cssSelector("[value=Register]")).click();
        String error = driver.findElement(By.cssSelector("[class=error_message]")).getText();
        assertEquals(
                error,
                "Oops, error on page. Some of your fields have invalid data or email was previously used",
                "Error text is not correct"
                    );
        driver.quit();

    }

    @Test
    public void shouldCreateAccount() {

        System.setProperty("webdriver.gecko.driver", "src/test/resources/geckodriver.exe");
        WebDriver driver = new FirefoxDriver();
        driver.get("https://www.sharelane.com/cgi-bin/register.py?page=1&zip_code=11111");
        driver.findElement(By.name("first_name")).sendKeys("Yul");
        driver.findElement(By.name("last_name")).sendKeys("Kom");
        driver.findElement(By.name("email")).sendKeys("yulion28@mail.ru");
        driver.findElement(By.name("password1")).sendKeys("1111");
        driver.findElement(By.name("password2")).sendKeys("1111");
        driver.findElement(By.cssSelector("[value=Register]")).click();
        String success =  driver.findElement(By.cssSelector("[class=confirmation_message]")).getText();
        assertEquals(success, "Account is created!");
        driver.quit();
    }

    @Test
    public void accountShouldNotBeCreatedWithDifferentPassword() {

        System.setProperty("webdriver.gecko.driver", "src/test/resources/geckodriver.exe");
        WebDriver driver = new FirefoxDriver();
        driver.get("https://www.sharelane.com/cgi-bin/register.py?page=1&zip_code=11111");
        driver.findElement(By.name("first_name")).sendKeys("Yul");
        driver.findElement(By.name("last_name")).sendKeys("Kom");
        driver.findElement(By.name("email")).sendKeys("yulion28@mail.ru");
        driver.findElement(By.name("password1")).sendKeys("1111");
        driver.findElement(By.name("password2")).sendKeys("11111");
        driver.findElement(By.cssSelector("[value=Register]")).click();
        String error =  driver.findElement(By.cssSelector("[class=error_message]")).getText();
        assertEquals(
                error, "Oops, error on page. Some of your fields have invalid data or email was previously used",
                "Error text is not correct"
                );
        driver.quit();
    }

    @Test
    public void accountShouldNotBeCreatedWithoutPassword() {

        System.setProperty("webdriver.gecko.driver", "src/test/resources/geckodriver.exe");
        WebDriver driver = new FirefoxDriver();
        driver.get("https://www.sharelane.com/cgi-bin/register.py?page=1&zip_code=11111");
        driver.findElement(By.name("first_name")).sendKeys("Yul");
        driver.findElement(By.name("last_name")).sendKeys("Kom");
        driver.findElement(By.name("email")).sendKeys("yulion28@mail.ru");
        driver.findElement(By.name("password1")).sendKeys("");
        driver.findElement(By.name("password2")).sendKeys("");
        driver.findElement(By.cssSelector("[value=Register]")).click();
        String error =  driver.findElement(By.cssSelector("[class=error_message]")).getText();
        assertEquals(
                error, "Oops, error on page. Some of your fields have invalid data or email was previously used",
                "Error text is not correct"
        );
        driver.quit();
    }

    @Test
    public void accountShouldNotBeCreatedWithoutPassword2() {

        System.setProperty("webdriver.gecko.driver", "src/test/resources/geckodriver.exe");
        WebDriver driver = new FirefoxDriver();
        driver.get("https://www.sharelane.com/cgi-bin/register.py?page=1&zip_code=11111");
        driver.findElement(By.name("first_name")).sendKeys("Yul");
        driver.findElement(By.name("last_name")).sendKeys("Kom");
        driver.findElement(By.name("email")).sendKeys("yulion28@mail.ru");
        driver.findElement(By.name("password1")).sendKeys("1111");
        driver.findElement(By.name("password2")).sendKeys("");
        driver.findElement(By.cssSelector("[value=Register]")).click();
        String error =  driver.findElement(By.cssSelector("[class=error_message]")).getText();
        assertEquals(
                error, "Oops, error on page. Some of your fields have invalid data or email was previously used",
                "Error text is not correct"
        );
        driver.quit();
    }

    @Test
    public void accountShouldNotBeCreatedWithoutEmail() {

        System.setProperty("webdriver.gecko.driver", "src/test/resources/geckodriver.exe");
        WebDriver driver = new FirefoxDriver();
        driver.get("https://www.sharelane.com/cgi-bin/register.py?page=1&zip_code=11111");
        driver.findElement(By.name("first_name")).sendKeys("Yul");
        driver.findElement(By.name("last_name")).sendKeys("Kom");
        driver.findElement(By.name("email")).sendKeys("");
        driver.findElement(By.name("password1")).sendKeys("1111");
        driver.findElement(By.name("password2")).sendKeys("1111");
        driver.findElement(By.cssSelector("[value=Register]")).click();
        String error =  driver.findElement(By.cssSelector("[class=error_message]")).getText();
        assertEquals(
                error, "Oops, error on page. Some of your fields have invalid data or email was previously used",
                "Error text is not correct"
        );
        driver.quit();
    }

    @Test
    public void accountShouldNotBeCreatedWithoutFirstName() {

        System.setProperty("webdriver.gecko.driver", "src/test/resources/geckodriver.exe");
        WebDriver driver = new FirefoxDriver();
        driver.get("https://www.sharelane.com/cgi-bin/register.py?page=1&zip_code=11111");
        driver.findElement(By.name("first_name")).sendKeys("");
        driver.findElement(By.name("last_name")).sendKeys("Kom");
        driver.findElement(By.name("email")).sendKeys("yulion28@mail.ru");
        driver.findElement(By.name("password1")).sendKeys("1111");
        driver.findElement(By.name("password2")).sendKeys("1111");
        driver.findElement(By.cssSelector("[value=Register]")).click();
        String error =  driver.findElement(By.cssSelector("[class=error_message]")).getText();
        assertEquals(
                error, "Oops, error on page. Some of your fields have invalid data or email was previously used",
                "Error text is not correct"
        );
        driver.quit();
    }

    @Test
    public void accountShouldNotBeCreatedWithoutValidEmail() {

        System.setProperty("webdriver.gecko.driver", "src/test/resources/geckodriver.exe");
        WebDriver driver = new FirefoxDriver();
        driver.get("https://www.sharelane.com/cgi-bin/register.py?page=1&zip_code=11111");
        driver.findElement(By.name("first_name")).sendKeys("");
        driver.findElement(By.name("last_name")).sendKeys("Kom");
        driver.findElement(By.name("email")).sendKeys("yulion28");
        driver.findElement(By.name("password1")).sendKeys("1111");
        driver.findElement(By.name("password2")).sendKeys("1111");
        driver.findElement(By.cssSelector("[value=Register]")).click();
        String error =  driver.findElement(By.cssSelector("[class=error_message]")).getText();
        assertEquals(
                error, "Oops, error on page. Some of your fields have invalid data or email was previously used",
                "Error text is not correct"
        );
        driver.quit();
    }

}