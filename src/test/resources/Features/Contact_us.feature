@Run
Feature: Contact us

  Scenario: Send a message with customer service subject heading
    Given I navigated to automationpractice landing page
    And I go to contact us page
    When I select 'Customer service' on subject heading
    And I enter 'ulfasdyh@gmail.com' on email field
    And I enter 'order reference' on order reference field
    And I attach 'C:\Users\Formulatrix\Downloads\IMG-20201209-WA0031.jpg' file
    And I enter 'message example' on message field
    And I send the message
    Then 'Your message has been successfully sent to our team.' message displayed