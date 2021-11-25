import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.*;

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

        //Создаем New Ticket
        WebElement newTicket = driver.findElement(By.xpath("//*[@id=\"wrapper\"]/ul/li[2]/a"));
        newTicket.click();
        CreatingTicketsPage creatingTicket = new CreatingTicketsPage();
        creatingTicket.newTicket
                (System.getProperty("summary"),
                System.getProperty("issueDescription"),
                System.getProperty("eMailAddress"));

        //Логинимся
        driver.findElement(By.xpath("//*[@id=\"userDropdown\"]")).click();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(System.getProperty("user"), System.getProperty("password"));

        //находим и открываем созданный Ticket
        driver.findElement(By.xpath("//*[@id=\"search_query\"]")).sendKeys(System.getProperty("summary"));
        driver.findElement(By.xpath("//*[@id=\"searchform\"]/div/div/button")).click();
        driver.findElement(By.xpath("//*[@id=\"ticketTable\"]/thead/tr/th[4]")).click();
        driver.findElement(By.xpath("//*[@id=\"ticketTable\"]/thead/tr/th[4]")).click();
        driver.findElement(By.xpath("//*[@id=\"ticketTable\"]/tbody/tr[1]/td[2]/div")).click();

        //сравниваем информацию в Ticket
        pages.TicketPage ticketPage = new TicketPage();
        Assert.assertEquals(ticketPage.getEMailAddress(), System.getProperty("eMailAddress"));
        Assert.assertEquals(ticketPage.getIssueDescription(), System.getProperty("issueDescription"));
        Assert.assertTrue(ticketPage.getSummaryQueue().contains(System.getProperty("queue")));
        Assert.assertTrue(ticketPage.getSummaryQueue().contains(System.getProperty("summary")));

      //Закрываем текущее окно браузера
        driver.close();
    }
}
