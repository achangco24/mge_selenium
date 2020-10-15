Feature: Create New Premise
Scenario Outline: Create New Premise in CC&B
Given User is on CC&B
When User login into CC&B with <username> and <password>
And Navigate to Premise Page
And Select PremiseType field as <premise_type>
And Select Premise Zip Code as <zip>
And Select Premise CIS Code as <cis>
And Switch to Premise Misc Tab
And Select Premise Trend Area as <trend_area>
And Switch to Premise Main Tab
And Set Premise Address as <address>
Then Save Premise
And Logout


Examples:
|username 	|password 	|premise_type			|zip	|cis		|trend_area					|address				|
|SYSUSER	|sysuser00	|Single Family Home		|87110	|California	|San Francisco, California	|Selenium Address9786	|
|SYSUSER	|sysuser00	|Multi-Family Housing	|87654	|California	|San Francisco, California	|Selenium Address9787	|
