package page;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import step.TemplateCreationStep;

public class TemplateListPage {
    private WebDriver driver;
    private By hdr = By.xpath("//h1");
    private By creationButton = By.xpath("//mat-icon[contains(.,'note_add')]");
    private By searchInpt = By.cssSelector("input[placeholder='Поиск по названию']");
    private By searchRes = By.xpath("//mat-cell[2]/div");

    public TemplateListPage(WebDriver driver) { this.driver = driver; }

    public TemplateCreationStep pressCreationButton() {
        new WebDriverWait(driver, 10).until(
                ExpectedConditions.textToBePresentInElement(driver.findElement(hdr), "Список шаблонов опросов"));
        driver.findElement(creationButton).click();
        return new TemplateCreationStep(driver);
    }

    public void checkThatTemplateIsCreated(String name) throws InterruptedException {
        new WebDriverWait(driver, 10).until(
                ExpectedConditions.textToBePresentInElement(driver.findElement(hdr), "Список шаблонов опросов"));
        driver.findElement(searchInpt).sendKeys(name + Keys.ENTER);
        Thread.sleep(200);
        Assert.assertEquals(driver.findElement(searchRes).getText(), name);
    }
}
