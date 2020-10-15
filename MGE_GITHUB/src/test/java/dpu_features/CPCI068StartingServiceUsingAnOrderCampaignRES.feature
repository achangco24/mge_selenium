Feature: CPCI068 Customer Information
Scenario Outline: Starting Service Using an Order/Campaign RES

#####################################################################################
#
# CHANGE HISTORY:                                                
#                                                                
# Date:       	by:    		Reason:                                     
# 2020-07-14	RExtra		CP_CI.068	Add components for Starting Service Using an
#										Order/Campaign RES
#
#####################################################################################

Given User is on CC&B
When User login into CC&B with <username> and <password>
And Log Test Name as <testName>
And Navigate to Premise search page
And Search Premise ID in search pop-up window as <premId>
And From Premise Context Menu go to Order add
And Enter Campaign as <campaign>
And Enter Start Date as Sytem Date
And Select Person Information as <perInfoFlg>
And Select Person Name Type as <perNameType>
And Enter Order Person Name as <perName>
And Select Order Person Contact Type as <perContactType>
And Enter Order Person Contact Info as <perContactInfo>
And Tick as Order Primary Person Contact
And Select Account Information as <acctInfoFlg>
And Select Order Customer Class as <custClass>
Then Order record is saved
And Switch to Questions and Misc Fields Tab
And Answer RES Order Questions Mode <mode> - Answers <q0>,<q1>,<q2>,<q3>,<q4>,<q5>,<q6>,<q7>
And Click Show Eligibility button
And Click the package created
And Click Complete button
And Verify RES CPP Order Completion

And User logout CC&B

#mode	: [DEFAULT], [MANUAL]
#q0-q7	: Use '~' to leave answers as Blank
Examples:
|testName|username|password|premId|campaign|perInfoFlg|perNameType|perName|perContactType|perContactInfo|acctInfoFlg|custClass|mode|q0|q1|q2|q3|q4|q5|q6|q7|
|CPCI068StartingServiceUsingAnOrderCampaignRES|SYSUSER|sysuser00|7711540000|RES-CPPSTRT|Create New Person|Primary|TEST, RESPERD|Cell Phone|(678) 495-4444|Create New Account|Electric Residential|DEFAULT|~|~|~|~|~|~|~|~|
