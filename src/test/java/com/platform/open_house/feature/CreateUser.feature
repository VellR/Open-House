Feature: Create a new user

Scenario: Navigate to the feed page
Given no User is logged in
Then register a New User
Then Login with that User's credentials
Then verify that the User is on the feed page