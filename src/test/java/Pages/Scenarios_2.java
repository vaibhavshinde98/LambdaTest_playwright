package Pages;


import Automation.CollectionTest;
import com.microsoft.playwright.*;
import com.microsoft.playwright.options.BoundingBox;
import io.cucumber.java.en.*;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import static org.junit.jupiter.api.Assertions.*;

public class Scenarios_2 {
    public static Playwright playwright = Playwright.create();
    public static BrowserType chrome = playwright.chromium();
    static String caps;
    static {    try {        caps = URLEncoder.encode(CollectionTest.getDefaultTestCapability().toString(), "utf-8");    }
    catch (UnsupportedEncodingException e) {        throw new RuntimeException(e);    }}
    static String cdpUrl = "wss://cdp.lambdatest.com/playwright?capabilities=" + caps;
    public static Browser browser = playwright.chromium().connect(cdpUrl);
    public static Page page = browser.newPage();

//    protected static Playwright playwright = Playwright.create();
//    protected static BrowserType chrome = playwright.chromium();
//    protected static Browser browser = chrome.launch(new BrowserType.LaunchOptions().setHeadless(false).setChannel("msedge"));
//    protected static Page page = browser.newPage();

    public static void launchApp() {
        page.navigate("https://www.lambdatest.com/selenium-playground/");

    }

    public static void userClickOnSimpleFormDemoPage() {
        page.click("//a[text()='Simple Form Demo']");
    }

    public static void enterText(String WelcometoLambdaTest) {
        page.fill("//*[@id=\"user-message\"]", "WelcometoLambdaTest");
        page.waitForTimeout(5000);
    }

    public static void validateMessageDisplayed() {
        String displayedMessage = page.textContent("//p[@id='message']");
        String WelcometoLambdaTest = "WelcometoLambdaTest";
        if (displayedMessage.equals(WelcometoLambdaTest)) {
            System.out.println("Message validation passed: " + displayedMessage);
        } else {
            System.out.println("Message validation failed. Expected: " + WelcometoLambdaTest + ", but got: " + displayedMessage);
        }
    }

    public static void userClickOnInputFormSubmit() {
        page.click("//a[text()='Input Form Submit']");
    }

    public static void userClickOnDragDropSliders() {
        page.click("//a[text()='Drag & Drop Sliders']");
        page.waitForTimeout(5000);
    }

    public static void iDragTheSliderToValue(String sliderLabel, Integer targetValue) {
        Locator sliderInput = page.locator("#slider3 > div > input");
        BoundingBox box = sliderInput.boundingBox();
        double currentPosition = box.x + (box.width * 0.15);
        double targetPosition = box.x + (box.width * (0.93));
        page.mouse().move(currentPosition, box.y + box.height / 2);
        page.mouse().down();
        page.waitForTimeout(100);
        page.mouse().move(targetPosition, box.y + box.height / 2);
        page.waitForTimeout(100);
        page.mouse().up();

    }

    public static void sliderValueDisplay(Integer expectedValue) {
        Locator outputValue = page.locator("#slider3 > div > output");
        String actualValue = outputValue.textContent();
        assertEquals(expectedValue.toString(), actualValue.trim(), "Slider value should be" + expectedValue);
        browser.close();
    }

    public static void userLandOnSimpleFormDemoPage() {
        page.waitForTimeout(5000);
        String expectedurl = "https://www.lambdatest.com/selenium-playground/simple-form-demo";
        String currenturl = page.url();
        if (!currenturl.equals(expectedurl)) {
            System.out.println("fail to land on Simple form demo page");
        }
        System.out.println("successfully landed on Simple form demo page");
    }


    public static void enterFields() {
        page.locator("//input[@id='name']").fill("vaibhav shinde");
        page.locator("//input[@id='inputEmail4']").fill("vaibhavshinde@gmail.com");
        page.locator("//input[@id='inputPassword4']").fill("Test123");
        page.locator("//input[@id='company']").fill("Capgemini");
        page.locator("//input[@id='websitename']").fill("www.capgemini.com");
        page.locator("//select[@class='w-full border border-gray-90 text-size-14 rounded mt-10 px-10 py-5']").selectOption("United States");
        page.locator("//input[@id='inputCity']").fill("Houston");
        page.locator("//input[@id='inputAddress1']").fill("1-9-330/A");
        page.locator("//input[@id='inputAddress2']").fill("Astonia");
        page.locator("//input[@id='inputState']").fill("Texas");
        page.locator("//input[@id='inputZip']").fill("6546");
        page.waitForTimeout(5000);
    }

    public static void clickOnNodeButton() {
        page.click("//button[text()='Get Checked Value']");
        page.waitForSelector("//button[text()='Get Checked Value']");
        page.waitForTimeout(5000);

    }

    public static void userClickOnSubmitButton() {
        page.click("//button[text()='Submit']");

    }

    public static void errorMessage() {
        String errorMessage = page.locator("div[class='form-group']").innerText();
        if (errorMessage.contains("Please fill in the fields")) {
            System.out.println("Error message displayed: " + errorMessage);
        } else {
            System.out.println("Error message not displayed.");
        }
    }

    public static void userLandOnThanksPage() {
        String successMessage = page.locator("p[class='success-msg hidden']").innerText();
        if (successMessage.equals("Thanks for contacting us, we will get back to you shortly.")) {
            System.out.println("Success message displayed: " + successMessage);
        } else {
            System.out.println("Success message not displayed.");
        }
    }
}



