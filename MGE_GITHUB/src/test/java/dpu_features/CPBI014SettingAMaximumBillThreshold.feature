Feature: CPBI014 Billing
Scenario Outline: Setting a Maximum Bill Threshold

#####################################################################################
#
# CHANGE HISTORY:                                                
#                                                                
# Date:       	by:    		Reason:                                     
# 2020-06-03	RExtra		CP_BI.014	Initial Version.
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
And Navigate to SA via SA Context Menu
And Set Max Bill Threshold <maxBillThreshold>
And User logout CC&B

Examples:
|testName|username|password|searchType|accountId|maxBillThreshold|
|CPBI014SettingAMaximumBillThreshold|SYSUSER|SysUser00|Account ID|0000151111|$100.00|
