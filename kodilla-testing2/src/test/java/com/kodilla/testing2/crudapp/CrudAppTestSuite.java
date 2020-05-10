package com.kodilla.testing2.crudapp;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.Random;

import static com.kodilla.testing2.config.WebDriverConfig.FIREFOX;
import static com.kodilla.testing2.config.WebDriverConfig.getDriver;

public class CrudAppTestSuite {
    private static final String BASE_URL = "https://magalera.github.io/";
    private WebDriver driver;
    private Random generator;

    @Before
    public void initTests() {
        driver = getDriver(FIREFOX);
        driver.get(BASE_URL);
        generator = new Random();
    }

    @After
    public void cleanUpAfterTest() {
        driver.close();
    }

    @Test
    public void shouldCreateTrelloCard() throws InterruptedException {
        String taskName = createCrudAppTestTask();
        sendTestTaskToTrello(taskName);
        deleteTaskAppTestTask(taskName);
    }

    private String createCrudAppTestTask() {
        final String XPATH_TASK_NAME = "//form[contains(@action, \"createTask\")]/fieldset[1]/input";
        final String XPATH_TASK_CONTENT = "//form[contains(@action, \"createTask\")]/fieldset[2]/textarea";
        final String XPATH_BUTTON_ADD = "//form[contains(@action, \"createTask\")]/fieldset[3]/button";
        String taskName = "Task number " + generator.nextInt(100000);
        String taskContent = taskName + " content";

        WebElement taskNameElement = driver.findElement(By.xpath(XPATH_TASK_NAME));
        taskNameElement.sendKeys(taskName);

        WebElement taskContentElement = driver.findElement(By.xpath(XPATH_TASK_CONTENT));
        taskContentElement.sendKeys(taskContent);

        WebElement buttonAddTask = driver.findElement(By.xpath(XPATH_BUTTON_ADD));
        buttonAddTask.click();

        return taskName;
    }

    private void sendTestTaskToTrello(String taskName) throws InterruptedException {
        driver.navigate().refresh();

        while (!driver.findElement(By.xpath("//select[1]")).isDisplayed()) ;

        driver.findElements(By.xpath("//form[@class=\"datatable__row\"]")).stream()
                .filter(anyForm ->
                        anyForm.findElement(By.xpath("//p[@class=\"datatable__field-value\"]"))
                                .getText().equals(taskName))
                .limit(1)
                .forEach(theForm -> {
                    WebElement selectElement = theForm.findElement(By.xpath(".//select[1]"));
                    Select select = new Select(selectElement);
                    select.selectByIndex(1);

                    WebElement buttonCreateCard =
                            theForm.findElement(By.xpath(".//button[contains(@class, \"card-creation\")]"));
                    buttonCreateCard.click();
                });
        Thread.sleep(5000);

        driver.switchTo().alert().accept();
    }

    private void deleteTaskAppTestTask(String taskName) {
        while (!driver.findElement(By.xpath("//select[1]")).isDisplayed()) ;

        driver.findElements(By.xpath("//form[@class=\"datatable__row\"]")).stream()
                .filter(anyForm ->
                        anyForm.findElement(By.xpath("//p[@class=\"datatable__field-value\"]"))
                                .getText().equals(taskName))
                .forEach(theForm -> {
                    WebElement buttonCreateCard =
                            theForm.findElement(By.xpath("//button[@data-task-delete-button=\"\"]"));
                    buttonCreateCard.click();
                });
    }
}