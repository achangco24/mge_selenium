Feature: CPCC019 Credit & Collections
Scenario Outline: Manually Adding Credit Points

#####################################################################################
#
# CHANGE HISTORY:                                                
#                                                                
# Date:       	by:    		Reason:                                     
# 2020-05-13	RExtra		Initial Version.
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
And Switch to C&C Tab
#And Add Credit Rating History
And Enter Credit Rating History Start Date
And Add <rollOffDays> to Credit Rating History End Date
And Enter <credits> Credit Rating
And Add C&C Comments <comments>
And Save Credit Rating History
And User logout CC&B
		
Examples:
|testName|username|password|searchType|accountId|rollOffDays|credits|comments|
|CPCC019ManuallyAddingCreditPoints|SYSUSER|SysUser00|Account ID|0073641111|7|12|Selenium Test|
