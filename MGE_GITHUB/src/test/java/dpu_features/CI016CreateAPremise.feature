Feature: CI016 Premise
Scenario Outline: Create a Premise

#####################################################################################
#
# CHANGE HISTORY:                                                
#                                                                
# Date:       	by:    		Reason:                                     
# 2020-04-07	GSando		Initial Version.
#
#####################################################################################

Given User is on CC&B
When User login into CC&B with <username> and <password>
#And Navigate to Premise page
#And Select Premise Type as <premType>
#And Select Cis Division as <cisDiv>
#And Enter Premise Address as <address1>
#And Enter Premise City as <cityField>
#And Enter State as <state>
#And Switch to Premise Misc Tab
#And Select Trend Area as <trendArea>
#And Switch to Premise Characteristics Tab
#And Enter Premise Characteristics Type as <premChar> at index "0"
#And Enter Premise Characteristics Value as <charVal> at index "0"
#And Click Add Premise Characteristics icon
#And Enter Premise Characteristics Type as <premChar1> at index "1"
#And Enter Premise Characteristics Value as <charVal1> at index "1"
#And Switch to Premise Geo Tab
#And Enter Premise Geographic Type as <premGeoType> at index "0"
#And Enter Premise Geographic Value as <premGeoVal> at index "0"
#Then Premise record is saved
#And User logout CC&B

Examples:
|testName|username|password|premType|cisDiv|address1|cityField|state|trendArea|premChar|charVal|premChar1|charVal1|premGeoType|premGeoVal|
|CI016CreateAPremise|SYSUSER|SysUser00|Single family home|Cleveland|448 Main Street|Cleveland|OH|Cleveland Metropolitan Area|City Code|001000|Level|C1|Street Name|Main|
