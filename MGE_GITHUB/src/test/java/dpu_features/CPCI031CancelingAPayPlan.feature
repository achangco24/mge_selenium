Feature: CPCI031 Credit & Collection
Scenario Outline: Canceling a Pay Plan

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
And Navigate to Control Central page
And Select Search By as <searchType>

#Temporary Step -- Remove before deployment to production
And Select CPP for CIS Division

And Search Account ID as <accountId>
And Navigate to Pay Plan via Dashboard Alert
And Enter Pay Plan Comments <comments>
And Click on Cancel Pay Plan

And Navigate to Add Customer Contact from Pay Plan Account Context Menu
And Select Contact Class as <contactClass>
And Enter Contact Type as <contactType>
Then Customer Contact record is saved
And User logout CC&B

Examples:
|testName|username|password|searchType|accountId|comments|contactClass|contactType|
|CPCI031CancelingAPayPlan|SYSUSER|SysUser00|Account ID|0744650000|Cancel Pay Plan|Credit and Collections contacts|MISINFO|
