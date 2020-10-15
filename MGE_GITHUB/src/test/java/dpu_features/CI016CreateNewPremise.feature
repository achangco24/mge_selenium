Feature: CI016 Create New Premise
Scenario Outline: Create New Premise with multiple characteristics

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
And Navigate to Premise page
And Select Premise Type as <premiseType>
And Enter Premise Postal as <postal>
And Switch to Premise Geo Tab
#And Enter Premise Timezone as <timezone>
And Enter Premise Geographic Type as <premGeoType1> at index "0"
And Enter Premise Geographic Value as <premGeoVal1> at index "0"
And Switch to Premise Characteristics Tab
And Enter Effective Date as <date> at index "0"
And Enter Premise Characteristics Type as <premCharType> at index "0"
And Enter Premise Characteristics Value as <premCharVal> at index "0"
And Click Add Premise Characteristics icon
And Enter Effective Date as <date1> at index "1"
And Enter Premise Characteristics Type as <premCharType1> at index "1"
And Enter Premise Characteristics Value as <premCharVal1> at index "1"
And Click Add Premise Characteristics icon
And Enter Effective Date as <date> at index "2"
And Enter Premise Characteristics Type as <premCharType2> at index "2"
And Enter Premise Characteristics Value as <premCharVal2> at index "2"
And Switch to Premise Main Tab
And Enter Premise Address as <address>
And Enter Premise City as <city>
And Switch to Premise Misc Tab
And Select Trend Area as <area>
And Switch to Premise Main Tab
Then Premise record is saved
And User logout CC&B

Examples:
|	username	|	password	|	premiseType			|	postal		|	address						|	city		|	county		|	area						|	date		|	premCharType		|	premCharVal	|	date1		|	premCharType1	|	premCharVal1	| premCharType2 | premCharVal2 | premGeoType1       | premGeoVal1 | timezone            |
|	SYSUSER		|	sysuser00	|	Single family home	|	44111-5275	|	3303 E 200 ST (TestPremise)	|	CLEVELAND	|	Cuyahoga	|	Cleveland Metropolitan Area	|	10-01-2019	|	Abandoned Property	|	NO			|	10-01-2019	|	City Code		|	001000			|	Level       | C1           | Latitude-Longitude | 00000001    |	US Eastern Time		|