package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;


public class TicketsPage extends AbstractPage {

    private WebElement queue = driver.findElement(By.xpath("//*[@id=\"id_queue\"]"));
    private WebElement queueElem = driver.findElement(By.xpath("//*[@id=\"id_queue\"]/option[2]"));
    private WebElement summary = driver.findElement(By.xpath("//*[@id=\"id_title\"]"));
    private WebElement issueDescription = driver.findElement(By.xpath("//*[@id=\"id_body\"]"));
    private WebElement priority = driver.findElement(By.xpath("//*[@id=\"id_priority\"]"));
    private WebElement priorityCritical = driver.findElement(By.xpath("//*[@id=\"id_priority\"]/option[1]"));
    private WebElement dueOn = driver.findElement(By.xpath("//*[@id=\"id_due_date\"]"));
    private WebElement eMailAddress = driver.findElement(By.xpath("//*[@id=\"id_submitter_email\"]"));
    private WebElement submitTicket = driver.findElement(By.xpath("//*[@id=\"content-wrapper\"]/div/div/div/div[2]/form/button"));

    public void newTicket(String summary, String issueDescription, String eMailAddress) {
        queue.sendKeys(Keys.ENTER);
        queueElem.click();
        this.summary.sendKeys(summary);
        this.issueDescription.sendKeys(issueDescription);
        priority.click();
        priorityCritical.click();
        dueOn.sendKeys(Keys.ENTER);
        this.eMailAddress.sendKeys(eMailAddress);
        submitTicket.click();
    }
}
