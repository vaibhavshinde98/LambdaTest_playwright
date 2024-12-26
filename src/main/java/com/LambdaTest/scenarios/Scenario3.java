package com.LambdaTest.scenarios;

import com.microsoft.playwright.*;
import com.microsoft.playwright.options.SelectOption;

//import static org.junit.Assert.assertTrue;
//import static org.junit.jupiter.api.Assertions.*;
//import static org.junit.Assert.assertEquals;



public class Scenario3 {
    public static void main(String[] args) {
        // Create Playwright instance
        try (Playwright playwright = Playwright.create()) {
            // Launch the browser
            Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false)); // Set headless to false to see the browser

            // Create a new browser context and page
            BrowserContext context = browser.newContext();
            Page page = context.newPage();


            page.navigate("https://www.lambdatest.com/selenium-playground");


            page.locator("//a[normalize-space()='Input Form Submit']").click();


            Locator name = page.locator("#name");
            String validationMessage = (String) name.evaluate("element => element.validationMessage");
            if (validationMessage.contains("Please fill out this field.")) {
                System.out.println("Validation message is as expected.");
            } else {
                System.out.println("Validation message is not as expected: " + validationMessage);
            }
//            assertTrue(validationMessage.contains("Please fill out this field."));


//------------------------------
            page.fill("#name", "Mickey");
            page.fill("//input[@id='inputEmail4']", "mickey@gmail.com");
            page.fill("//input[@id='inputPassword4']", "mickey123");
            page.fill("//input[@id='company']", "Capgemini");

            page.fill("//input[@id='websitename']", "Talent");
            page.fill("//input[@id='inputCity']", "Hyderabad");
            page.fill("//input[@id='inputAddress1']", "Financial District");
            page.fill("//input[@id='inputAddress2']", "Gachibowli");
            page.fill("//input[@id='inputState']", "Telangana");
            page.fill("//input[@id='inputZip']", "500032");
            page.waitForTimeout(3000);
            page.selectOption("//select[@name='country']", new SelectOption().setLabel("United States"));

            page.waitForTimeout(3000);
            page.click("(//button[@type='submit'])[2]");



            page.setDefaultNavigationTimeout(4000);
            page.close();
            browser.close();
        }
    }
}
