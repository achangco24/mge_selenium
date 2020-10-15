Feature: CPCI014 Customer Information
Scenario Outline: Adding a Manual To Do

#####################################################################################
#
# CHANGE HISTORY:                                                
#                                                                
# Date:       	by:    		Reason:                                     
# 2020-07-01	RExtra		Initial Version.
#
#####################################################################################

Given User is on CC&B
When User login into CC&B with <username> and <password>
And Log Test Name as <testName>
And Navigate to To Do Entry Add Page
And Create To Do with fields <toDoType>, <priority>, <subject>, <comment>, <sendTo> and <role> with Account ID <acctID>

And User logout CC&B

Examples:
|testName|username|password|toDoType|priority|subject|comment|sendTo|role|acctID|
|CPCI014AddingAManualToDo|SYSUSER|SysUser00|Customer Refund|Priority 10 -- Highest|Test|Test|Role|CMCSMGRSUP|0000151111|
