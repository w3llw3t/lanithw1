package pages;

import io.qameta.allure.Step;
import models.Ticket;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

/** Страница отдельного тикета (авторизированный пользователь) */
public class TicketPage extends HelpdeskBasePage {

    /* Верстка страницы может измениться, поэтому для таблиц вместо индексов строк и столбцов лучше использовать
       более универсальные локаторы, например поиск по тексту + parent, following-sibling и другие.

       Текст тоже может измениться, но в этом случае элемент не будет найден и тест упадет,
       а ошибку можно будет легко локализовать и исправить.
       В случае изменений ячеек таблицы, локатор будет продолжать работать, но будет указывать на другой элемент,
       поведение теста при этом изменится непредсказуемым образом и ошибку будет сложно найти. */
    private WebElement dueDate = driver.findElement(By.xpath("//th[text()='Due Date']/following-sibling::td[1]"));

    // todo: проинициализировать элементы через driver.findElement

    private WebElement title = driver.findElement(By.xpath("//input[@name=\"title\"]"));
    private WebElement queue = driver.findElement(By.name("queue"));
    private WebElement email = driver.findElement(By.name("submitter_email"));
    private WebElement priority = driver.findElement(By.name("priority"));
    private WebElement description = driver.findElement(By.xpath("//textarea[@id=\"id_body\"]"));

    @Step("Проверить значение полей на странице тикета")
    public void checkTicket(Ticket ticket) {
        // todo: добавить реализацию метода

    }
}
