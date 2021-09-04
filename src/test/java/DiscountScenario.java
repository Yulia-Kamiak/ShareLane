import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.internal.collections.Pair;

import java.util.concurrent.TimeUnit;

public class DiscountScenario {

    @Test
    public void scenarioWithoutDiscount() {

        System.setProperty("webdriver.gecko.driver", "src/test/resources/geckodriver.exe");
        WebDriver driver = new FirefoxDriver();
        Pair<String, String> emailPasswordPair = register(driver);
        driver.get("https://www.sharelane.com/cgi-bin/main.py");
        driver.findElement(By.name("email")).sendKeys(emailPasswordPair.first());
        driver.findElement(By.name("password")).sendKeys(emailPasswordPair.second());
        driver.findElement(By.cssSelector("[value=Login]")).click();
        driver.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);
        addBook(driver);
        driver.get("https://www.sharelane.com/cgi-bin/shopping_cart.py");
        Assert.assertEquals(driver.findElement(By.cssSelector("[name=q]")).getAttribute("value"), "1");
        driver.findElement(By.cssSelector("[name=q]")).clear();
        driver.findElement(By.cssSelector("[name=q]")).sendKeys("10");
        driver.findElement(By.cssSelector("[value=Update]")).click();
        String CartUpdatedMessage = driver.findElement(By.className("confirmation_message")).getText();
        Assert.assertEquals(CartUpdatedMessage,"Cart Updated");
        driver.quit();
    }


    @Test
    public void discountFrom0To19() {

        System.setProperty("webdriver.gecko.driver", "src/test/resources/geckodriver.exe");
        WebDriver driver = new FirefoxDriver();
        Pair<String, String> emailPasswordPair = register(driver);
        driver.get("https://www.sharelane.com/cgi-bin/main.py");
        driver.findElement(By.name("email")).sendKeys(emailPasswordPair.first());
        driver.findElement(By.name("password")).sendKeys(emailPasswordPair.second());
        driver.findElement(By.cssSelector("[value=Login]")).click();
        driver.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);
        addBook(driver);
        driver.get("https://www.sharelane.com/cgi-bin/shopping_cart.py");
        Assert.assertEquals(driver.findElement(By.cssSelector("[name=q]")).getAttribute("value"), "1");
        driver.findElement(By.cssSelector("[name=q]")).clear();
        driver.findElement(By.cssSelector("[name=q]")).sendKeys("49");
        driver.findElement(By.cssSelector("[value=Update]")).click();
        String CartUpdatedMessage = driver.findElement(By.className("confirmation_message")).getText();
        Assert.assertEquals(CartUpdatedMessage,"Cart Updated");
        String discount = driver.findElement(By.xpath("/html/body/center/table/tbody/tr[6]/td/table/tbody/tr[2]/td[5]/p/b")).getText();
        Assert.assertEquals(discount,"2");
        driver.quit();

    }


    @Test
    public void discountFrom50To99() {

        System.setProperty("webdriver.gecko.driver", "src/test/resources/geckodriver.exe");
        WebDriver driver = new FirefoxDriver();
        Pair<String, String> emailPasswordPair = register(driver);
        driver.get("https://www.sharelane.com/cgi-bin/main.py");
        driver.findElement(By.name("email")).sendKeys(emailPasswordPair.first());
        driver.findElement(By.name("password")).sendKeys(emailPasswordPair.second());
        driver.findElement(By.cssSelector("[value=Login]")).click();
        driver.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);
        addBook(driver);
        driver.get("https://www.sharelane.com/cgi-bin/shopping_cart.py");
        Assert.assertEquals(driver.findElement(By.cssSelector("[name=q]")).getAttribute("value"), "1");
        driver.findElement(By.cssSelector("[name=q]")).clear();
        driver.findElement(By.cssSelector("[name=q]")).sendKeys("99");
        driver.findElement(By.cssSelector("[value=Update]")).click();
        String CartUpdatedMessage = driver.findElement(By.className("confirmation_message")).getText();
        Assert.assertEquals(CartUpdatedMessage,"Cart Updated");
        String discount = driver.findElement(By.xpath("/html/body/center/table/tbody/tr[6]/td/table/tbody/tr[2]/td[5]/p/b")).getText();
        Assert.assertEquals(discount,"3");
        driver.quit();

    }


    @Test
    public void discountFrom100To499() {

        System.setProperty("webdriver.gecko.driver", "src/test/resources/geckodriver.exe");
        WebDriver driver = new FirefoxDriver();
        Pair<String, String> emailPasswordPair = register(driver);
        driver.get("https://www.sharelane.com/cgi-bin/main.py");
        driver.findElement(By.name("email")).sendKeys(emailPasswordPair.first());
        driver.findElement(By.name("password")).sendKeys(emailPasswordPair.second());
        driver.findElement(By.cssSelector("[value=Login]")).click();
        driver.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);
        addBook(driver);
        driver.get("https://www.sharelane.com/cgi-bin/shopping_cart.py");
        Assert.assertEquals(driver.findElement(By.cssSelector("[name=q]")).getAttribute("value"), "1");
        driver.findElement(By.cssSelector("[name=q]")).clear();
        driver.findElement(By.cssSelector("[name=q]")).sendKeys("100");
        driver.findElement(By.cssSelector("[value=Update]")).click();
        String CartUpdatedMessage = driver.findElement(By.className("confirmation_message")).getText();
        Assert.assertEquals(CartUpdatedMessage,"Cart Updated");
        String discount = driver.findElement(By.xpath("/html/body/center/table/tbody/tr[6]/td/table/tbody/tr[2]/td[5]/p/b")).getText();
        Assert.assertEquals(discount,"4");
        driver.quit();

    }


    @Test
    public void discountFrom500To999() {

        System.setProperty("webdriver.gecko.driver", "src/test/resources/geckodriver.exe");
        WebDriver driver = new FirefoxDriver();
        Pair<String, String> emailPasswordPair = register(driver);
        driver.get("https://www.sharelane.com/cgi-bin/main.py");
        driver.findElement(By.name("email")).sendKeys(emailPasswordPair.first());
        driver.findElement(By.name("password")).sendKeys(emailPasswordPair.second());
        driver.findElement(By.cssSelector("[value=Login]")).click();
        driver.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);
        addBook(driver);
        driver.get("https://www.sharelane.com/cgi-bin/shopping_cart.py");
        Assert.assertEquals(driver.findElement(By.cssSelector("[name=q]")).getAttribute("value"), "1");
        driver.findElement(By.cssSelector("[name=q]")).clear();
        driver.findElement(By.cssSelector("[name=q]")).sendKeys("999");
        driver.findElement(By.cssSelector("[value=Update]")).click();
        String CartUpdatedMessage = driver.findElement(By.className("confirmation_message")).getText();
        Assert.assertEquals(CartUpdatedMessage,"Cart Updated");
        String discount = driver.findElement(By.xpath("/html/body/center/table/tbody/tr[6]/td/table/tbody/tr[2]/td[5]/p/b")).getText();
        Assert.assertEquals(discount,"5");
        driver.quit();

    }


    @Test
    public void discountFrom1000To4999() {

        System.setProperty("webdriver.gecko.driver", "src/test/resources/geckodriver.exe");
        WebDriver driver = new FirefoxDriver();
        Pair<String, String> emailPasswordPair = register(driver);
        driver.get("https://www.sharelane.com/cgi-bin/main.py");
        driver.findElement(By.name("email")).sendKeys(emailPasswordPair.first());
        driver.findElement(By.name("password")).sendKeys(emailPasswordPair.second());
        driver.findElement(By.cssSelector("[value=Login]")).click();
        driver.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);
        addBook(driver);
        driver.get("https://www.sharelane.com/cgi-bin/shopping_cart.py");
        Assert.assertEquals(driver.findElement(By.cssSelector("[name=q]")).getAttribute("value"), "1");
        driver.findElement(By.cssSelector("[name=q]")).clear();
        driver.findElement(By.cssSelector("[name=q]")).sendKeys("4999");
        driver.findElement(By.cssSelector("[value=Update]")).click();
        String CartUpdatedMessage = driver.findElement(By.className("confirmation_message")).getText();
        Assert.assertEquals(CartUpdatedMessage,"Cart Updated");
        String discount = driver.findElement(By.xpath("/html/body/center/table/tbody/tr[6]/td/table/tbody/tr[2]/td[5]/p/b")).getText();
        Assert.assertEquals(discount,"6");
        driver.quit();

    }


    @Test
    public void discountFrom5000To9999() {

        System.setProperty("webdriver.gecko.driver", "src/test/resources/geckodriver.exe");
        WebDriver driver = new FirefoxDriver();
        Pair<String, String> emailPasswordPair = register(driver);
        driver.get("https://www.sharelane.com/cgi-bin/main.py");
        driver.findElement(By.name("email")).sendKeys(emailPasswordPair.first());
        driver.findElement(By.name("password")).sendKeys(emailPasswordPair.second());
        driver.findElement(By.cssSelector("[value=Login]")).click();
        driver.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);
        addBook(driver);
        driver.get("https://www.sharelane.com/cgi-bin/shopping_cart.py");
        Assert.assertEquals(driver.findElement(By.cssSelector("[name=q]")).getAttribute("value"), "1");
        driver.findElement(By.cssSelector("[name=q]")).clear();
        driver.findElement(By.cssSelector("[name=q]")).sendKeys("5000");
        driver.findElement(By.cssSelector("[value=Update]")).click();
        String CartUpdatedMessage = driver.findElement(By.className("confirmation_message")).getText();
        Assert.assertEquals(CartUpdatedMessage,"Cart Updated");
        String discount = driver.findElement(By.xpath("/html/body/center/table/tbody/tr[6]/td/table/tbody/tr[2]/td[5]/p/b")).getText();
        Assert.assertEquals(discount,"7");
        driver.quit();

    }


    @Test
    public void discount10000AndMore() {

        System.setProperty("webdriver.gecko.driver", "src/test/resources/geckodriver.exe");
        WebDriver driver = new FirefoxDriver();
        Pair<String, String> emailPasswordPair = register(driver);
        driver.get("https://www.sharelane.com/cgi-bin/main.py");
        driver.findElement(By.name("email")).sendKeys(emailPasswordPair.first());
        driver.findElement(By.name("password")).sendKeys(emailPasswordPair.second());
        driver.findElement(By.cssSelector("[value=Login]")).click();
        driver.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);
        addBook(driver);
        driver.get("https://www.sharelane.com/cgi-bin/shopping_cart.py");
        Assert.assertEquals(driver.findElement(By.cssSelector("[name=q]")).getAttribute("value"), "1");
        driver.findElement(By.cssSelector("[name=q]")).clear();
        driver.findElement(By.cssSelector("[name=q]")).sendKeys("10000");
        driver.findElement(By.cssSelector("[value=Update]")).click();
        String CartUpdatedMessage = driver.findElement(By.className("confirmation_message")).getText();
        Assert.assertEquals(CartUpdatedMessage,"Cart Updated");
        String discount = driver.findElement(By.xpath("/html/body/center/table/tbody/tr[6]/td/table/tbody/tr[2]/td[5]/p/b")).getText();
        Assert.assertEquals(discount,"8");
        driver.quit();

    }

    private Pair<String, String> register(WebDriver driver) {

        driver.get("https://www.sharelane.com/cgi-bin/register.py?page=1&zip_code=11111");
        driver.findElement(By.name("first_name")).sendKeys("Yul");
        driver.findElement(By.name("last_name")).sendKeys("Kom");
        driver.findElement(By.name("email")).sendKeys("yulion28@mail.ru");
        driver.findElement(By.name("password1")).sendKeys("1111");
        driver.findElement(By.name("password2")).sendKeys("1111");
        driver.findElement(By.cssSelector("[value=Register]")).click();
        String email = driver.findElement(By.xpath("/html/body/center/table/tbody/tr[6]/td/table/tbody/tr[4]/td/table/tbody/tr[1]/td[2]/b")).getText();
        String password = driver.findElement(By.xpath("/html/body/center/table/tbody/tr[6]/td/table/tbody/tr[4]/td/table/tbody/tr[2]/td[2]")).getText();

        return new Pair(email, password);
    }


    private void addBook(WebDriver driver) {

        driver.findElement(By.xpath("/html/body/center/table/tbody/tr[1]/td/table/tbody/tr/td[1]/a/img")).click();
        driver.findElement(By.xpath("/html/body/center/table/tbody/tr[5]/td/table/tbody/tr/td[2]/table/tbody/tr[3]/td/a")).click();
        driver.findElement(By.xpath("/html/body/center/table/tbody/tr[5]/td/table/tbody/tr/td[2]/p[2]/a/img")).click();

    }
}
