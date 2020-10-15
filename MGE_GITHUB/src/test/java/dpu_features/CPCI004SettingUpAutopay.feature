Feature: CPCI004 Customer Information
Scenario Outline: Setting up Autopay

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
And Navigate to Account thru Context Menu
And Switch to Auto Pay Tab
And Enter Auto Pay Start Date <startDate>
And Enter Auto Pay Source Code <sourceCode>
And Enter Auto Pay External Account ID <externalAcctID>
And Enter Auto Pay Name <name>
And User logout CC&B

Examples:
|testName|username|password|searchType|accountId|startDate|sourceCode|externalAcctID|name|
|CPCI004SettingUpAutopay|SYSUSER|SysUser00|Account ID|0000261111|08-20-2020|CPPDOLLARBNK|1234567890|CPP, CPP|
