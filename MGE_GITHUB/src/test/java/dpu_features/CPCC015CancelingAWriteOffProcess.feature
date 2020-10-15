Feature: CPCC015 Credit & Collections
Scenario Outline: Cancelling a Write Off Process

#####################################################################################
#
# CHANGE HISTORY:                                                
#                                                                
# Date:       	by:    		Reason:                                     
# 2020-05-13	RExtra		Initial Version.
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
And Navigate to Write Off Process via Dashboard Alert
And Set Write Off Process Cancellation Reason
And Set Write Off Process Cancellation Comment <comments>
And Cancel Write Off Process
And Confirm Cancel Write Off Process
And User logout CC&B
		
Examples:
