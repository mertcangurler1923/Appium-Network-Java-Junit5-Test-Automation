package org.example;

import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Scanner;

import static io.appium.java_client.touch.WaitOptions.waitOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;
import static io.appium.java_client.touch.offset.PointOption.point;
import static java.time.Duration.ofSeconds;

public class BaseApp  {
    WebDriverWait wait;
    TouchAction action;
    AndroidDriver<MobileElement> driver;
    public BaseApp(AndroidDriver<MobileElement> driver) {
        this.driver=driver;
        wait=new WebDriverWait(driver, 5);
        this.action= new TouchAction(driver);
    }
    public void tapByCoordinates(int x, int y,int seconds) {
        action.tap(point(x,y)).waitAction(waitOptions(ofSeconds(seconds))).perform();
    }
    public void dragAndDropByCoordinates(By bLocator, By aLocator) {
        action.longPress(element(find(bLocator))).moveTo(element(find(bLocator))).release().perform();
    }
    public void dragAndDropByCoordinates(int bx,int by,int ax,int ay) {
        action.longPress(point(bx,by)).moveTo(point(ax,ay)).release().perform();
    }
    public MobileElement find(By locator) {
        return (MobileElement) wait.until(ExpectedConditions.presenceOfElementLocated(locator));
    }
    public void click(By locator) {
        find(locator).click();
    }
    public void click(MobileElement element) {
        element.click();
    }
    public void inputEnter(By locator, String sendkeys){
        find(locator).sendKeys(sendkeys);
        //driver.pressKey(new KeyEvent(AndroidKey.NUMPAD_ENTER));
        tapByCoordinates(993,1682,5);
    }
    public void input(By locator, String sendkeys){
        find(locator).sendKeys(sendkeys);
    }

    public void clickIf(By locator){
        try{
            click(locator);
        }
        catch (Exception e){

        }
    }
    public String getText(By locator) {
        String value = find(locator).getText();
        return value;
    }

    public static List<String> csvRead() throws FileNotFoundException {
        // List<String> idPassword=new ArrayList<>();
        Log log=new Log();
        File fl = new File("dosya.csv");
        if (fl.exists()) {

            log.info("Mail ve şifre okundu.");
        } else {
            log.info("Mail ve şifre okunmadı.");
        }
        Scanner s = new Scanner(fl);
        List<String> idPassword = null;
        while (s.hasNextLine()) {
            String text = s.nextLine();
            idPassword = List.of(text.split(";"));
        }
        return idPassword;
    }
    public String wait(By locator){
        String stringWait;
        /*wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
        stringWait=Boolean.toString(booleanWait);*/
        try{
            find(locator);
            stringWait="true";
        }
        catch (Exception ex){
            stringWait="false";
        }
        return stringWait;
    }
}
