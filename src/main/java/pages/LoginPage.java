package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends AbstractPage {
    public WebDriver driver;

    public LoginPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver; }

    //Поиск элемента через аннотацию
    @FindBy(id = "username")
    private WebElement user;

    @FindBy(id = "password")
    private WebElement password;

    @FindBy(xpath = "//*[@id=\"content-wrapper\"]/div/div/div/div[2]/form/div[3]/div/label/input")
    private WebElement rememberPassword;

    @FindBy(xpath = "//*[@id=\"content-wrapper\"]/div/div/div/div[2]/form/input[1]")
    private WebElement login;

    public void login(String user, String password) {
        this.user.sendKeys(user);
        this.password.sendKeys(password);
        rememberPassword.click();
        login.click();
    }
}
