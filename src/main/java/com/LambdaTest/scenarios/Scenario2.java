package com.LambdaTest.scenarios;


import com.microsoft.playwright.*;
import com.microsoft.playwright.options.BoundingBox;

public class Scenario2 {

    public static void main(String[] args) {
        // Create Playwright instance
        try (Playwright playwright = Playwright.create()) {
            // Launch the browser
            Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false)); // Set headless to false to see the browser

            // Create a new browser context and page
            BrowserContext context = browser.newContext();
            Page page = context.newPage();


            page.navigate("https://www.lambdatest.com/selenium-playground");
            page.locator("//a[normalize-space()='Drag & Drop Sliders']").click();

            Locator slider = page.locator("input[type='range'][value='15']");
            slider.waitFor();
            BoundingBox sliderBox = slider.boundingBox();
            if (sliderBox == null) {
                throw new RuntimeException("Slider not visible");
            }
            double sliderWidth = sliderBox.width;
            double initialValue = 15;
            double maxValue = 100;
            double targetValue = 95;
            double targetPosition = ((targetValue - initialValue) / (maxValue - initialValue)) * sliderWidth;
            System.out.println("Calculated target position for value 95: " + targetPosition);
            double adjustedTargetPosition = Math.min(targetPosition, sliderWidth);
            System.out.println("Adjusted target position (clamped to slider width): " + adjustedTargetPosition);
            page.mouse().move(sliderBox.x + sliderBox.width / 2, sliderBox.y + sliderBox.height / 2);
            page.mouse().down();
            page.mouse().move(sliderBox.x + adjustedTargetPosition, sliderBox.y + sliderBox.height / 2);
            page.mouse().up();
            page.waitForTimeout(500);
            String newValue = slider.inputValue();
            System.out.println("Slider input value after drag: " + newValue);
            if (!newValue.equals("95")) {
                System.out.println("Adjusting the slider value to 95...");
                slider.fill("95");
            }
            slider.dispatchEvent("input");
            page.waitForTimeout(500);

            page.setDefaultNavigationTimeout(4000);
            page.close();
            browser.close();
        }
    }
    }
