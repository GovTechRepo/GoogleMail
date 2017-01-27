package com.example.tests;

import java.util.concurrent.TimeUnit;
import org.testng.annotations.*;
import static org.testng.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;

public class GmailLogin {
	 private WebDriver driver;
	  private String baseUrl;
	  private boolean acceptNextAlert = true;
	  private StringBuffer verificationErrors = new StringBuffer();

	  @BeforeClass(alwaysRun = true)
	  public void setUp() throws Exception {
		  
	    System.setProperty("webdriver.gecko.driver","C:\\Users\\IDACTMO002\\Desktop\\GovTech\\Selenium\\geckodriver-v0.11.1-win64\\geckodriver-v0.11.1-win64\\geckodriver.exe");
	    driver = new FirefoxDriver();
	    baseUrl = "https://www.google.com.sg/";
	    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	  }

	  @Test(priority=1)
	  public void TestCase1_GmailSignIn() throws Exception {
	    driver.get(baseUrl + "/?gws_rd=ssl");
	    driver.findElement(By.linkText("Gmail")).click();
	    driver.findElement(By.id("Email")).clear();
	    driver.findElement(By.id("Email")).sendKeys("govtechtesting");
	    driver.findElement(By.id("next")).click();
	    driver.findElement(By.id("Passwd")).clear();
	    driver.findElement(By.id("Passwd")).sendKeys("govtechtesting1");
	    driver.findElement(By.id("signIn")).click();
	  }
	  
	  @Test(priority=2)
	  public void TestCase2_testComposeMail() throws Exception {
	    driver.get("https://mail.google.com/mail/u/0/?tab=wm#inbox");
	//  assertEquals(driver.getTitle(), "Inbox (5) - govtechtesting@gmail.com - Gmail");
	    driver.findElement(By.xpath(".//*[@id=':5l']/div/div")).click();
	    driver.findElement(By.xpath("html/body/div[7]/div[3]/div/div[2]/div[1]/div[1]/div[1]/div[2]/div/div/div[1]/div/div")).click();
	    driver.findElement(By.cssSelector("div.Sr")).click();
	    driver.findElement(By.id(":a9")).click();
	    driver.findElement(By.id(":a9")).clear();
	    driver.findElement(By.id(":a9")).sendKeys("TestMail_01");
	    driver.findElement(By.id(":9z")).click();
	  }
	  
	  @Test(priority=3)
	  public void TestCase3_testLogOutMail() throws Exception {
	    driver.get("https://mail.google.com/mail/u/0/?tab=wm#inbox");
	    assertEquals(driver.getTitle(), "Inbox (6) - govtechtesting@gmail.com - Gmail");
	    driver.findElement(By.cssSelector("span.gb_9a.gbii")).click();
	    driver.findElement(By.id("gb_71")).click();
	    assertEquals(driver.getTitle(), "Google Accounts");
	    assertEquals(driver.getTitle(), "Google Accounts");
	    assertEquals(driver.getTitle(), "Google Accounts");
	    assertEquals(driver.getTitle(), "Gmail");
	  }
	  
	  
  @AfterClass(alwaysRun = true)
  public void tearDown() throws Exception {
    driver.quit();
    String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
      fail(verificationErrorString);
    }
  }

  private boolean isElementPresent(By by) {
    try {
      driver.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }

  private boolean isAlertPresent() {
    try {
      driver.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }

  private String closeAlertAndGetItsText() {
    try {
      Alert alert = driver.switchTo().alert();
      String alertText = alert.getText();
      if (acceptNextAlert) {
        alert.accept();
      } else {
        alert.dismiss();
      }
      return alertText;
    } finally {
      acceptNextAlert = true;
    }
  }
}
