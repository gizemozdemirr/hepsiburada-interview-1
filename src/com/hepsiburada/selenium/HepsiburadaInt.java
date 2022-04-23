package com.hepsiburada.selenium;


import org.junit.Test;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.After;
import org.junit.AfterClass;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.core.IsNot.not;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Alert;
import org.openqa.selenium.Keys;
import java.util.*;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;


public class HepsiburadaInt {	
	
  private WebDriver driver;
  private Map<String, Object> vars;
  JavascriptExecutor js;
  private static ChromeDriverService service;

  
  @BeforeClass
  public static void createAndStartService() throws IOException {
	    service = new ChromeDriverService.Builder()
	        .usingDriverExecutable(new File("D:\\chromedriver_win32\\chromedriver.exe"))
	        .usingAnyFreePort()
	        .build();
	    service.start();
	  }
  @AfterClass
  public static void stopService() {
	    service.stop();
	  }

  
  @Before
  public void setUp() {
	System.setProperty("webdriver.chrome.driver", "D:\\chromedriver_win32\\chromedriver.exe");

	  System.out.println("setUp**");
    driver = new ChromeDriver();
    js = (JavascriptExecutor) driver;
    vars = new HashMap<String, Object>();
  }
  @After
  public void tearDown() {
    driver.quit();
  }
  
  @Test
  public void sayfaKontrol(String expected , String actual) {
	  assertEquals(expected, actual);
  }
  
  @Test
  public void HepsiBuradaTest() throws InterruptedException {
	  System.out.println("--test1kitap started");
	    driver.get("https://www.hepsiburada.com/");
	    driver.manage().window().maximize();
	    driver.findElement(By.className("sf-OldMyAccount-PhY-T")).click();
	    Thread.sleep(7*1000);
	    driver.findElement(By.id("login")).click();
	    Thread.sleep(10*1000);
	    driver.findElement(By.id("txtUserName")).click();
	    driver.findElement(By.id("txtUserName")).sendKeys("ornekmail@gmail.com");
	    driver.findElement(By.id("btnLogin")).click();
	    Thread.sleep(5*1000);
	    driver.findElement(By.id("txtPassword")).click();
	    driver.findElement(By.id("txtPassword")).sendKeys("******parolagirin******");
	    driver.findElement(By.id("btnEmailSelect")).click();
	    Thread.sleep(8*1000);
	    driver.findElement(By.cssSelector(".SearchBoxOld-inputContainer")).click();
	    driver.findElement(By.cssSelector(".desktopOldAutosuggestTheme-input")).sendKeys("kitap");
	    driver.findElement(By.cssSelector(".SearchBoxOld-buttonContainer")).click();
	    Thread.sleep(8*1000);
	    sayfaKontrol("kitap - Hepsiburada",driver.getTitle());
	    js.executeScript("window.scrollTo(0,300)");
	    js.executeScript("window.scrollTo(0,388)");
	    vars.put("window_handles", driver.getWindowHandles());
	    driver.findElement(By.xpath("//img[contains(@src,\'https://productimages.hepsiburada.net/s/192/222-222/110000159149400.jpg\')]")).click();
	    vars.put("win3609", waitForWindow(10*1000));
	    driver.switchTo().window(vars.get("win3609").toString());
	    js.executeScript("window.scrollTo(0,55.20000076293945)");
	    js.executeScript("window.scrollTo(0,400)");
	    driver.findElement(By.id("addToCart")).click();
	    js.executeScript("window.scrollTo(0,0)");
	    driver.findElement(By.id("shoppingCart")).click();
	    {
	      WebElement element = driver.findElement(By.id("continue_step_btn"));
	      Actions builder = new Actions(driver);
	      builder.moveToElement(element).perform();
	    }
	    driver.findElement(By.id("continue_step_btn")).click();
	    driver.findElement(By.id("continue_step_btn")).click();
	    {
	      WebElement element = driver.findElement(By.id("continue_step_btn"));
	      Actions builder = new Actions(driver);
	      builder.moveToElement(element).perform();
	    }
	    {
	      WebElement element = driver.findElement(By.tagName("body"));
	      Actions builder = new Actions(driver);
	      builder.moveToElement(element, 0, 0).perform();
	    }
	    Thread.sleep(8*1000);
	    sayfaKontrol("Ödeme Bilgileri",driver.getTitle());
	    driver.findElement(By.cssSelector(".sardesPaymentPage-Accordion-accordion_tab:nth-child(2) .sardesPaymentPage-Combine-header_combine")).click();
	    driver.findElement(By.name("typepayment-money-transfer")).click();
	    driver.findElement(By.cssSelector(".sardesPaymentPage-Accordion-accordion_tab:nth-child(2) > .sardesPaymentPage-Accordion-accordion_header .sc-AxirZ")).click();
	    driver.findElement(By.cssSelector(".sardesPaymentPage-Accordion-accordion_tab:nth-child(3) > .sardesPaymentPage-Accordion-accordion_header .sc-AxirZ")).click();
	    driver.findElement(By.cssSelector(".sardesPaymentPage-Accordion-accordion_tab:nth-child(4) > .sardesPaymentPage-Accordion-accordion_header .sc-AxirZ")).click();
	    driver.findElement(By.id("continue_step_btn")).click();
	    {
	      WebElement element = driver.findElement(By.id("continue_step_btn"));
	      Actions builder = new Actions(driver);
	      builder.moveToElement(element).perform();
	    }
	    js.executeScript("window.scrollTo(0,0)");
	    
  }
  
  
  public String waitForWindow(int timeout) {
	    try {
	      Thread.sleep(timeout);
	    } catch (InterruptedException e) {
	      e.printStackTrace();
	    }
	    Set<String> whNow = driver.getWindowHandles();
	    Set<String> whThen = (Set<String>) vars.get("window_handles");
	    if (whNow.size() > whThen.size()) {
	      whNow.removeAll(whThen);
	    }
	    return whNow.iterator().next();
	  }
}
