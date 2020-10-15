Feature: SS011 Campaigns
Scenario Outline: Confirm the functionality of campaigns with a CWD and NEORSD account with a deposit

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
And Navigate to Control Central page
And Select Search By as <searchType>
And Search Account ID as <accountId>
And From Control Premise Context Menu go to Order add
And Enter Order Names as <personName>
And Order record is saved
And Switch to Questions and Misc Fields Tab
And Change the answer of “Is this request for a Tenant” to "Y"
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
#And From Alerts Dashboard click "Premise Has Multiple Accounts" link
#And Collapse Premise Node Tree
And User logout CC&B

Examples:
|	username	|	password	|	searchType	|	accountId	|	personName	  |	batchCd	|	batchDate	|	searchType			|
|	SYSUSER		|	sysuser00	|	Account ID	|	2448986093	|	Bersham,Chris |	SAACT	|	11-14-2011	|	Name and Address	|