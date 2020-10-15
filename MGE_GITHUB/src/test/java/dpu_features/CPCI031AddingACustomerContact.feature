Feature: CPCI031 Customer Information
Scenario Outline: Adding a Customer Contact

#####################################################################################
#
# CHANGE HISTORY:                                                
#                                                                
# Date:       	by:    		Reason:                                     
# 2020-06-19	RExtra		Initial Version.
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
And Navigate to Add Customer Contact thru Person Context Menu
And Select Contact Class as <contactClass>
And Enter Contact Type as <contactType>
Then Customer Contact record is saved
And User logout CC&B

Examples:
|testName|username|password|searchType|accountId|contactClass|contactType|
|CPCI031AddingACustomerContact|SYSUSER|SysUser00|Account ID|0000151111|General customer contact|CPPWELCOME|
