package StepDefination;


import Pages.Scenarios_2;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public  class ScenariosStepDefinations {


    @Given("user on the lambda page")
    public void user_on_the_lambda_page() {

        Scenarios_2.launchApp();
    }

    @When("user click on Simple Form Demo Page")
    public void user_click_On_Simple_Form_Page() {
        Scenarios_2.userClickOnSimpleFormDemoPage();
    }
    @Then ("user validate message displayed")
    public void user_validate_message_displayed() {
        Scenarios_2.validateMessageDisplayed();
    }
    @When("user click on Input Form Submit")
    public void user_click_On_Input_Form_Submit() {
        Scenarios_2.userClickOnInputFormSubmit();

    }
    @When("user click on Drag Drop Sliders")

    public void user_click_On_Drag_Drop_Sliders() {
        Scenarios_2.userClickOnDragDropSliders();
    }
    @When("I drag the {string} slider to value {int}")
    public void iDragTheSliderToValue(String sliderLabel, Integer targetValue){
        Scenarios_2.iDragTheSliderToValue(sliderLabel, targetValue);
    }
    @Then("match with expected value {int}")
    public void match_with_expected_value(Integer expectedValue){
        Scenarios_2.sliderValueDisplay(expectedValue);
    }
    @Then("user land on Simple Form Demo Page")
    public void user_land_on_Simple_Form_Demo_Page(){
        Scenarios_2.userLandOnSimpleFormDemoPage();
    }

    @Given("user enter text {string}")
    public void user_enter_text(String WelcometoLambdaTest) {
        Scenarios_2.enterText(WelcometoLambdaTest);
    }

    @Given("user enter fields")
    public void user_enter_fields() {
        Scenarios_2.enterFields();
    }

    @When("user click button")
    public void user_click_button() {
        Scenarios_2.clickOnNodeButton();
    }
    @When("user click on submit button")
    public void user_click_on_submit_button() {
        Scenarios_2.userClickOnSubmitButton();
    }
    @Then("page shows error message")
    public void page_shows_error_message() {
        Scenarios_2.errorMessage();
    }
    @Then("user land on Thanks Page")
    public void user_land_on_Thanks_Page() {
        Scenarios_2.userLandOnThanksPage();
    }

    // @Then("user close browser")
    //public void user_close_browser(){
    // Scenarios.closeBrowser();
}



