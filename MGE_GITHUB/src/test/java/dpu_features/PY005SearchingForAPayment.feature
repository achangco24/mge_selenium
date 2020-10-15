Feature: PY005 Payment
Scenario Outline: Searching for a Payment

#####################################################################################
#
# CHANGE HISTORY:                                                
#                                                                
# Date:       	by:    		Reason:                                     
# 2020-04-22	GSando		Initial Version.
#
#####################################################################################

Given User is on CC&B
When User login into CC&B with <username> and <password>
And Log Test Name as <testName>
And Navigate to Payment/Tender Search page
And Select Search For as <searchFor>
And Select Payment Account as <paymentAccount>
And Enter Account ID as <accountId>
And Click Search Button of Payment/Tender Search
And User logout CC&B

Examples:
|testName|username|password|searchFor|paymentAccount|accountId|
|PY005SearchingForAPayment|SYSUSER|SysUser00|Payment|Account|7112000000|
