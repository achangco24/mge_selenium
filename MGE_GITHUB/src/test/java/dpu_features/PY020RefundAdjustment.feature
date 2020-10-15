Feature: PY020 Add Refund Adjustment
Scenario Outline: Test the functionality of adding refund adjustment

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
And From Account Context Menu go to Adjustment add
And Set Adjustment Type as <adjType>
And Enter Adjustment Amount as <amount>
And Enter Adjustment Comments as <comment>
And Click Adjustment Generate button
Then Click Adjustment Freeze button
And User logout CC&B

Examples:
|	username	|	password	|	searchType	|	accountId	|	adjType	|	amount	|	comment																	|
|	SYSUSER		|	sysuser00	|	Account ID	|	4141950013	|	REF-W	|	0		|	This is auto-generated data creation made by Selenium Automation Tool	|
