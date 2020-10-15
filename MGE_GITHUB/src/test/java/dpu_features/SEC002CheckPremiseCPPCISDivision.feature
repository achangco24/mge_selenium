Feature: SEC.002 Security
Scenario Outline: Checking Premise Data for CPP CIS Division

#####################################################################################
#
# CHANGE HISTORY:                                                
#                                                                
# Date:       	by:    		Reason:                                     
# 2020-07-29	RExtra		Initial Version.
#
#####################################################################################

Given User is on CC&B
When User login into CC&B with <username> and <password>
And Log Test Name as <testName>
And Navigate to Control Central page
And Select Search By as <searchType>
And Enter Control Central Address as <address>
And Verify Address Result with <premiseIDs>
And User logout CC&B

Examples:
