package page;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import page.TemplateListPage;

public class TemplateCreationPage {
    private WebDriver driver;
    private By hdr = By.xpath("//h1");
    String del = Keys.chord(Keys.CONTROL, "a") + Keys.DELETE;
    private By inptName = By.cssSelector("input[placeholder='Название']");
    private By selfEsteem = By.cssSelector(".mat-checkbox-label");
    private By publType = By.xpath("//div/span/span");
    private By openPubl = By.xpath("//mat-option[3]/span");
    private By inptDescr = By.xpath("//textarea");
    private By inptPeriod = By.cssSelector("input[placeholder='Период']");
    private By inptAnswerStart = By.cssSelector("input[placeholder='Срок начала ответов (через ... дней)']");
    private By inptAnswerEnd = By.cssSelector("input[placeholder='Срок окончания ответов (через ... дней)']");
    private By inptPublish = By.cssSelector("input[placeholder='Срок публикации результатов (через ... дней)']");
    private By openQuestionNumber = By.xpath("//span[contains(.,'№')]");
    private By chooseQuestionNumber = By.cssSelector(".mat-option-text");
    private By questionType = By.cssSelector(".mat-select-placeholder");
    private By textQuestionType = By.xpath("//mat-option[2]/span");
    private By inptQuestionText = By.cssSelector("input[placeholder='Текст вопроса']");
    private By addQuestion = By.xpath("//mat-icon[contains(.,'add')]");
    private By addTemplate = By.xpath("//mat-icon[contains(.,'done')]");

    public TemplateCreationPage(WebDriver driver) { this.driver = driver; }

    public TemplateCreationPage enterTemplateName(String name) {
        new WebDriverWait(driver, 10).until(
                ExpectedConditions.textToBePresentInElement(driver.findElement(hdr), "Создание шаблона опроса"));
        driver.findElement(inptName).sendKeys(name);
        return this;
    }

    public TemplateCreationPage turnSelfEsteemOn() {
        driver.findElement(selfEsteem).click();
        return this;
    }

    public  TemplateCreationPage choosePublType() {
        driver.findElement(publType).click();
        new WebDriverWait(driver, 10).until(
                ExpectedConditions.visibilityOf(driver.findElement(openPubl)));
        driver.findElement(openPubl).click();
        return this;
    }

    public TemplateCreationPage enterDescription(String description) {
        driver.findElement(inptDescr).sendKeys(description);
        return this;
    }

    public TemplateCreationPage enterPeriod(String period) {
        driver.findElement(inptPeriod).sendKeys(del + period);
        return this;
    }

    public TemplateCreationPage enterAnswerStart(String input) {
        driver.findElement(inptAnswerStart).sendKeys(del + input);
        return this;
    }

    public TemplateCreationPage enterAnswerEnd(String input) {
        driver.findElement(inptAnswerEnd).sendKeys(del + input);
        return this;
    }

    public TemplateCreationPage enterPublish(String input) {
        driver.findElement(inptPublish).sendKeys(del + input);
        return this;
    }

    public TemplateCreationPage setTextQuestion(String questionText) {
        driver.findElement(openQuestionNumber).click();
        new WebDriverWait(driver, 10).until(
                ExpectedConditions.visibilityOfElementLocated(chooseQuestionNumber));
        driver.findElement(chooseQuestionNumber).click();
        driver.findElement(questionType).click();
        new WebDriverWait(driver, 10).until(
                ExpectedConditions.textToBePresentInElement(driver.findElement(textQuestionType), "Текст"));
        driver.findElement(textQuestionType).click();
        driver.findElement(inptQuestionText).sendKeys(questionText);
        driver.findElement(addQuestion).click();
        return this;
    }

    public TemplateListPage createTemplate() {
        driver.findElement(addTemplate).click();
        return new TemplateListPage(driver);
    }
}
