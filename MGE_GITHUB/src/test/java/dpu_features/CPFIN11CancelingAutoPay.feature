Feature: CPFIN11 Financials
Scenario Outline: Canceling Auto Pay

#####################################################################################
#
# CHANGE HISTORY:                                                
#                                                                
# Date:       	by:    		Reason:                                     
# 2020-06-02	RExtra		Initial Version.
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
And Switch to Auto Pay Tab
And Enter Auto Pay End Date <endDate>
And User logout CC&B

Examples:
|testName|username|password|searchType|accountId|endDate|
|CPFIN11CancelingAutoPay|SYSUSER|SysUser00|Account ID|0000151111|09-20-2020|
