Feature: CPCI001 Customer Information
Scenario Outline: Adding a Person Record

#####################################################################################
#
# CHANGE HISTORY:                                                
#                                                                
# Date:       	by:    		Reason:                                     
# 2020-06-15	RExtra		CP_CI.001	Initial Version.
#
#####################################################################################

Given User is on CC&B
When User login into CC&B with <username> and <password>
And Log Test Name as <testName>
And Navigate to Add Person
And Select Person/Business as <type>
And Enter Person Name <name>
And Select Person Contact Type as <contactType>
And Enter Person Contact Information as <contactNo>
And Set Person Primary Contact as "true" 
And Select Person ID Type as <idType>
And Enter Person ID number as <idNo>
And Set Add Account/Start Service as "false"
#And Select Customer Class as <custClass>
Then Person record is saved with Start Service as "false"
And User logout CC&B

Examples:
|testName|username|password|type|name|contactType|contactNo|idType|idNo|custClass|
|CPCI001AddingAPersonRecord|SYSUSER|SysUser00|Person|CPP, CCC|Cell Phone|(222) 444-5555|Social security number|444-55-1111|Electric Residential|
