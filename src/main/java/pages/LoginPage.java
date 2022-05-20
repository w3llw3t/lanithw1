package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/** Страница логина */
public class LoginPage extends HelpdeskBasePage {

    // поиск элемента через xpath
    @FindBy(xpath = "//*[id='username']")
    private WebElement username;

    // поиск элемента по id
    @FindBy(id = "password")
    private WebElement password;

    // поиск элемента через xpath
    @FindBy(xpath = "//input[@type=\"submit\"]")
    private WebElement loginButton;

    public LoginPage() {
        PageFactory.initElements(driver, this);
    }

    /**
     * Авторизация пользователя
     *  @param username     логин пользователя
     * @param password пароль пользователя
     */
    @Step("Авторизация пользователя")
    public void login(String username, String password) {
        setUsername(username);
        setPassword(password);
        clickOnLoginButton();
    }

    @Step("Ввести логин {user}")
    private void setUsername(String username) {
        WebElement user = driver.findElement(By.id("username"));
        user.sendKeys(username);
    }

    @Step("Ввести пароль")
    private void setPassword(String password) {
        WebElement pass = driver.findElement(By.id("password"));
        pass.sendKeys(password);
    }

    @Step("Нажать кнопку авторизации")
    private void clickOnLoginButton() {
        WebElement button = driver.findElement(By.xpath("//input[@type=\"submit\"]"));
        button.click();
    }
}
