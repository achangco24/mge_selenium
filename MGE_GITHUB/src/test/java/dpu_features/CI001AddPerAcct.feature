Feature: CI001 Add a New Person and Account
Scenario Outline: UVT - Add a New Person and Account

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
And Navigate to Control Central page
And Select Search By as <searchType>
And Enter lastname first with a comma no space then first name in Name field as <personName>
And Click Add Person icon
And Select Person/Business as <personBusiness>
And Select Person Contact Type as <contactType>
And Enter Person Contact Information as <contactNo>
And Set Person Primary Contact as "true"
And Select Person ID Type as <idType>
And Enter Person ID number as <idNo>
And Set Person Primary ID as "true"
And Set Add Account/Start Service as "true"
Then Person record is saved
And User logout CC&B

Examples:
|	username	|	password	|	searchType			|	personName		|	personBusiness	|	contactType	|	contactNo		|	idType			|	idNo		|
|	SYSUSER		|	sysuser00	|	Name and Address	|	Simon,Maxx		|	Person			|	Home Phone	|	(485) 931-4920	|	Drivers license	|	725S7193541	|