package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class TicketPage extends AbstractPage {

    public String getSummaryQueue() {
        WebElement summaryQueue
                = driver.findElement(By.xpath("//*[@id=\"content-wrapper\"]/div/div[1]/div/div/table/thead/tr/th"));
        return summaryQueue.getText();
    }

    public String getIssueDescription() {
        WebElement issueDescription
                = driver.findElement(By.xpath("//*[@id=\"ticket-description\"]/p"));
        return issueDescription.getText();
    }

    public String getEMailAddress() {
        WebElement eMailAddress
                = driver.findElement(By.xpath("//*[@id=\"content-wrapper\"]/div/div[1]/div/div/table/tbody/tr[2]/td[2]"));
        return eMailAddress.getText();
    }
}
