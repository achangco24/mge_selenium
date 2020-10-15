Feature: MT003 Meter Read
Scenario Outline: Add a meter read - CWD and CPP

#####################################################################################
#
# CHANGE HISTORY:                                                
#                                                                
# Date:       	by:    		Reason:                                     
# 2020-04-17	GSando		Initial Version.
#
#####################################################################################

Given User is on CC&B
When User login into CC&B with <username> and <password>
And Log Test Name as <testName>
And Navigate to Control Central page
And Select Search By as <searchType>
And Select CWD for CIS Division
And Search Account ID as <accountId>
And From Premise Context Menu go to Service Point search
And Select SP Type as <spType> and Service Point Status as <spStatus>
And From SP Context Menu go to Meter Read add
And Enter Meter Read Date as <readDate> <addDays>
And Select Register Read Type as <regType>
And Enter Register Reading as <regRead> <addMeterRead>
Then Meter Read record is saved
And User logout CC&B

Examples:
|testName|username|password|searchType|accountId|spType|spStatus|readDate|addDays|regType|regRead|addMeterRead|
|MT003AddAMeterRead|SYSUSER|sysuser00|Account ID|2372964360|Water / Waste Water - Small Residential|In Service|06-04-2020|15|Regular|78.5|50.0|
