package org.example;

import com.microsoft.playwright.*;

public class TalentPage {
    public static void main(String [] args ){
        System.out.println("hello playwright...");
        Playwright playwright = Playwright.create();

        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(50));

        Page page = browser.newPage();

        page.navigate("https://playwright.dev/");

        BrowserContext browserContext= browser.newContext(new Browser.NewContextOptions().setViewportSize(1920,937));
//        System.out.println(page.title());

//        page.navigate("https://start.spring.io/");

//        page.getByLabel("Corporate Directory").click();

        page.close();
        playwright.close();
    }
}
