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


public class NewTemplateTest {
    private WebDriver driver;
    private LoginStep loginStep;

    @BeforeMethod
    public void start() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://qa-lab.relex-dev.ru:8090/");
        loginStep = new LoginStep(driver);
    }

    @Test
    public void NewTemplateTest() {
        MainPage mainPage = loginStep.enterLoginAndPassword("p_petrov", "12345678");
        TemplateListPage templateListPage = mainPage.pressTemplateListButton();
        TemplateCreationStep templateCreationStep = templateListPage.pressCreationButton();
        templateListPage = templateCreationStep.setNewTemplateData("IstominPatternTest", "Описание описания",
                "20 апреля 2021 г.", "27 апреля 2021 г.", "7", "1", "5", "7",
                "Ну какой вопрос тебе задать?");
        templateListPage.checkThatPageIsLoaded("Список шаблонов опросов"); //проверка на то, что опрос создан
        //страница со списком шаблонов открывается только в случае успешного создания шаблона
    }

    @AfterMethod
    public void stop() {
        driver.quit();
        driver = null;
    }
}
