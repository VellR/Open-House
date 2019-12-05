Feature: Create a new Item

Scenario: Navigate to Item Page
Given no User is logged in
Then login User
Then navigate to Item Page
Then create a new item
Then verfiy that the item has been created