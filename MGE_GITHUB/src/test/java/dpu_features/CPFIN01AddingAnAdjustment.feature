Feature: CPFIN01 Financials
Scenario Outline: Adding an Adjustment

#####################################################################################
#
# CHANGE HISTORY:                                                
#                                                                
# Date:       	by:    		Reason:                                     
# 2020-06-01	RExtra		Initial Version.
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
And Navigate to Add Adjustment
And Set Adjustment Type as <adjustmentType>
And Enter Adjustment Amount as <amount>
And Click Adjustment Generate button
And Click Adjustment Freeze button
And User logout CC&B

Examples:
|testName|username|password|searchType|accountId|adjustmentType|amount|
|CPFIN01AddingAnAdjustment|SYSUSER|sysuser00|Account ID|0000270000|E-NSF|$25.00|
