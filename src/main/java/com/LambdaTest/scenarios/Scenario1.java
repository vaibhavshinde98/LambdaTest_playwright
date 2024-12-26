package com.LambdaTest.scenarios;

import com.microsoft.playwright.*;

//import static org.junit.Assert.assertEquals;

public class Scenario1 {
    public static void main(String[] args) {
        // Create Playwright instance
        try (Playwright playwright = Playwright.create()) {
            // Launch the browser
            Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false)); // Set headless to false to see the browser

            // Create a new browser context and page
            BrowserContext context = browser.newContext();
            Page page = context.newPage();


            page.navigate("https://www.lambdatest.com/selenium-playground");


            page.locator("//a[normalize-space()='Simple Form Demo']").click();


            String inputField = "Welcome to LambdaTest";
            page.fill("//input[@id='user-message']", inputField);
            page.locator("//button[@id='showInput']").click();

            String messageField = page.locator("//p[@id='message']").textContent();
           // assertEquals("Welcome to LambdaTest", messageField);

            page.waitForTimeout(2000);
            page.locator("//button[@id='showInput']").click();

            page.setDefaultNavigationTimeout(4000);
            page.close();
            browser.close();
        }
    }
}
