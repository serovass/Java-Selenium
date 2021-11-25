package pages;
import org.openqa.selenium.By;


public class TicketPageSearch extends AbstractPage {

    public void OpenTicketPage(String summary, String ticketId) {
        driver.findElement(By.xpath("//*[@id=\"search_query\"]")).sendKeys(summary);
        driver.findElement(By.xpath("//*[@id=\"searchform\"]/div/div/button")).click();
        driver.findElement(By.xpath("//*[@id=\"ticketTable\"]/thead/tr/th[4]")).click();
        driver.findElement(By.xpath("//*[@id=\"ticketTable\"]/thead/tr/th[4]")).click();
        driver.findElement(By.cssSelector("a[href='/tickets/" + ticketId + "/']")).click();
    }
}
