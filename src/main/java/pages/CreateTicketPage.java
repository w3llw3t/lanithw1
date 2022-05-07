package pages;

import io.qameta.allure.Step;
import models.Ticket;
import org.openqa.selenium.WebElement;

/** Страница создания тикета */
public class CreateTicketPage extends HelpdeskBasePage {

    // todo: добавить элементам локтаоры через @FindBy

    private WebElement selectQueue;

    private WebElement inputProblem;

    // todo: добавить остальные поля формы

    private WebElement submitTicketButton;

    // todo: проинициализировать элементы

    @Step("Создать тикет")
    public CreateTicketPage createTicket(Ticket ticket) {
        setInputProblem(ticket.getTitle());
        // todo: заполнить остальные поля формы
        clickOnSubmitButton();
        return this;
    }

    @Step("Ввести имя проблемы: {text}")
    public void setInputProblem(String text) {
        inputProblem.sendKeys(text);
    }

    @Step("Нажать на кнопку создания тикета")
    public void clickOnSubmitButton() {
        submitTicketButton.click();
    }
}
