Feature: CPFIN02 Financials
Scenario Outline: Canceling an Adjustment

#####################################################################################
#
# CHANGE HISTORY:                                                
#                                                                
# Date:       	by:    		Reason:                                     
# 2020-06-01	RExtra		CP_FIN.02	Initial Version.
# 2020-06-01	RExtra		CP_FIN.02	Update Steps to accommodate change due to
#										SQL Integration
#
#####################################################################################

Given User is on CC&B
When User login into CC&B with <username> and <password>
And Log Test Name as <testName>

#Start Remove --- CP_FIN.02
#And Navigate to Control Central page
#And Select Search By as <searchType>
#And Search Account ID as <accountId>
#And Navigate to SA Financial History
#And Navigate to Adjustment Notebook
#And Select Adjustment from Adjustment Notebook as <adjustmentType>
#End Remove --- CP_FIN.02

And Navigate to Adjustment Search
And Search Adjustment ID <adjustmentID> thru popup

And Enter Adjustment Comments as <comment>
And Click Cancel Button for Adjustment
And Select Cancel Reason for Adjustment as <cancelReason>
And Save Cancelled Adjustment
And User logout CC&B

Examples:
