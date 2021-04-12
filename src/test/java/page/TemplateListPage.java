package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import step.TemplateCreationStep;

public class TemplateListPage {
    private WebDriver driver;
    private By hdr = By.xpath("//h1");
    private By creationButton = By.xpath("//mat-icon[contains(.,'note_add')]");

    public TemplateListPage(WebDriver driver) { this.driver = driver; }

    public TemplateCreationStep pressCreationButton() {
        new WebDriverWait(driver, 10).until(
                ExpectedConditions.textToBePresentInElement(driver.findElement(hdr), "Список шаблонов опросов"));
        driver.findElement(creationButton).click();
        return new TemplateCreationStep(driver);
    }

    public void checkThatPageIsLoaded(String header) {
        new WebDriverWait(driver, 10).until(
                ExpectedConditions.textToBePresentInElement(driver.findElement(hdr), "Список шаблонов опросов"));
        Assert.assertEquals(driver.findElement(hdr).getText(), header);
    }
}
