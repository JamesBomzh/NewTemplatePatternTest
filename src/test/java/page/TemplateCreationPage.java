package page;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TemplateCreationPage {
    private WebDriver driver;
    private By hdr = By.xpath("//h1");
    String del = Keys.chord(Keys.CONTROL, "a") + Keys.DELETE;
    private By inptName = By.cssSelector("#mat-input-3");
    private By selfEsteem = By.cssSelector(".mat-checkbox-label");
    private By publType = By.xpath("//div/span/span");
    private By openPubl = By.xpath("//mat-option[3]/span");
    private By inptDescr = By.id("mat-input-4");
    private By startDate = By.id("mat-input-5");
    private By endDate = By.id("mat-input-6");
    private By inptPeriod = By.id("mat-input-7");
    private By inptAnswerStart = By.id("mat-input-8");
    private By inptAnswerEnd = By.id("mat-input-9");
    private By inptPublish = By.id("mat-input-10");
    private By openQuestionNumber = By.xpath("//form/mat-form-field/div/div/div/mat-select/div/div/span");
    private By chooseQuestionNumber = By.xpath("//mat-option/span");
    private By questionType = By.cssSelector(".mat-select-placeholder");
    private By textQuestionType = By.xpath("//mat-option[2]/span");
    private By inptQuestionText = By.id("mat-input-11");
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

    public TemplateCreationPage chooseStartDate(String date) {
        driver.findElement(startDate).sendKeys(del + date);
        return this;
    }

    public TemplateCreationPage chooseEndDate(String date) {
        driver.findElement(endDate).sendKeys(del + date);
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
                ExpectedConditions.textToBePresentInElement(driver.findElement(chooseQuestionNumber), "1"));
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
