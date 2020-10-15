Feature: Break Payment Arrangement
Scenario Outline: Confirm that the break payment arrangement button working correctly.

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
And Navigate to Service Agreement search page
And Search Service Agreement ID in search pop-up window as <saId>
And From Account Context Menu go to Payment Arrangement Break
Then Click Break Pay Arrangement button
And User logout CC&B

Examples:
|	username	|	password	|	searchType	|	accountId	|	saId		|
|	SYSUSER		|	sysuser00	|	Account ID	|	3280700000	|	3280247370	|
