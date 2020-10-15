Feature: CPCI032 Customer Information
Scenario Outline: Adding a Manual Alert

#####################################################################################
#
# CHANGE HISTORY:                                                
#                                                                
# Date:       	by:    		Reason:                                     
# 2020-05-04	RExtra		Initial Version.
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
And Navigate to Account thru Context Menu
And Switch to Alerts Tab
And Set Alert Type <alertType>
And User logout CC&B

Examples:
|testName|username|password|searchType|accountId|alertType|
|CPCI032AddingAManualAlert|SYSUSER|SysUser00|Account ID|0000261111|Enrolled in Paperless Billing|
