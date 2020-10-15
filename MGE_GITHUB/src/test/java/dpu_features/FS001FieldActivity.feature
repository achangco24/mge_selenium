Feature: FS001 Add Field Activity
Scenario Outline: Test the functionality of adding field activity

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
And Navigate to Control Central page
And Select Search By as <searchType>
And Search Account ID as <accountId>
And From Premise Context Menu go to Field Activity add
And Set Field Activity Type as <faType>
And Enter Field Activity Schedule Date as <schedDate>
And Enter Field Activity Comments as <comment>
Then Field Activity record is saved
And User logout CC&B

Examples:
|	username	|	password	|	searchType	|	accountId	|	faType	|	schedDate	|	comment																	|
|	SYSUSER		|	sysuser00	|	Account ID	|	8594979085	|	INV-AMR	|	05-02-2019	|	This is auto-generated data creation made by Selenium Automation Tool	|