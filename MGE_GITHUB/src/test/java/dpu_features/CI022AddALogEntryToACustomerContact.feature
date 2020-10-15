Feature: CI022 Customer Contact
Scenario Outline: Adding a Log Entry to a Customer Contact.

#####################################################################################
#
# CHANGE HISTORY:                                                
#                                                                
# Date:       	by:    		Reason:                                     
# 2020-04-16	GSando		Initial Version.
#
#####################################################################################

Given User is on CC&B
When User login into CC&B with <username> and <password>
And Log Test Name as <testName>
And Navigate to Customer Contact search page
And Search Customer Contact ID in pop-up window as <ccId>
And Switch to Log Tab
And Add Log Entry as <comment>
Then Customer Contact record is saved
And User logout CC&B

Examples:
|testName|username|password|ccId|comment|
|CI022AddALogEntryToACustomerContact|SYSUSER|SysUser00|0000001273|Selenium Comment|
