Feature: CI018 Automated Payment Arrangement Customization
Scenario Outline: Test the functionality of Account with a current balance>0 without a payment arrangement and a City of Cleveland City Code (001000)

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
And From Account Context Menu go to Automated Payment Arrangement
And Enter Payment Arrangement Installments as <installment>
Then Click Create Pay Arrangement button
And User logout CC&B

Examples:
|	username	|	password	|	searchType	|	accountId	|	installment	|	
|	SYSUSER		|	sysuser00	|	Account ID	|	3280700000	|	6			|	
