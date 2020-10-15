Feature: MT003 Add Meter Read
Scenario Outline: Test the functionality of adding meter read

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
And Search Account ID as <accountId>
And From Premise Context Menu go to Service Point search
And From SP Context Menu go to Meter Read add
And Enter Meter Read Date as <readDate>
And Select Register Read Type as <regType>
And Enter Register Reading as <regRead>
Then Meter Read record is saved
And User logout CC&B

Examples:
|	username	|	password	|	searchType	|	accountId	|	readDate	|	regType	|	regRead	|
|	SYSUSER		|	sysuser00	|	Account ID	|	3072140000	|	04-02-2019	|	Regular	|	30		|