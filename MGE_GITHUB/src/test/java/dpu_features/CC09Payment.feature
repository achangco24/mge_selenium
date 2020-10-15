Feature: CC09 Payment
Scenario Outline: After making full payment, Severance Process is cancelled

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
And Search Severance in Popup as <procID>
And Navigate from Account Context Menu to Control Central
And Navigate from Account Context Menu to Service Agreement
And Select Service Agreement
And Navigate to Add Payment Event
And Set amount for Add Payment Event as <amount>
And Select last Severance
And User logout CC&B

Examples:
|	username	|	password	|	procID		|	amount		| 
|	SYSUSER		|	sysuser00	|	3512466594	|	-159.36		| 
