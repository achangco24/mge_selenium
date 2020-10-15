Feature: CPCI009 Customer Information
Scenario Outline: Adding a Service Point Record

#####################################################################################
#
# CHANGE HISTORY:                                                
#                                                                
# Date:       	by:    		Reason:                                     
# 2020-06-09	RExtra		Initial Version.
# 2020-07-01	RExtra		CP_FS.009	Modified Save Step to be reusable to save
#										and update
#
#####################################################################################

Given User is on CC&B
When User login into CC&B with <username> and <password>
And Log Test Name as <testName>
And Navigate to Premise search page
And Search Premise ID in search pop-up window as <premId>
And Add Service Point From Premise Context Menu
And Enter SP Type as <spType>
And Enter Meter Location as <meterLocation>
And Enter Service Cycle as <serviceCycle>
And Enter Service Route as <serviceRoute>

#CP_FS.009 - 2020-07-01 - Start Change 
#Then Service Point record is saved
Then Service Point record is saved <mode>
#CP_FS.009 - 2020-07-01 - End Change

And User logout CC&B

Examples:
|testName|username|password|premId|spType|meterLocation|serviceCycle|serviceRoute|mode|
|CPCI009AddingAServicePointRecord|SYSUSER|SysUser00|0348541111|E-RES|9|EM08|3399|Update|
