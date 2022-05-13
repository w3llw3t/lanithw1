package web;

import elements.MainMenu;
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
import pages.LoginPage;


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
        MainMenu mainMenu = new MainMenu(driver);
        CreateTicketPage createTicketPage = new CreateTicketPage();
        LoginPage loginPage = new LoginPage();

        driver.get("https://at-sandbox.workbench.lanit.ru/"); //предусловие
        mainMenu.clickOnNewTicketButton(); // шаг 1
        ticket = buildNewTicket(); // шаг 2
        mainMenu.clickOnLogInButton(); //шаг 3
        loginPage.login("admin", "adminat"); // шаг 4

        // ...
    }

    private Ticket buildNewTicket() {
        // todo: заполнить поля тикета
        Ticket ticket = new Ticket();
        ticket.setQueue(2);
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
