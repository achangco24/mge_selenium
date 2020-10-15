Feature: CPCC013 Credit & Collections
Scenario Outline: Cancelling a Severance Process

#####################################################################################
#
# CHANGE HISTORY:                                                
#                                                                
# Date:       	by:    		Reason:                                     
# 2020-05-12	RExtra		Initial Version.
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
And Navigate to Severance Process via Dashboard Alert
And Set Severance Process Cancellation Reason
And Set Severance Process Cancellation Comment <comments>
And Cancel Severance Process
And Confirm Cancel Severance Process
And User logout CC&B
		
Examples:
|testName|username|password|searchType|accountId|comments|
|CPCC013CancelingASeveranceProcess|SYSUSER|SysUser00|Account ID|2494051111|Selenium Test Cancel|
