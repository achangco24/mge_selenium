Feature: CPBI001 Billing
Scenario Outline: Manually Generating a Bill

#####################################################################################
#
# Author: EY_PHADV_Manila_Testing.GID@ey.net
#
# CHANGE HISTORY:                                                
#                                                                
# Date:       	by:    		Reason:                                     
# 2020-07-07	RExtra		CP_BI.001	Add components to Manually Generate a Bill
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
And Navigate to Add Meter Read
And Enter Meter Read Date as <readDate> <addDays>
And Select Register Read Type as <regType>
And Enter Register Reading as <meterRead> <addMeterRead>
And Navigate to Add Bill thru Current Account Context Menu
And Generate Bill
And Enter Cutoff Date in Generate Bill Popup as <cutOff>
And Freeze Bill
And Complete Bill

And User logout CC&B

Examples:
|testName|username|password|searchType|accountId|readDate|addDays|regType|meterRead|addMeterRead|cutOff|
|CPBI001ManuallyGeneratingABill|SYSUSER|SysUser00|Account ID|7133080000|06-12-2020|15|Regular|42188|250|08-17-2020|
