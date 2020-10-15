Feature: PY010 Payment
Scenario Outline: Cancelling a Payment

#####################################################################################
#
# CHANGE HISTORY:                                                
#                                                                
# Date:       	by:    		Reason:                                     
# 2020-04-24	GSando		Initial Version.
#
#####################################################################################

Given User is on CC&B
When User login into CC&B with <username> and <password>
And Log Test Name as <testName>
And Navigate to Control Central page
And Select Search By as <searchType>
And Search Account ID as <accountId>
And From Account Context Menu go to Payment search
And Select PaymentStatus as <paymentStatus>
And Click Cancel Button for Payment
And Select Cancel Reason for Payment as <cancelReason>
And User logout CC&B

Examples:
|testName|username|password|searchType|accountId|paymentStatus|cancelReason|
|PY010CancellingAPayment|SYSUSER|SysUser00|Account ID|7112000000|Frozen|Stopped payment|
