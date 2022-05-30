@Activity1

  Feature: google search

    Scenario: Performing a google search for cheese

      Given User is on the google Home page
      When User types in Cheese and hits ENTER
      Then Show how many search results were shown
      And Close the browser
