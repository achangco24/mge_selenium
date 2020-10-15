Feature: CPFS003 Field Activity
Scenario Outline: Cancel Existing FA

#####################################################################################
#
# CHANGE HISTORY:                                                
#                                                                
# Date:       	by:    		Reason:                                     
# 2020-06-22	RExtra		Initial Version.
#
#####################################################################################

Given User is on CC&B
When User login into CC&B with <username> and <password>
And Log Test Name as <testName>
And Navigate to FA Search
And Search FA with ID <faID> in Pop-up Window
And Click Cancel Button for Field Activity
And Select Cancel Reason as for Field Activity <cancelReason>
And User logout CC&B

Examples:
|testName|username|password|faID|cancelReason|
|CPFS003CancelExistingFA|SYSUSER|SysUser00|8442235436|Office Cancelled|
