Feature: Create a new Item

Scenario: Create Item without any data
Given The Test User is not logged in
Then Navigate to My Items Page
Then Click the Add Item button
Then Verify that all Item errors appear

Scenario: Create Item with minimum amount of data
Given The Test User is not logged in
Then Navigate to My Items Page
Then Enter minimum amount of data for Item

Scenario: Create Item with maximum amount of data
Given The Test User is not logged in
Then Navigate to My Items Page
Then Enter maximum amount of data for Item

Scenario: Create an Item without an expriation date
Given The Test User is not logged in
Then Navigate to My Items Page
Then Enter data for Item without an expiration date
Then Click the Add Item button
Then Verify Item expration error appears

Scenario: Create an Item without a price
Given The Test User is not logged in
Then Navigate to My Items Page
Then Enter data for Item without a price
Then Click the Add Item button
Then Verify Item price error appears

Scenario: Create an item using minimum data at boundaries
Given The Test User is not logged in
Then Navigate to My Items Page
Then Enter minimum amount of boundary data for Item
Then Click the Add Item button
Then Verify that Item size errors appear

Scenario: Create an item using maximum data at boundaries
Given The Test User is not logged in
Then Navigate to My Items Page
Then Enter maximum amount of boundary data for Item
Then Click the Add Item button
Then Verify that Item size errors appear