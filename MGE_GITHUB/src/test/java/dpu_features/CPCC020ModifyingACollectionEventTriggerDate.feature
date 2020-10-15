Feature: CPCC020 Credit & Collections
Scenario Outline: Modifying a Collection Process Event

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
And Navigate to Collection Process via Dashboard Alert
And Add Collection Process Modification Comments <comments>
And Switch to Collection Process Events Tab
And Find Collection Process Event Sequence <eventSequence>
And Enter New Collection Process Event Trigger Date <newTriggerDate>
And Save Collection Process <mode>
And User logout CC&B

Examples:
