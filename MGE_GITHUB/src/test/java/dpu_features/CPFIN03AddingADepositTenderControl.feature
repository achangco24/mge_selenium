Feature: CPFIN03 Financials
Scenario Outline: Adding a Deposit and Tender Control

#####################################################################################
#
# CHANGE HISTORY:                                                
#                                                                
# Date:       	by:    		Reason:                                     
# 2020-06-16	RExtra		CP_FIN.03	Initial Version.
#
#####################################################################################

Given User is on CC&B
When User login into CC&B with <username> and <password>
And Log Test Name as <testName>
And Navigate to Deposit Control page
And Enter Ending Balance as <endBal>
Then Deposit Control record is saved
And Navigate to Add Tender Control thru Context Menu
And Select Tender Source as <tenderSource>
And Save Tender Control
And User logout CC&B

Examples:
|testName|username|password|endBal|tenderSource|
|CPFIN03AddingADepositTenderControl|SYSUSER|SysUser00|$0.00|CPPMANUL|
