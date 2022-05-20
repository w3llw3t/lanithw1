package pages;

import io.qameta.allure.Step;
import models.Ticket;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.time.LocalDateTime;
import java.util.List;

/** Страница создания тикета */
public class CreateTicketPage extends HelpdeskBasePage {

    // todo: добавить элементам локтаоры через @FindBy
    // todo: добавить остальные поля формы
    @FindBy(xpath = "//select[@name=\"queue\"]")
    private WebElement queue;
    @FindBy(xpath = "//input[@name=\"title\"]")
    private WebElement inputProblem;
    @FindBy(xpath = "//textarea[@name=\"body\"]")
    private WebElement inputDescription;
    @FindBy(id = "id_priority")
    private WebElement selectPriority;
    @FindBy(id = "id_due_date")
    private WebElement dueDate;
    @FindBy(id = "id_submitter_email")
    private WebElement email;
    @FindBy(xpath = "//button[@type=\"submit\"]")
    private WebElement submitTicketButton;

    // todo: проинициализировать элементы

    @Step("Создать тикет")
    public void createTicket(Ticket ticket) {
        setSelectQueue();
        setInputProblem(ticket.getTitle());
        setInputDescription(ticket.getDescription());
        setSelectPriority();
        setDueDate(ticket.getDue_date());
        setEmail(ticket.getSubmitter_EMail());
        // todo: заполнить остальные поля формы
        clickOnSubmitButton();
    }

    @Step
    public void setSelectQueue() {
        Select queue = new Select(driver.findElement(By.xpath("//select[@name=\"queue\"]")));
        queue.getOptions().forEach(option -> {
            System.out.println("Value = " + option.getAttribute("value") + ";Text = " + option.getText());
        });
        queue.selectByVisibleText("Django Helpdesk");
    }

    @Step("Ввести имя проблемы: {text}")
    public void setInputProblem(String text) {
        WebElement problem = driver.findElement(By.xpath("//input[@name=\"title\"]"));
        problem.sendKeys(text);
    }
    @Step("Ввести описание проблемы: {textD}")
    public void setInputDescription(String textD) {
        WebElement description = driver.findElement(By.xpath("//textarea[@name=\"body\"]"));
        description.sendKeys(textD);
    }

    @Step("Выбрать приоритет")
    public void setSelectPriority() {
        Select priority = new Select(driver.findElement(By.id("id_priority")));
        priority.getOptions().forEach(option -> {
            System.out.println("Value = " + option.getAttribute("value") + ";Text = " + option.getText());
        });
        priority.selectByVisibleText("3. Normal");
    }

    @Step("Выбрать дату")
    public void setDueDate(String day) {
        WebElement date = driver.findElement(By.id("id_due_date"));
        date.sendKeys(day);

    }

    @Step("Ввести mail")
    public void setEmail(String mail) {
        WebElement email = driver.findElement(By.xpath("//button[@type=\"submit\"]"));
        email.sendKeys(mail);
    }

    @Step("Нажать на кнопку создания тикета")
    public void clickOnSubmitButton() {
        WebElement button = driver.findElement(By.xpath("//button[@type=\"submit\"]"));
        button.click();
    }
}
