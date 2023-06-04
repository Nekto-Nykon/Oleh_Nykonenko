Feature: Job management

  Scenario: creating and deleting of job title

    Given user went onto login page

    When user logs in
    And user enters Admin page
    And user selects 'Job' dropdown
    And user selects 'Job titles' option
    And user clicks on the Add button
    And user creates new job with title "This is new job", description "This is test description", and note "This is new note"
    Then new "This is new job" job title appears on the the 'Job Titles' page

    When user selects job titled "This is new job"
    And user clicks on 'Delete selected'
    And user confirms deletion by clicking 'Yes, Delete'
    Then the job "This is new job" is removed

