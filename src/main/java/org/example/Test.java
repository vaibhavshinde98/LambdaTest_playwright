package org.example;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

import java.nio.file.Paths;

public class Test {

    public static void main(String[] args){

        Playwright playwright= Playwright.create();
        Browser browser=playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(50));

        Page page=browser.newPage();

        page.navigate("https://www.chittorgarh.com/");
        page.setDefaultNavigationTimeout(4000);



        page.locator("//a[@id='navbtn_ipo']").click();
        page.waitForTimeout(2000);

        page.locator("//a[text()='IPO Reviews']").first().click();
        page.waitForTimeout(2000);

        page.evaluate("window.scrollBy(0, 500);"); // Scroll down 500 pixels
        page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get("example.png")));

        browser.close();
        playwright.close();
    }
}
