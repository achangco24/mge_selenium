Feature: SS007 Campaigns
Scenario Outline: Confirm the functionality of campaigns with City of Cleveland city code

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
And Navigate to Premise search page
And Search Premise ID in search pop-up window as <premId>
And Switch to Premise Characteristics Tab
And Verify Premise Characteristics Type as <premCharType> has Premise Characteristics Value as <premCharVal>
And From Premise Context Menu go to Order add
And Enter Order Names as <personName>
And Order record is saved
And Switch to Questions and Misc Fields Tab
And Click Show Eligibility button
And Click the package created
And Click Complete button
And From Alerts Dashboard click "Field Activity Pending" link
And Search Pending Field Activity in search pop-up window
And Click Complete button for Field Activity 
And Navigate to Batch Job Submission page
And Enter Batch Code as <batchCd>
#And Enter Batch Business Date as <batchDate>
And Click Duplicate and Queue button
And Verify Batch Job Status is "Ended"
And From Alerts Dashboard click "Premise Has Multiple Accounts" link
And Collapse Premise Node Tree
And User logout CC&B

Examples:
|	username	|	password	|	premId		|	premCharType	|	premCharVal	|	personName		|	batchCd	|	batchDate	|	searchType			|
|	SYSUSER		|	sysuser00	|	2920911525	|	City Code		|	001000		|	Brook,Rocky III	|	SAACT	|	11-14-2011	|	Name and Address	|