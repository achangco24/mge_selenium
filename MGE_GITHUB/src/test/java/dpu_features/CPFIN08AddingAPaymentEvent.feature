Feature: CPFIN08 Financials
Scenario Outline: Adding a Payment Event

#####################################################################################
#
# CHANGE HISTORY:                                                
#                                                                
# Date:       	by:    		Reason:                                     
# 2020-06-02	RExtra		CP_FIN.08	Initial Version.
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
And SA Financial History Navigate to Add Payment Event
And Add Payment with Payment Date <date> and Distribution Code <distributionCode>
And User logout CC&B

Examples:
|testName|username|password|searchType|accountId|date|distributionCode|
|CPFIN08AddingAPaymentEvent|SYSUSER|SysUser00|Account ID|0000151111|08-10-2020|Distribute and Freeze if OK|
