Feature: CPFIN26 Financials
Scenario Outline: Transferring of Balance

#####################################################################################
#
# CHANGE HISTORY:                                                
#                                                                
# Date:       	by:    		Reason:                                     
# 2020-07-09	RExtra		CP_FIN.26	Add components for Transferring of Balance
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
#And Navigate to Search SA thru Account Context Menu
And Navigate to Add Adjustment
And Set Adjustment Type as <adjustmentType>
And Enter Adjustment Amount as <amount>
And Enter Adjustment Comments as <comments>
And Switch to Transfer Adjustment Tab
And Enter Adjustment Transfer Service Agreement ID as <transferSaId>
And Enter Adjustment Transfer Comments as <comment2>
And Click Adjustment Generate button
Then Click Adjustment Freeze button
And User logout CC&B

Examples:
|testName|username|password|searchType|accountId|adjustmentType|amount|comments|transferSaId|comment2|
|CPFIN26TransferringOfBalance|SYSUSER|SysUser00|Account ID|2799941111|E-XFER|$5.00|Selenium Testing|2790498059|Selenium Testing|
