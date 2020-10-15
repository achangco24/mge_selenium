Feature: CPCC010 Credit & Collections
Scenario Outline: Cancelling a Collection Process

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
And Navigate to Collection Process via Dashboard Alert
And Set Collection Process Cancellation Reason
And Set Collection Process Cancellation Comment <comments>
And Cancel Collection Process
And Confirm Cancel Collection Process
And User logout CC&B

Examples:
|testName|username|password|searchType|accountId|comments|
|CPCC010CancelingACollectionProcess|SYSUSER|SysUser00|Account ID|2494051111|Selenium Test Cancel|
