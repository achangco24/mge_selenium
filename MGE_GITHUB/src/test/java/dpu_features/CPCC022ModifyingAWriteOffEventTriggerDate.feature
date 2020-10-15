Feature: CPCC022 Credit & Collections
Scenario Outline: Modifying a Write Off Process Event

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
And Navigate to Write Off Process via Dashboard Alert
And Add Write Off Process Modification Comments <comments>
And Switch to Write Off Process Events Tab
And Find Write Off Process Event Sequence <eventSequence>
And Enter New Write Off Process Event Trigger Date <newTriggerDate>
And Save Write Off Process <mode>
And User logout CC&B

Examples:
