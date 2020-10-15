Feature: Create New Premise
Scenario Outline: Create New Premise in CC&B
Given User is on CC&B
When User login into CC&B with <username> and <password>
Then Test
And Logout


Examples:
|username 	|password	|
|SYSUSER	|sysuser00	|