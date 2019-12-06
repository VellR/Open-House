Feature: Create a new user

Scenario: Navigate to the feed page
Given no User is logged in
Then register a New User
Then Login with that User's credentials
Then verify that the User is on the feed page

Scenario: User attempts to register without meeting requirements for names and username
Given no User is logged in
Then Register a user with the less than the min characters for firstname, lastname, and username
Then verify that an error message is displayed for each input

Scenario: User attempts to register without meeting min characters for password, location, or phonenumber
Given no User is logged in
Then Register a user with 