package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.reporters.jq.Main;

public class MainPage {

    private WebDriver driver;
    private By hdr = By.xpath("//h1");
    private By userName = By.className("pl-10");

    public MainPage(WebDriver driver) { this.driver = driver; }

    public TemplateListPage pressTemplateListButton() {
        new WebDriverWait(driver, 10).until(
                ExpectedConditions.textToBePresentInElement(driver.findElement(hdr), "Мои результаты"));
        driver.findElement(By.xpath("//a[7]/div/span")).click();
        return new TemplateListPage(driver);
    }
}
