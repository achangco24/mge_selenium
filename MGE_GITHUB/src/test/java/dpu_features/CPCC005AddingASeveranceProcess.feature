Feature: CPCC005 Credit & Collections
Scenario Outline: Adding a Severance Process

#####################################################################################
#
# CHANGE HISTORY:                                                
#                                                                
# Date:       	by:    		Reason:                                     
# 2020-05-06	RExtra		Initial Version.
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
And Navigate to Add Severance Process
#Temp Step
And Select Severance Process SA <saID>
And Select <sevProcTemplate> Severance Process Template
And Enter Severance Amount Base Date
And Set Severance <daysInArrears> Days in Arrears
And Add Severance Process Comment <comment>
And Save Severance Process <mode>
And User logout CC&B

Examples:
|testName|username|password|searchType|accountId|saID|sevProcTemplate|daysInArrears|comment|mode|
|CPCC005AddingASeveranceProcess|SYSUSER|SysUser00|Account ID|0027741111|0020470620|Stormwater Only Severance Lien|40|Selenium Test Add SEVPROC|Add|
