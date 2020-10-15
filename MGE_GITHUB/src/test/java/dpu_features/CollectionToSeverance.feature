Feature: Collection To Severance
Scenario Outline: Confirm the functionality of turning a collections process into a severance process.

#####################################################################################
#
# Author: EY_PHADV_Manila_Testing.GID@ey.net
#
# CHANGE HISTORY:                                                
#                                                                
# Date:       	by:    		Reason:                                     
# YYYY-MM-DD	IN			Reason text.
#
#####################################################################################

Given User is on CC&B
When User login into CC&B with <username> and <password>
And Navigate to Collection Search
And Search Collection from popup as <collectionId>
And Navigate to Batch Job Submission page
And Enter Batch Code as <batchCd>
And Enter Batch Business Date as <batchDate>
And Click Duplicate and Queue button
And Verify Batch Job Status is "Ended"
And User logout CC&B

Examples:
|	username	|	password	|	batchCd		| collectionId | 	batchDate      |
|	SYSUSER		|	sysuser00	|	CET			| 4240906302   |	12-10-2019     |
