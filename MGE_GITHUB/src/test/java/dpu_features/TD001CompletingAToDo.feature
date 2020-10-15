Feature: TD.001 To Do Entry
Scenario Outline: Completing a To Do

#####################################################################################
#
# CHANGE HISTORY:                                                
#                                                                
# Date:       	by:    		Reason:                                     
# 2020-04-30	GSando		Initial Version.
# 2020-07-27	RExtra		Update steps to accomodate SQL Integration for Input
#
#####################################################################################

Given User is on CC&B
When User login into CC&B with <username> and <password>
And Log Test Name as <testName>
And Navigate to To Do Entry Search
And Search To Do with ID <toDoId>
#And Navigate to To Do Summary page
#And Select an Open To Do
#And Select To Do as <toDoId>
And Enter To Do Entry Comment as <comment>
And Click Complete Button for To Do Entry
And User logout CC&B

Examples:
