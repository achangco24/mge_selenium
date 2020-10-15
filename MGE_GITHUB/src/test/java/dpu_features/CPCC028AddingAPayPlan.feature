Feature: CPCC028 Credit & Collection
Scenario Outline: Adding a Pay Plan

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
And Navigate to Control Central page
And Select Search By as <searchType>

#Temporary Step -- Remove before deployment to production
And Select CPP for CIS Division

And Search Account ID as <accountId>
And Navigate to Add Pay Plan
And Enter <ppType> as Pay Plan Type
And Set Pay Method as <payMethod>
And Enter Scheduled Date as <schedDate>
And Enter Scheduled Amount as <schedAmt> 
And Enter Pay Plan Comments <comments>
And Save Pay Plan

And Navigate to Add Customer Contact from Pay Plan Account Context Menu
#And Enter Person ID as <personID>
And Select Contact Class as <contactClass>
And Enter Contact Type as <contactType>
Then Customer Contact record is saved
And User logout CC&B

Examples:
|testName|username|password|searchType|accountId|ppType|payMethod|schedDate|schedAmt|comments|contactClass|contactType|
|CPCC028AddingAPayPlan|SYSUSER|SysUser00|Account ID|2963941111|ELECTRIC|Voucher|08-20-2020|1238.37|Selenium Test|Customer Service|ANONYMOUS|
