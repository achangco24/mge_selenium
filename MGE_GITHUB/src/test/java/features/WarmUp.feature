Feature: Warm-up
Scenario Outline: Warm-up
Given User is on CC&B
When User login into CC&B with <username> and <password>
And Logout


Examples:
|username 	|password	|
|SYSUSER	|sysuser00	|
