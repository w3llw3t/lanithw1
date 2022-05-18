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
    private WebElement selectQueue;
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
    private String[] date_dd_MM_yyyy;

    // todo: проинициализировать элементы

    @Step("Создать тикет")
    public void createTicket(Ticket ticket) {
        selectQueue.click();
        setSelectQueue();
        inputProblem.click();
        setInputProblem(ticket.getTitle());
        inputDescription.click();
        setInputDescription(ticket.getDescription());
        selectPriority.click();
        setSelectPriority();
        dueDate.click();
        setDueDate();
        email.click();
        setEmail(ticket.getSubmitter_EMail());
        // todo: заполнить остальные поля формы
        clickOnSubmitButton();
    }

    @Step
    public void setSelectQueue() {
        Select queue = new Select(selectQueue);
        queue.getOptions().forEach(option -> {
            System.out.println("Value = " + option.getAttribute("value") + ";Text = " + option.getText());
        });
        queue.selectByVisibleText("Django Helpdesk");
    }

    @Step("Ввести имя проблемы: {text}")
    public void setInputProblem(String text) {
        inputProblem.sendKeys(text);
    }
    @Step("Ввести описание проблемы: {textD}")
    public void setInputDescription(String textD) {
        inputDescription.sendKeys(textD);
    }

    @Step("Выбрать приоритет")
    public void setSelectPriority() {
        Select priority = new Select(selectPriority);
        priority.getOptions().forEach(option -> {
            System.out.println("Value = " + option.getAttribute("value") + ";Text = " + option.getText());
        });
        priority.selectByVisibleText("3. Normal");
    }

    @Step("Выбрать дату")
    public void setDueDate() {
        List<WebElement> list_AllMonthToBook = driver.findElements(By.xpath("//div[@id='datetimepicker_dateview']//table//tbody//td[not(contains(@class,'k-other-month'))]"));
        list_AllMonthToBook.get(Integer.parseInt(date_dd_MM_yyyy[1])-1).click();
        
        List<WebElement> list_AllDateToBook = driver.findElements(By.xpath("//div[@id='datetimepicker_dateview']//table//tbody//td[not(contains(@class,'k-other-month'))]"));
        list_AllDateToBook.get(Integer.parseInt(date_dd_MM_yyyy[0])-1).click();

    }

    @Step("Ввести mail")
    public void setEmail(String mail) {
        email.sendKeys(mail);
    }

    @Step("Нажать на кнопку создания тикета")
    public void clickOnSubmitButton() {
        submitTicketButton.click();
    }
}
