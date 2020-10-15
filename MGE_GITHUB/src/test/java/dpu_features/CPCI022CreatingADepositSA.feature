Feature: CPCI022 Customer Information
Scenario Outline: Creating a Deposit SA

#####################################################################################
#
# CHANGE HISTORY:                                                
#                                                                
# Date:       	by:    		Reason:                                     
# 2020-06-17	RExtra		Initial Version.
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
And Navigate to Add SA thru Account Context
And Set SA Type as <saType>
And Set Char Premise ID as <premID>
And Set Requested Deposit Amount as <depositAmt>
And Activate SA
And User logout CC&B

Examples:
|testName|username|password|searchType|accountId|saType|premID|depositAmt|
|CPCI022CreatingADepositSA|SYSUSER|sysuser00|Account ID|3267270000|E-RESDEP|7711540000|150.00|
