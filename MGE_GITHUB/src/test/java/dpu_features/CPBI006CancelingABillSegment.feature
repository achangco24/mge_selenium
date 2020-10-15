Feature: CPBI006 Billing
Scenario Outline: Canceling a Bill Segment

#####################################################################################
#
# Author: EY_PHADV_Manila_Testing.GID@ey.net
#
# CHANGE HISTORY:                                                
#                                                                
# Date:       	by:    		Reason:                                     
# 2020-07-07	RExtra		CP_BI.006	Add components to Cancel a Bill Segment
#
#####################################################################################

Given User is on CC&B
When User login into CC&B with <username> and <password>
And Log Test Name as <testName>
And Navigate to Control Central page
And Select Search By as <searchType>

#Temporary Step -- Remove before deployment to production
And Select CPP for CIS Division

And Search Account ID as <accountId>
And Navigate to Search Bill thru Current Account Context Menu
And Search for Bill ID <billID>
And Select a Bill Segment
And Initate Bill Segment Cancellation due to <reason>
And Cancel Bill Segment

And User logout CC&B

Examples:
|	testName						|	username	|	password	|	searchType	|	accountId		|	billID			|	reason		|
|	CPBI006CancelingABillSegment	|	SYSUSER		|	sysuser00	| 	Account ID  | 	5248251561 		|	524217284061	|	Wrong rate	|