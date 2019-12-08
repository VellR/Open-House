Feature: Smoke Test

Scenario: Register User One
Given User One does not exist
Then Register User One
Then Login User One
Then Navigate to Items
Then Create Item
Then Navigate to Requests
Then Create Request
Then Navigate to All Listed Items
Then Verify Item is present
Then Navigate to Profile
Then Modify Profile
Then Logout User One
Then Verify that User One Profile is modified

Scenario: Register User Two
Given User Two does not exist
Then Register User Two
Then Login User Two
Then Start trade with User One
Then Fulfill request for User One