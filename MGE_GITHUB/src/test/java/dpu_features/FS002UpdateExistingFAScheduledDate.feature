Feature: FS002 Field Activity
Scenario Outline: Update Existing FA Scheduled Date

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
And Enter Field Activity Schedule Date as <schedDate>
Then Field Activity record is saved <mode>
And User logout CC&B

Examples:
|testName|username|password|searchType|accountId|faStatus|schedDate|mode|
|FS002UpdateExistingFAScheduledDate|SYSUSER|sysuser00|Account ID|4472165872|Pending|01-01-2020|Update|
