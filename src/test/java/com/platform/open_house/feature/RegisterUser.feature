Feature: Register a new user

Scenario: User attempts to register without entering any data
Given No User is logged in
Then Navigate to Registration Page
Then Click the Registration Button
Then Verify that all alert fields show for empty form

Scenario: User attempts to register with minimum input for all fields
Given No User is logged in
Then Navigate to Registration Page
Then Enter minimum amount of data for fields
Then Click the Registration Button

Scenario: User attempts to register with maximum input for all fields
Given No User is logged in
Then Navigate to Registration Page
Then Enter maximum amount of data for fields
Then Click the Registration Button

Scenario: User attempts to register at minimum boundary for all fields
Given No User is logged in
Then Navigate to Registration Page
Then Enter data to meet minimum boundary for all fields
Then Click the Registration Button
Then Verify that all alert fields show

Scenario: User attempts to register at maximum boundary for all fields
Given No User is logged in
Then Navigate to Registration Page
Then Enter data to meet maximum boundary for all fields
Then Click the Registration Button
Then Verify that all alert fields show

Scenario: User attempts to register with digits in first and last name
Given No User is logged in
Then Navigate to Registration Page
Then Enter first and last name with a number
Then Click the Registration Button
Then Verify the first and last name error

Scenario: User attempts to register with letters in phone number
Given No User is logged in
Then Navigate to Registration Page
Then Enter phone number with a letter
Then Click the Registration Button
Then Verify the phone number error

Scenario: User attempts to register without matching passwords
Given No User is logged in
Then Navigate to Registration Page
Then Enter registration data without matching passwords
Then Click the Registration Button
Then Verify the password error

Scenario: User attempts to register with existing username
Given No User is logged in
Then Navigate to Registration Page
Then Enter registration data with existing username
Then Click the Registration Button
Then Verify the username error