Feature: PY022 Add Transfer Adjustment
Scenario Outline: Test the functionality of adding transfer adjustment

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
And From Account Context Menu go to Adjustment add
And Set Adjustment Type as <adjType>
And Enter Adjustment Amount as <amount>
And Enter Adjustment Comments as <comment>
And Switch to Transfer Adjustment Tab
And Enter Adjustment Transfer Service Agreement ID as <transferSaId>
And Enter Adjustment Transfer Comments as <comment2>
And Click Adjustment Generate button
Then Click Adjustment Freeze button
And User logout CC&B

Examples:
|	username	|	password	|	searchType	|	accountId	|	adjType	|	amount	|	transferSaId	|	comment																	|	comment2																|
|	SYSUSER		|	sysuser00	|	Account ID	|	4141950013	|	XFER	|	50		|	3894251600		|	This is auto-generated data creation made by Selenium Automation Tool	|	This is auto-generated data creation made by Selenium Automation Tool	|
