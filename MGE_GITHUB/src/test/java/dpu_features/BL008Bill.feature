Feature: BL008 Bill
Scenario Outline: Test the functionality to cancel and rebill.

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
And Click Last Meter Read
And Add Meter Reading as <regReading>
And Cancel/Rebill/Freeze
And User logout CC&B

Examples:
|	username	|	password	|	searchType	|	accountId	| regReading |
|	SYSUSER		|	sysuser00	|	Account ID	|	2891030000  | 36		 |