package web;

import io.qameta.allure.Step;
import models.Ticket;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.AbstractPage;

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
        ticket = buildNewTicket();

        // ...
    }

    private Ticket buildNewTicket() {
        // todo: заполнить поля тикета
        Ticket ticket = new Ticket();
        ticket.setTitle("Test");
        ticket.setQueue(1);
        ticket.setStatus(1);
        ticket.setAssigned_to("admin");
        ticket.setPriority(1);
        ticket.setDue_date(new SimpleDateFormat("yyyy-MM-dd").format(Calendar.getInstance().getTime()));
        ticket.setCreated(new SimpleDateFormat("yyyy-MM-dd'T'hh:mm").format(Calendar.getInstance().getTime()));
        ticket.setModified(new SimpleDateFormat("yyyy-MM-dd'T'hh:mm").format(Calendar.getInstance().getTime()));
        ticket.setSecret_key("key");
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
