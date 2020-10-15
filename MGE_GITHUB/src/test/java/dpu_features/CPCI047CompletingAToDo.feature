Feature: CPCI047 Customer Information
Scenario Outline: Completing a To Do

#####################################################################################
#
# CHANGE HISTORY:                                                
#                                                                
# Date:       	by:    		Reason:                                     
# 2020-07-02	RExtra		Initial Version.
#
#####################################################################################

Given User is on CC&B
When User login into CC&B with <username> and <password>
And Log Test Name as <testName>
And Navigate to To Do Summary page thru Dashboard link
And Select To Do as <toDoId>
And Enter To Do Entry Comment as <comment>
And Click Complete Button for To Do Entry
And User logout CC&B

Examples:
|	testName				|	username	|	password	|	toDoId			|	comment				|
|	CPCI047CompletingAToDo	|	SYSUSER		|	sysuser00	|	41022122132709	|	Selenium Testing.	|