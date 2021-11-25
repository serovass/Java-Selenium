package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;


public class CreatingTicketsPage extends AbstractPage {

    private final WebElement queue
            = driver.findElement(By.xpath("//*[@id=\"id_queue\"]"));
    private final WebElement queueElem
            = driver.findElement(By.xpath("//*[@id=\"id_queue\"]/option[2]"));
    private final WebElement summary
            = driver.findElement(By.xpath("//*[@id=\"id_title\"]"));
    private final WebElement issueDescription
            = driver.findElement(By.xpath("//*[@id=\"id_body\"]"));
    private final WebElement eMailAddress
            = driver.findElement(By.xpath("//*[@id=\"id_submitter_email\"]"));
    private final WebElement submitTicket
            = driver.findElement(By.xpath("//*[@id=\"content-wrapper\"]/div/div/div/div[2]/form/button"));

    public void newTicket(String summary, String issueDescription, String eMailAddress) {
        queue.click();
        queueElem.click();//Queue: Django Helpdesk
        this.summary.sendKeys(summary);
        this.issueDescription.sendKeys(issueDescription);
        this.eMailAddress.sendKeys(eMailAddress);
        submitTicket.click();
    }
}
