package org.example;

import com.microsoft.playwright.*;
import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

import java.nio.file.Paths;

public class Main {
    public static void main(String[] args)throws InterruptedException {
        System.out.println("Hello playwright...");
        Playwright playwright = Playwright.create();

        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(50));

        Page page = browser.newPage();

        page.navigate("https://playwright.dev/");
        page.setDefaultNavigationTimeout(4000);

        page.locator("//a[@role='button']").click();

        page.locator("//a[@class='dropdown__link'][normalize-space()='Java']").click();
        page.waitForTimeout(2000);
        page.locator("//*[@class='DocSearch DocSearch-Button' and @type='button']").click();
        page.waitForTimeout(2000);

        // Enter "Locators" in the search input
        page.locator("//input[@id ='docsearch-input']").fill("Locators");
        page.waitForTimeout(2000);
        // Wait for the search results and click the first result
        page.locator("//div[@class='DocSearch-Hit-icon']").first().click();
        page.waitForTimeout(4000);

        page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get("example.png")));
//        System.out.println(page.title());
        browser.close();
        playwright.close();

    }
}