Feature: PY001 Deposit Control
Scenario Outline: Confirm functionality of Creating a Deposit Control

#####################################################################################
#
# Author: EY_PHADV_Manila_Testing.GID@ey.net
#
# CHANGE HISTORY:                                                
#                                                                
# Date:       	by:    		Reason:                                     
# YYYY-MM-DD	IN			Reason text.
#
#####################################################################################

Given User is on CC&B
When User login into CC&B with <username> and <password>
And Navigate to Deposit Control page
And Select Deposit Control Tender Source Type as <tenderSource>
And Select Deposit Control Currency Code Type as <currency>
And Enter Deposit Control Comment as <comment>
Then Deposit Control record is saved
And User logout CC&B

Examples:
|	username	|	password	|	tenderSource		|	currency				|	comment							  	|
|	SYSUSER		|	sysuser00	|	Online Cashiering	|	United States Dollars	|	This is a Selenium Automation Test	|
