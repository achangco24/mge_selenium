Feature: CPCC007 Credit & Collections
Scenario Outline: Adding a Write Off Process

#####################################################################################
#
# CHANGE HISTORY:                                                
#                                                                
# Date:       	by:    		Reason:                                     
# 2020-05-12	RExtra		Initial Version.
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
And Navigate to Add Write Off Process
And Select <writeOffControl> Write Off Control
And Select <writeOffProcTmplt> Write Off Process Template
And Add Write Off Process Comments <comments>
And Switch to Write Off SA Tab
And Link <saID> as Write Off SA
And Verify Write Off Status
And Save Write Off Process <mode>
And User logout CC&B

Examples:
|testName|username|password|searchType|accountId|writeOffControl|comments|writeOffProcTmplt|saID|mode|
|CPCC007AddingAWriteOffProcess|SYSUSER|SysUser00|Account ID|6831751111|RES ELEC WO|Selenium Test|Write Off Electric|6830558694|Add|
