Feature: CPCI038 Customer Information
Scenario Outline: Assigning To Do Entries (Supervisor)

#####################################################################################
#
# CHANGE HISTORY:                                                
#                                                                
# Date:       	by:    		Reason:                                     
# 2020-07-06	RExtra		Initial Version.
#
#####################################################################################

Given User is on CC&B
When User login into CC&B with <username> and <password>
And Log Test Name as <testName>
And Navigate to Supervisor To Do Assignment Page
And Search for To Do Type <toDoType>
And Filter Supervisor To Do Assignment By <filterBy>
And Select To Do for Assignment
And Assign to Supervisor <user>
And User logout CC&B

Examples:
|	testName								|	username	|	password	|	toDoType	|	filterBy	|	user		|
|	CPCI038AssigningToDoEntriesToSupervisor	|	SYSUSER		|	sysuser00	|	BILLING		|	All			|	AGAMBATE	|