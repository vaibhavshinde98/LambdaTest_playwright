Feature: Playwright

  @regression @smoke
  Scenario Outline: Simple Form Demo Page
    Given user on the lambda page
    When user click on Simple Form Demo Page
    Then user land on Simple Form Demo Page
    Given user enter text "<{string}>"
    When user click button
    Then user validate message displayed


    Examples:
      | {string}         |
      | WelcometoLambdaTest        |

  @regression @smoke
  Scenario: Input Form Demo Page
    Given user on the lambda page
    When user click on Input Form Submit
    When user click on submit button

    Given user enter fields
    When user click on submit button
    Then user land on Thanks Page


  @regression @smoke
  Scenario: Drag & Drop Sliders
    Given user on the lambda page
    When user click on Drag Drop Sliders
    When I drag the "Default value 15" slider to value 95
    Then match with expected value 95

