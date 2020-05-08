package com.kodilla.testing2.facebook;

import com.kodilla.testing2.config.WebDriverConfig;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class FacebookTestingApp {
    public final static String XPATH_WAIT_FOR_DAY = "//select[1]";
    public final static String XPATH_WAIT_FOR_MONTH = "//select[2]";
    public final static String XPATH_WAIT_FOR_YEAR = "//select[3]";
    public final static String XPATH_SELECT_DAY = "//div[@class=\"_5k_5\"]/span/span/select[1]";
    public final static String XPATH_SELECT_MONTH = "//div[@class=\"_5k_5\"]/span/span/select[2]";
    public final static String XPATH_SELECT_YEAR = "//div[@class=\"_5k_5\"]/span/span/select[3]";

    public static void main(String[] args) {
        WebDriver driver = WebDriverConfig.getDriver(WebDriverConfig.FIREFOX);
        driver.get("https://www.facebook.com/");

        while (!driver.findElement(By.xpath(XPATH_WAIT_FOR_DAY)).isDisplayed()) ;
        WebElement selectComboDay = driver.findElement(By.xpath(XPATH_SELECT_DAY));
        Select dayOfBirth = new Select(selectComboDay);
        dayOfBirth.selectByIndex(16);

        while (!driver.findElement(By.xpath(XPATH_WAIT_FOR_MONTH)).isDisplayed()) ;
        WebElement selectComboMonth = driver.findElement(By.xpath(XPATH_SELECT_MONTH));
        Select monthOfBirth = new Select(selectComboMonth);
        monthOfBirth.selectByIndex(5);

        while (!driver.findElement(By.xpath(XPATH_WAIT_FOR_YEAR)).isDisplayed()) ;
        WebElement selectComboYear = driver.findElement(By.xpath(XPATH_SELECT_YEAR));
        Select yearOfBirth = new Select(selectComboYear);
        yearOfBirth.selectByIndex(33);
    }
}
