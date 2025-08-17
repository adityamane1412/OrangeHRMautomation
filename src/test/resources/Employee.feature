Feature: Adding Employee

  Scenario: Add Employee with Mandatory Data
    Given executing story 'Employee'
    And User Open Url
    When User Enters Username 'admin'
    And User Enter Password 'w3D9YlpU@B'
    And User Clicks on Checkbox
    And User Clicks on Login Button
    And User Sets Data for 'MandatoryFields' from 'Employee'
    And User Clicks on Employee List
    And User Clicks on Employee Add Button
    And User Fills Employee Data