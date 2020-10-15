Feature: Severance Door Hanger
Scenario Outline: Confirm that the door hanger FA is being successfully deployed from the severance process.

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
And Navigate to Severance Search Page
And Search Severance in Popup as <procID1>
And Select Awaiting Field Activity
And Search Pending Field Activity in search pop-up window
And Click Complete button for Field Activity
And Navigate to Batch Job Submission page
And Enter Batch Code as <batchCd1>
And Enter Batch Business Date as <batchDate>
And Click Duplicate and Queue button
And Verify Batch Job Status is "Ended" 
And Enter Batch Code as <batchCd2>
And Click Duplicate and Queue button
And Verify Batch Job Status is "Ended" 
And Enter Batch Code as <batchCd3>
And Click Duplicate and Queue button
And Verify Batch Job Status is "Ended" 
And Navigate from another page to Severance Search Page
And Search Severance in Popup as <procID2>
And User logout CC&B

Examples:
|	username	|	password	|	batchCd1	|	batchCd2	|	batchCd3	|	batchDate		|	procID1		| procID2	 |
|	SYSUSER		|	sysuser00	|	SEC			|	SED			|	SET			|	11-06-19		|	5739210218	| 5739210218 |
