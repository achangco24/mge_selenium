Feature: CPFS002 Field Services
Scenario Outline: Update Existing FA Scheduled Date

#####################################################################################
#
# CHANGE HISTORY:                                                
#                                                                
# Date:       	by:    		Reason:                                     
# 2020-06-19	RExtra		Initial Version.
#
#####################################################################################

Given User is on CC&B
When User login into CC&B with <username> and <password>
And Log Test Name as <testName>
And Navigate to FA Search
And Search FA with ID <faID> in Pop-up Window
And Enter Field Activity Schedule Date as <schedDate>
Then Field Activity record is saved <mode>
And User logout CC&B

Examples:
|testName|username|password|faID|schedDate|mode|
|CPFS002UpdateExistingFAScheduledDate|SYSUSER|SysUser00|8442235436|01-01-2020|Update|
