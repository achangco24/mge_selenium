Feature: CPFS001 Field Services
Scenario Outline: Create a New FA Manually

#####################################################################################
#
# CHANGE HISTORY:                                                
#                                                                
# Date:       	by:    		Reason:                                     
# 2020-05-04	RExtra		Initial Version.
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
And User logout CC&B

Examples:
|testName|username|password|searchType|accountId|spID|faType|scheduleDate|scheduleTime|instructions|dispatchGroup|mode|
|CPFS001CreateANewFAManually|SYSUSER|SysUser00|Account ID|0000151111|8440503668|EVADD|08-26-2020|12:00AM|Selenium Test|CPPMTR|Add|
