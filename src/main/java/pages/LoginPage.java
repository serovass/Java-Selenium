package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends AbstractPage {

    // Обычный поиск элемента
    private WebElement user = driver.findElement(By.id("username"));

     //Поиск элемента через аннотацию
    @FindBy(id = "password")
    private WebElement password;
//    private WebElement password = driver.findElement(By.id("password"));

    // Поиск элемента через xpath
    private WebElement rememberPassword
            = driver.findElement(By.xpath
            ("//*[@id=\"content-wrapper\"]/div/div/div/div[2]/form/div[3]/div/label/input"));

    private WebElement login
            = driver.findElement(By.xpath
            ("//*[@id=\"content-wrapper\"]/div/div/div/div[2]/form/input[1]"));

    public void login(String user, String password) {
        this.user.sendKeys(user);
        this.password.sendKeys(password);
        rememberPassword.click();
        login.click();
    }
}
