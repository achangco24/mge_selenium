Feature: FS001 Field Activity
Scenario Outline: Adding a Field Activity – CWD and CPP

#####################################################################################
#
# CHANGE HISTORY:                                                
#                                                                
# Date:       	by:    		Reason:                                     
# 2020-04-20	GSando		Initial Version.
#
#####################################################################################

Given User is on CC&B
When User login into CC&B with <username> and <password>
And Log Test Name as <testName>
And Navigate to Control Central page
And Select Search By as <searchType>
And Select CWD for CIS Division
And Search Account ID as <accountId>
And From Premise Context Menu go to Field Activity add
And Select Service Point as <spId>
And Set Field Activity Type as <faType>
And Enter Field Activity Schedule Date as <schedDate>
And Enter Field Activity Schedule Time as <time>
And Enter Field Activity Instructions as <instructions>
Then Field Activity record is saved <mode>
And User logout CC&B

Examples:
|testName|username|password|searchType|accountId|spId|faType|schedDate|time|instructions|mode|
|FS001AddAFieldActivity|SYSUSER|SysUser00|Account ID|0000000002|0980010904|INV-AMR|08-26-2020|12:00AM|Selenium Test|Add|
