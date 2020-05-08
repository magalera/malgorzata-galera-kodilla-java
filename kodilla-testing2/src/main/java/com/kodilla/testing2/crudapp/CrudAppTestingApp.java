package com.kodilla.testing2.crudapp;

import com.kodilla.testing2.config.WebDriverConfig;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class CrudAppTestingApp {
    public final static String XPATH_INPUT = "/html/body/main/section[1]/form/fieldset[1]/input";
    public final static String XPATH_TEXTAREA = "/html/body/main/section[1]/form/fieldset[2]/textarea";
    public final static String XPATH_WAIT_FOR = "//select[1]";
    public final static String XPATH_SELECT = "//div[contains(@class, \"tasks-container\")]/form/div/fieldset/select[1]";

    public static void main(String[] args) {

        WebDriver driver = WebDriverConfig.getDriver(WebDriverConfig.FIREFOX);
        driver.get("https://magalera.github.io/");

        WebElement fieldTaskName = driver.findElement(By.xpath(XPATH_INPUT));
        fieldTaskName.sendKeys("New robotic task");

        WebElement fieldTaskContent = driver.findElement(By.xpath(XPATH_TEXTAREA));
        fieldTaskContent.sendKeys("New robotic task, lorem ipsum propsum lupsum kupsum");

        while (!driver.findElement(By.xpath(XPATH_WAIT_FOR)).isDisplayed()) ;

        WebElement selectCombo = driver.findElement(By.xpath(XPATH_SELECT));
        Select selectBoard = new Select(selectCombo);
        selectBoard.selectByIndex(1);
    }
}
