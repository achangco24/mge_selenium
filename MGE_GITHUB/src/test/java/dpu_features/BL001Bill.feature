Feature: BL001 Bill
Scenario Outline: Test the functionality to calculate one month bill for CWD and NEORSD account.

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
And Navigate to Add Account Billing
And Generate Bill
And Enter Cutoff Date in Generate Bill Popup as <cutoff>
And Freeze Bill
And Navigate to CalcLines
And User logout CC&B

Examples:
| username	| password	| searchType	|	accountId	| cutoff      |
| SYSUSER	| sysuser00 | Account ID 	|	2542350001  | 12-10-2019  |