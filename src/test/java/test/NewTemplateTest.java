package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import page.MainPage;
import page.TemplateListPage;
import step.LoginStep;
import step.TemplateCreationStep;
import java.util.Random;


public class NewTemplateTest {
    private WebDriver driver;
    private LoginStep loginStep;
    final Random random = new Random();
    String rand = String.valueOf(random.nextInt());
    private String templateName = "IstominPatternTest " + rand;

    @BeforeMethod
    public void start() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://qa-lab.relex-dev.ru:8090/");
        loginStep = new LoginStep(driver);
    }

    @Test
    public void NewTemplateTest() throws InterruptedException {
        MainPage mainPage = loginStep.enterLoginAndPassword("p_petrov", "12345678");
        TemplateListPage templateListPage = mainPage.pressTemplateListButton();
        TemplateCreationStep templateCreationStep = templateListPage.pressCreationButton();
        templateListPage = templateCreationStep.setNewTemplateData(templateName, "Описание описания",
                "1", "1", "1", "1", "Ну какой вопрос тебе задать?");
        templateListPage.checkThatTemplateIsCreated(templateName);
    }

    @AfterMethod
    public void stop() {
        driver.quit();
        driver = null;
    }
}
