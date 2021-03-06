package com.meethere.SystemTest;// Generated by Selenium IDE
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsNot.not;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.openqa.selenium.By;
import org.springframework.core.annotation.Order;

@TestMethodOrder(MethodOrderer.Alphanumeric.class)
public class SignUpTest extends BaseTest {



  @Test
  public void test_RR_ST_TC_002_002_2() throws InterruptedException {
    driver.get("http://localhost:8888/index");
    assertThat(driver.getTitle(), is("主页-Rest&Rent"));
    driver.findElement(By.linkText("注册")).click();
    assertThat(driver.getTitle(), is("注册-Rest&Rent"));
    Thread.sleep(1000);
    driver.findElement(By.id("userName")).click();
    driver.findElement(By.id("userName")).sendKeys("testUser");
    driver.findElement(By.id("email")).click();
    driver.findElement(By.id("email")).sendKeys("707864430@qq.com");
    driver.findElement(By.id("phone")).click();
    driver.findElement(By.id("phone")).sendKeys("13918826786");
    driver.findElement(By.id("userID")).click();
    driver.findElement(By.id("userID")).sendKeys("test004");
    driver.findElement(By.id("password")).click();
    driver.findElement(By.id("password")).sendKeys("1234");
    driver.findElement(By.id("submit")).click();
    Thread.sleep(1000);
    assertThat(driver.getTitle(), is("登录-Rest&Rent"));
    driver.close();
  }


  @Test
  public void test_RR_ST_TC_002_002_1() {
    driver.get("http://localhost:8888/index");
    assertThat(driver.getTitle(), is("主页-Rest&Rent"));
    driver.findElement(By.linkText("注册")).click();
    assertThat(driver.getTitle(), is("注册-Rest&Rent"));
    driver.findElement(By.id("userName")).click();
    driver.findElement(By.id("userName")).sendKeys("testUser");
    driver.findElement(By.id("email")).click();
    driver.findElement(By.id("email")).sendKeys("707864430@qq.com");
    driver.findElement(By.id("phone")).click();
    driver.findElement(By.id("phone")).sendKeys("13918826786");
    driver.findElement(By.id("userID")).click();
    driver.findElement(By.id("userID")).sendKeys("test004");
    driver.findElement(By.id("password")).click();
    driver.findElement(By.id("password")).sendKeys("1234");
    driver.findElement(By.id("submit")).click();
    assertThat(driver.findElement(By.id("alertId")).getText(), is("用户名已被占用，请重新输入！"));
    driver.close();
  }


  @Test
  public void test_RR_ST_TC_002_001_1() {
    // userId
    driver.get("http://localhost:8888/index");
    assertThat(driver.getTitle(), is("主页-Rest&Rent"));
    driver.findElement(By.linkText("注册")).click();
    assertThat(driver.getTitle(), is("注册-Rest&Rent"));
    driver.findElement(By.id("userName")).click();
    driver.findElement(By.id("userName")).sendKeys("testUser");
    driver.findElement(By.id("email")).click();
    driver.findElement(By.id("email")).sendKeys("707864430@qq.com");
    driver.findElement(By.id("phone")).click();
    driver.findElement(By.id("phone")).sendKeys("13918826786");
    driver.findElement(By.id("password")).click();
    driver.findElement(By.id("password")).sendKeys("1234");
    driver.findElement(By.id("submit")).click();
    assertThat(driver.getTitle(), is("注册-Rest&Rent"));
    //userName
    driver.findElement(By.linkText("注册")).click();
    assertThat(driver.getTitle(), is("注册-Rest&Rent"));
    driver.findElement(By.id("userID")).click();
    driver.findElement(By.id("userID")).sendKeys("test001");
    driver.findElement(By.id("userName")).click();
    driver.findElement(By.id("userName")).sendKeys("");
    driver.findElement(By.id("email")).click();
    driver.findElement(By.id("email")).sendKeys("707864430@qq.com");
    driver.findElement(By.id("phone")).click();
    driver.findElement(By.id("phone")).sendKeys("13918826786");
    driver.findElement(By.id("password")).click();
    driver.findElement(By.id("password")).sendKeys("1234");
    driver.findElement(By.id("submit")).click();
    assertThat(driver.getTitle(), is("注册-Rest&Rent"));
    //password
    assertThat(driver.getTitle(), is("注册-Rest&Rent"));
    driver.findElement(By.id("userName")).click();
    driver.findElement(By.id("userName")).sendKeys("testUser");
    driver.findElement(By.id("email")).click();
    driver.findElement(By.id("email")).sendKeys("707864430@qq.com");
    driver.findElement(By.id("phone")).click();
    driver.findElement(By.id("phone")).sendKeys("13918826786");
    driver.findElement(By.id("userID")).click();
    driver.findElement(By.id("userID")).sendKeys("test001");
    driver.findElement(By.id("password")).click();
    driver.findElement(By.id("password")).sendKeys("");
    driver.findElement(By.id("submit")).click();
    assertThat(driver.getTitle(), is("注册-Rest&Rent"));
    // email
    assertThat(driver.getTitle(), is("注册-Rest&Rent"));
    driver.findElement(By.id("userName")).click();
    driver.findElement(By.id("userName")).sendKeys("testUser");

    driver.findElement(By.id("email")).click();
    driver.findElement(By.id("email")).sendKeys("");
    driver.findElement(By.id("phone")).click();
    driver.findElement(By.id("phone")).sendKeys("13918826786");
    driver.findElement(By.id("userID")).click();
    driver.findElement(By.id("userID")).sendKeys("test001");
    driver.findElement(By.id("password")).click();
    driver.findElement(By.id("password")).sendKeys("1234");
    driver.findElement(By.id("submit")).click();
    assertThat(driver.getTitle(), is("注册-Rest&Rent"));
    //phone
    assertThat(driver.getTitle(), is("注册-Rest&Rent"));
    driver.findElement(By.id("userName")).click();
    driver.findElement(By.id("userName")).sendKeys("testUser");
    driver.findElement(By.id("email")).click();
    driver.findElement(By.id("email")).sendKeys("707864430@qq.com");
    driver.findElement(By.id("phone")).click();
    driver.findElement(By.id("phone")).sendKeys("");
    driver.findElement(By.id("userID")).click();
    driver.findElement(By.id("userID")).sendKeys("test001");
    driver.findElement(By.id("password")).click();
    driver.findElement(By.id("password")).sendKeys("1234");
    driver.findElement(By.id("submit")).click();
    assertThat(driver.getTitle(), is("注册-Rest&Rent"));
    driver.close();
  }




  @Test
  public void test_RR_ST_TC_002_001_3() throws InterruptedException {
    driver.get("http://localhost:8888/index");
    assertThat(driver.getTitle(), is("主页-Rest&Rent"));
    driver.findElement(By.linkText("注册")).click();
    assertThat(driver.getTitle(), is("注册-Rest&Rent"));
    Thread.sleep(1000);
    driver.findElement(By.id("userID")).click();
    driver.findElement(By.id("userID")).sendKeys("test12345");
    Thread.sleep(1000);
    driver.findElement(By.id("phone")).click();
    driver.findElement(By.id("phone")).sendKeys("13918826786");
    Thread.sleep(1000);
    driver.findElement(By.id("userName")).click();
    driver.findElement(By.id("userName")).sendKeys("testUser");
    Thread.sleep(1000);
    driver.findElement(By.id("password")).click();
    driver.findElement(By.id("password")).sendKeys("1234");
    Thread.sleep(1000);
    driver.findElement(By.id("email")).click();
    driver.findElement(By.id("email")).sendKeys("707864430");
    Thread.sleep(1000);
    driver.findElement(By.id("submit")).click();
    assertThat(driver.getTitle(), is("注册-Rest&Rent"));
    assertThat(driver.findElement(By.id("alertEmail")).getText(), is("请输入正确的邮箱！"));
    driver.close();
  }


  @Test
  public void test_RR_ST_TC_002_001_2() {
    driver.get("http://localhost:8888/index");
    assertThat(driver.getTitle(), is("主页-Rest&Rent"));
    driver.findElement(By.linkText("注册")).click();
    assertThat(driver.getTitle(), is("注册-Rest&Rent"));
    driver.findElement(By.id("userName")).click();
    driver.findElement(By.id("userName")).sendKeys("testUser");
    driver.findElement(By.id("email")).click();
    driver.findElement(By.id("email")).sendKeys("707864430@qq.com");
    driver.findElement(By.id("phone")).click();
    driver.findElement(By.id("phone")).sendKeys("707864430");
    driver.findElement(By.id("userID")).click();
    driver.findElement(By.id("userID")).sendKeys("test001");
    driver.findElement(By.id("password")).click();
    driver.findElement(By.id("password")).sendKeys("1234");
    assertThat(driver.getTitle(), is("注册-Rest&Rent"));
    assertThat(driver.findElement(By.id("alertPhone")).getText(), is("请输入正确的手机号！"));
    driver.close();
  }

}
