package com.browserstack;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;
import java.net.URL;
import java.util.Properties;
import java.io.FileInputStream;
import java.io.IOException;

public class BrowserStackTest {

  public static Properties loadProperties() throws IOException {
    Properties properties = new Properties();
    FileInputStream in = new FileInputStream("config.properties");
    properties.load(in);
    in.close();
    return properties;
  }

  @Test
  public void test_browser() throws Exception {
    Properties properties = loadProperties();
    String browserStackUrl = properties.getProperty("browserstack.url");
    DesiredCapabilities caps1 = new DesiredCapabilities();
    caps1.setCapability("os", "OS X");
    caps1.setCapability("os_version", "Big Sur");
    caps1.setCapability("browserName", "Chrome");
    caps1.setCapability("browserVersion", "latest");
    caps1.setCapability("name", "MacOS Big Sur - Chrome Test");

    WebDriver driver1 = new RemoteWebDriver(new URL(browserStackUrl), caps1);
    driver1.get("https://www.bstackdemo.com/");
    driver1.manage().window().maximize();
    System.out.println(driver1.getTitle());
    driver1.quit();

    // Windows 10 with Edge
    DesiredCapabilities caps2 = new DesiredCapabilities();
    caps2.setCapability("os", "Windows");
    caps2.setCapability("os_version", "10");
    caps2.setCapability("browserName", "Edge");
    caps2.setCapability("browserVersion", "latest");
    caps2.setCapability("name", "Windows 10 - Edge Test");

    WebDriver driver2 = new RemoteWebDriver(new URL(browserStackUrl), caps2);
    driver2.get("https://www.bstackdemo.com/");
    driver1.manage().window().maximize();
    System.out.println(driver2.getTitle());
    driver2.quit();

    // Samsung Galaxy S22 Ultra with Chrome
    DesiredCapabilities caps3 = new DesiredCapabilities();
    caps3.setCapability("device", "Samsung Galaxy S22 Ultra");
    caps3.setCapability("os_version", "12.0");
    caps3.setCapability("browserName", "chrome");
    caps3.setCapability("name", "Samsung Galaxy S22 Ultra - Chrome Test");

    WebDriver driver3 = new RemoteWebDriver(new URL(browserStackUrl), caps3);
    driver3.get("https://www.bstackdemo.com/");
    driver1.manage().window().maximize();
    System.out.println(driver3.getTitle());

    driver3.quit();
  }
}
