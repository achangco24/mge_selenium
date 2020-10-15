Feature: CPBI001 Billing
Scenario Outline: Manually Generating a Bill

#####################################################################################
#
# Author: EY_PHADV_Manila_Testing.GID@ey.net
#
# CHANGE HISTORY:                                                
#                                                                
# Date:       	by:    		Reason:                                     
# 2020-07-08	RExtra		CP_BI.002	Add components to CancelRebilling a Bill Segment
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
And Navigate to Meter/Item Search Page
And Navigate to Search Meter Read via MeterItem Info Context Menu
And Search Meter Read with ID <meterReadID>
And Enter Register Reading as <newMeterRead> <addMeterRead>
Then Meter Read record is saved
And Navigate to Search Bill thru Current Account Context Menu
And Search for Bill ID <billID>
And Select a Bill Segment
And Rebill Bill Segment due to <reason>
And Freeze Bill
And Navigate to Bill from Bill Segment
And Verify Old Bill Segment Status

And User logout CC&B

Examples:
|	testName							|	username	|	password	|	searchType	|	accountId		|	meterReadID		|	newMeterRead	|	addMeterRead	|	billID			|	reason		|
|	CPBI002CancelRebillingABillSegment	|	SYSUSER		|	SysUser00	| 	Account ID  | 	0022770000 		|	072387205532	|	37174.000000	|	26.000000		|	858775106413	|	Wrong read	|