import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.AbstractPage;
import pages.LoginPage;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class HelpdeskUITest {

    private WebDriver driver;

    @Before
    public void setup() throws IOException {
        // Читаем конфигурационный файл в System.properties
        System.getProperties().load(ClassLoader.getSystemResourceAsStream("config.properties"));
        System.getProperties().load(ClassLoader.getSystemResourceAsStream("user.properties"));
        // Создание экземпляра драйвера
        driver = new ChromeDriver();
        // Устанавливаем размер окна браузера, как максимально возможный
        driver.manage().window().maximize();
        // Установим время ожидания для поиска элементов
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        // Установить созданный драйвер для поиска в веб-страницах
        AbstractPage.setDriver(driver);
    }

    @Test
    public void createTicketTest() {
        driver.get(System.getProperty("site.url"));

        //Создание New Ticket
        WebElement element = driver.findElement(By.xpath("//*[@id=\"wrapper\"]/ul/li[2]/a"));
        element.click();
        //Queue
        element = driver.findElement(By.xpath("//*[@id=\"id_queue\"]"));
        element.sendKeys(Keys.ENTER);
        element = driver.findElement(By.xpath("//*[@id=\"id_queue\"]/option[2]"));
        element.click();
        //Summary of the problem
        element = driver.findElement(By.xpath("//*[@id=\"id_title\"]"));
        element.sendKeys("Big problem");
        //Description of your issue
        element = driver.findElement(By.xpath("//*[@id=\"id_body\"]"));
        element.sendKeys("No comments");
        //Priority
        element = driver.findElement(By.xpath("//*[@id=\"id_priority\"]"));
        element.click();
        element = driver.findElement(By.xpath("//*[@id=\"id_priority\"]/option[1]"));
        element.click();
        //Due on
        element = driver.findElement(By.xpath("//*[@id=\"id_due_date\"]"));
        element.sendKeys(Keys.ENTER);
        //Your E-Mail Address
        element = driver.findElement(By.xpath("//*[@id=\"id_submitter_email\"]"));
        element.sendKeys("email@gmail.com");
        //Submit Ticket
        element = driver.findElement(By.xpath("//*[@id=\"content-wrapper\"]/div/div/div/div[2]/form/button"));
        element.click();

        //Log in
        driver.findElement(By.xpath("//*[@id=\"userDropdown\"]")).click();
        LoginPage loginPage = new LoginPage();
        loginPage.login(System.getProperty("user"), System.getProperty("password"));

//        Закрываем текущее окно браузера
        driver.close();
    }
}
