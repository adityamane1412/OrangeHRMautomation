Feature: Login

  Scenario: Login with Valid Credentials
    Given executing story 'Login'
    And User Open Url
    When User Enters Username 'admin'
    And User Enter Password 'w3D9YlpU@B'
    And User Clicks on Checkbox
    And User Clicks on Login Button
    Then Page Title should be 'Employee Management'