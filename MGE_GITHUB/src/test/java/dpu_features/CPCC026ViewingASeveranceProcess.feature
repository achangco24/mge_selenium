Feature: CPCC021 Credit & Collections
Scenario Outline: Viewing a Severance Process Event

#####################################################################################
#
# CHANGE HISTORY:                                                
#                                                                
# Date:       	by:    		Reason:                                     
# 2020-05-14	RExtra		Initial Version.
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
And Navigate to Severance Process via Dashboard Alert
And Switch to Severance Process Events Tab
And Find Severance Process Event Sequence <eventSequence>
And User logout CC&B

Examples:
|testName|username|password|searchType|accountId|eventSequence|
|CPCC026ViewingASeveranceProcess|SYSUSER|SysUser00|Account ID|2494051111|5|
