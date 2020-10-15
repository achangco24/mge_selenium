Feature: CPFIN11 Financials
Scenario Outline: Canceling Auto Pay

#####################################################################################
#
# CHANGE HISTORY:                                                
#                                                                
# Date:       	by:    		Reason:                                     
# 2020-06-03	RExtra		Initial Version.
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
And Add Another Payment Event Entry
And Enter Other Amount <amount>
And Enter Other Account ID <acctID2>

#
And Switch to Tenders Tab
And Add New Tender
And Enter Payor Acct ID as <acctID2>
And Enter Payment Date as <date>
And Select Tender Type as <tenderType>
And Enter Tender Amount as <amount>

#And Save Payment Event
And Switch to Payment Event Main Tab
#
And Distribute Payment Event
And Freeze Payment Event
And User logout CC&B

Examples:
|	testName									|	username	|	password	|	searchType	|	accountId		|	date		|	distributionCode	|	acctID2			|	amount		|	tenderType	|
#|	CPFIN09AddingAPaymentToMultipleAccounts		|	SYSUSER		|	SysUser00	| 	Account ID  | 	0067051111 		|	06-30-2020	|	Do not Distribute	|	0112460000		|	$157.49		|	Check		|
|	CPFIN09AddingAPaymentToMultipleAccounts		|	SYSUSER		|	sysuser00	| 	Account ID  | 	5310450000 		|	07-17-2020	|	Do not Distribute	|	4050051111		|	$148.34		|	Check		|