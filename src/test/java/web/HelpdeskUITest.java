package web;

import io.qameta.allure.Step;
import models.Ticket;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.AbstractPage;
import pages.CreateTicketPage;


import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.concurrent.TimeUnit;

public class HelpdeskUITest {

    private WebDriver driver;
    private Ticket ticket;

    @BeforeClass
    public void setup() throws IOException {
        loadProperties();
        setupDriver();
    }

    @Step("Загрузить конфигурацилнные файлы")
    private void loadProperties() throws IOException {
        // Читаем конфигурационные файлы в System.properties
        System.getProperties().load(ClassLoader.getSystemResourceAsStream("config.properties"));
        System.getProperties().load(ClassLoader.getSystemResourceAsStream("user.properties"));
    }

    @Step("Создать экземпляр драйвера")
    private void setupDriver() {
        // Создание экземпляра драйвера
        driver = new ChromeDriver();
        // Устанавливаем размер окна браузера, как максимально возможный
        driver.manage().window().maximize();
        // Установим время ожидания для поиска элементов
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        // Установить созданный драйвер для поиска в веб-страницах
        AbstractPage.setDriver(driver);
    }

    @Test
    public void createTicketTest() {
        // todo: шаги тест-кейса

        // ...
        driver.get("https://at-sandbox.workbench.lanit.ru/");
        buildNewTicket();

        WebElement element = driver.findElement(By.xpath("//a[@href=\"/tickets/submit/\"]"));
        element.click();
        Select queue = new Select(driver.findElement(By.name("queue")));
        queue.getOptions().forEach(option -> {
            System.out.println("Value = " + option.getAttribute("value") + ";Text = " + option.getText());
        });
        queue.selectByVisibleText("Django Helpdesk");
        WebElement title = driver.findElement(By.xpath("//input[@name=\"title\"]"));
        title.sendKeys("123");
        WebElement inputIssue = driver.findElement(By.xpath("//textarea[@id=\"id_body\"]"));
        inputIssue.click();
        inputIssue.sendKeys("12345");
        Select priority = new Select(driver.findElement(By.name("priority")));
        priority.getOptions().forEach(option -> {
            System.out.println("Value = " + option.getAttribute("value") + ";Text = " + option.getText());
                });
        priority.selectByVisibleText("3. Normal");
        ticket = buildNewTicket();
        // ...
    }

    private Ticket buildNewTicket() {
        // todo: заполнить поля тикета
        Ticket ticket = new Ticket();
        ticket.setQueue(1);
        ticket.setTitle("TestUi");
        ticket.setDescription("12345");
        ticket.setPriority(3);
        ticket.setDue_date(new SimpleDateFormat("yyyy-MM-dd").format(Calendar.getInstance().getTime()));
        ticket.setSubmitter_email("nicepal223@gmail.com");
        return ticket;
    }

    @AfterTest
    public void close() {
        if (driver != null) {
            // Закрываем одно текущее окно браузера
            driver.close();
            // Закрываем все открытые окна браузера, завершаем работу браузера, освобождаем ресурсы
            driver.quit();
        }
    }
}
