Feature: CPCI030 Credit & Collection
Scenario Outline: Adding a Payment Arrangement Request

#####################################################################################
#
# CHANGE HISTORY:                                                
#                                                                
# Date:       	by:    		Reason:                                     
# 2020-07-13	RExtra		Initial Version.
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
And Navigate to Add Payment Arrangement Request
And Select Payment Arrangement Request Type as <payArrReqType>
And Check Payment Arrangment Request Elegibility
And Enter Number of Installments as <numbOfInstallments>
And Finish Adding Payment Arrangement Request
And Navigate to Payment Arrangement Request thru Alert Link
And User logout CC&B

Examples:
|testName|username|password|searchType|accountId|payArrReqType|numbOfInstallments|
|CPCI030AddingAPaymentArrangementRequest|SYSUSER|SysUser00|Account ID|0000151111|PA - Select SAs / Down Payment Optional / Elig Crit / No Approval|3|
