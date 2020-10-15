Feature: CPFIN12 Financials
Scenario Outline: Adding & Manually Distributing a Payment

#####################################################################################
#
# CHANGE HISTORY:                                                
#                                                                
# Date:       	by:    		Reason:                                     
# 2020-06-03	RExtra		CP_FIN.12	Initial Version.
#
#####################################################################################

Given User is on CC&B
When User login into CC&B with <username> and <password>
And Log Test Name as <testName>
And Navigate to Control Central page
And Select Search By as <searchType>
#Temporary Step -- Remove before deployment to production
And Select CPP for CIS Division
And Search Account ID as <accountId>
And SA Financial History Navigate to Add Payment Event
And Add Payment with Payment Date <date> and Distribution Code <distributionCode>
And Distribute Amount <amount> to SAs
And Distribute Payment
And Freeze Payment
And User logout CC&B

Examples:
|	testName										|	username	|	password	|	searchType	|	accountId		|	date		|	distributionCode		|	amount		|
|	CPFIN12AddingAndManuallyDistributingAPayment	|	SYSUSER		|	sysuser00	| 	Account ID  | 	5521270000 		|	07-17-2020	|	Manual Distribution		|	$5.00		|