Feature: CPFS009 Field Services
Scenario Outline: Create and Complete e-XXX FA

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
And Navigate to Control Central page
And Select Search By as <searchType>

#Temporary Step -- Remove before deployment to production
And Select CPP for CIS Division

And Search Account ID as <accountId>
And From Premise Context Menu go to Field Activity add
And Select SP with ID <spID>
And Set Field Activity Type as <faType>
And Enter Field Activity Schedule Date as <scheduleDate>
And Enter Field Activity Schedule Time as <scheduleTime>
And Enter Field Activity Instructions as <instructions>
And Enter Field Dispatch Group as <dispatchGroup>
Then Field Activity record is saved <mode>
And Switch to Steps Tab
And Navigate to Linked Service Point
And Set SP Source Status to <spStatus>
And Set Disconnect Location to <disconnectLoc>
Then Service Point record is saved <mode2>
And Click Back Button in SP Page
And SP Switch to Main Tab
And Complete Field Activity

And User logout CC&B

Examples:
|testName|username|password|searchType|accountId|spID|faType|scheduleDate|scheduleTime|instructions|dispatchGroup|mode|spStatus|disconnectLoc|mode2|
|CPFS009CreateAndCompleteFA|SYSUSER|SysUser00|Account ID|2912741111|6260510660|ELMTROFF|08-20-2020|10:30AM|Selenium Test|CPPMTR|Add|Disconnected|Connection|Update|
