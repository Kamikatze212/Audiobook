package com.example.tests;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class AddBookTests {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @Before
  public void setUp() throws Exception {
    driver = new FirefoxDriver();
    baseUrl = "http://test.mobadmin.neoline.biz";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void fillForm() throws Exception {
    driver.get(baseUrl + "/admin/login");
    driver.findElement(By.name("login")).clear();
    driver.findElement(By.name("login")).sendKeys("klukyanov@neoline.biz");
    driver.findElement(By.name("password")).clear();
    driver.findElement(By.name("password")).sendKeys("XZNZ1uIZ");
    driver.findElement(By.cssSelector("button.btn.btn-login")).click();
    driver.findElement(By.linkText("Книги")).click();
    driver.findElement(By.linkText("Выберите проект")).click();
    driver.findElement(By.linkText("Аудиокнига")).click();
    driver.findElement(By.id("NewBookButton")).click();
    driver.findElement(By.name("name")).clear();
    driver.findElement(By.name("name")).sendKeys("Автотест4");
    
    driver.findElement(By.id("Authors")).clear();
    driver.findElement(By.id("Authors")).sendKeys("Чуднова Анна");
    driver.findElement(By.linkText("Чуднова Анна")).click();
    driver.findElement(By.id("Speakers")).clear();
    driver.findElement(By.id("Speakers")).sendKeys("Доронин Юрий");
    driver.findElement(By.linkText("Доронин Юрий")).click();
    driver.findElement(By.name("inapp")).clear();
    driver.findElement(By.name("inapp")).sendKeys("186247");
    driver.findElement(By.id("Categories")).clear();
    driver.findElement(By.id("Categories")).sendKeys("Проза");
    driver.findElement(By.linkText("Проза")).click();
    driver.findElement(By.id("Categories")).sendKeys("Детектив");
    driver.findElement(By.linkText("Детектив")).click();
    driver.findElement(By.id("AudioExpireDate")).click();
    driver.findElement(By.cssSelector("span.ui-icon.ui-icon-circle-triangle-e")).click();
    driver.findElement(By.linkText("10")).click();
    driver.findElement(By.id("AudioBookDescription")).clear();
    driver.findElement(By.id("AudioBookDescription")).sendKeys("Тестовое описание для создания скрипта");
    driver.findElement(By.xpath("(//button[@type='button'])[8]")).click();
    
    //driver.findElement(By.cssSelector("span.fileinput-button file")).sendKeys("\\SERVER2\\AppsMinistry\\Аудиокнига_Плюта\\Обложки\\обложки правильные\\175652\\cover_name_library.png");
    //driver.findElement(By.xpath("//button[@type='submit']")).click();
      
    driver.findElement(By.linkText("Аудиофайлы")).click();
    driver.findElement(By.id("UpdateButton")).click();
    driver.findElement(By.xpath("(//button[@type='button'])[16]")).click();
    driver.findElement(By.id("SyncButton")).click();
    driver.findElement(By.xpath("(//button[@type='button'])[70]")).click();
    driver.findElement(By.linkText("Тестовая зона")).click();
    driver.findElement(By.id("UserMenuButton")).click();
    driver.findElement(By.linkText("Выход")).click();
  }

  @After
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
