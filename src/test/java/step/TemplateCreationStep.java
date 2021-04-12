package step;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import page.TemplateCreationPage;
import page.TemplateListPage;

public class TemplateCreationStep {

    private TemplateCreationPage templateCreationPage;

    public TemplateCreationStep(WebDriver driver) {
        templateCreationPage = PageFactory.initElements(driver, TemplateCreationPage.class);
    }

    public TemplateListPage setNewTemplateData(String name, String description, String startDate, String endDate,
                                               String period, String answerStart, String answerEnd, String publish,
                                               String questionText) {
        templateCreationPage.enterTemplateName(name);
        templateCreationPage.turnSelfEsteemOn();
        templateCreationPage.choosePublType();
        templateCreationPage.enterDescription(description);
        templateCreationPage.chooseStartDate(startDate);
        templateCreationPage.chooseEndDate(endDate);
        templateCreationPage.enterPeriod(period);
        templateCreationPage.enterAnswerStart(answerStart);
        templateCreationPage.enterAnswerEnd(answerEnd);
        templateCreationPage.enterPublish(publish);
        templateCreationPage.setTextQuestion(questionText);
        return templateCreationPage.createTemplate();
    }
}
