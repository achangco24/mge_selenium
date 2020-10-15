Feature: FS003 Field Activity
Scenario Outline: Cancel an Existing Field Activty

#####################################################################################
#
# CHANGE HISTORY:                                                
#                                                                
# Date:       	by:    		Reason:                                     
# 2020-04-21	GSando		Initial Version.
#
#####################################################################################

Given User is on CC&B
When User login into CC&B with <username> and <password>
And Log Test Name as <testName>
And Navigate to Control Central page
And Select Search By as <searchType>
And Search Account ID as <accountId>
And From Premise Context Menu go to Field Activity search
And Select Field Activity Status as <faStatus>
And Click Cancel Button for Field Activity
And Select Cancel Reason as for Field Activity <cancelReason>
And User logout CC&B

Examples:
|testName|username|password|searchType|accountId|faStatus|cancelReason|
|FS003CancelAnExistingFA|SYSUSER|SysUser00|Account ID|2031330000|Pending|Office Cancelled|
