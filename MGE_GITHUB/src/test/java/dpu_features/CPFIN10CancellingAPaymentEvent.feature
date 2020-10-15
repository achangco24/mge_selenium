Feature: CPFIN08 Financials
Scenario Outline: Adding a Payment Event

#####################################################################################
#
# CHANGE HISTORY:                                                
#                                                                
# Date:       	by:    		Reason:                                     
# 2020-06-02	RExtra		CP_FIN.10	Initial Version.
#
#####################################################################################

Given User is on CC&B
When User login into CC&B with <username> and <password>
And Log Test Name as <testName>
And Navigate to Control Central page
And Select Search By as <searchType>
And Search Account ID as <accountId>
And Search Payment Event
And Switch to Tenders Tab
#And Tick Include in Tender Control Balance as "true"
And Cancel Payment Tender <reason>
And User logout CC&B

Examples:
|	testName						|	username	|	password	|	searchType	|	accountId		|	reason			|
#|	CPFIN10CancellingAPaymentEvent	|	SYSUSER		|	SysUser00	| 	Account ID  | 	0036941111 		|	Cashier void	|
|	CPFIN10CancellingAPaymentEvent	|	SYSUSER		|	sysuser00	| 	Account ID  | 	5140360000 		|	Cashier void	|