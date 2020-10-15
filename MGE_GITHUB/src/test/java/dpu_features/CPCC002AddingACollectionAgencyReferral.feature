Feature: CPCC002 Credit and Collection
Scenario Outline: Adding a Collection Agency Referral

#####################################################################################
#
# CHANGE HISTORY:                                                
#                                                                
# Date:       	by:    		Reason:                                     
# 2020-06-30	RExtra		Initial Version.
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
And Navigate to Add Collection Agency Referral
And Enter Collection Agency as <collAgency>
And Set Start Date as Current Date
And Set Referral Status as <status>

And Enter Collection Agency Referral Comments as <comments>
And Set Creation Date as <creationDate>
And Set Referral Amount as <referralAmt>
And Set	Referral History Reason as <referralRsn> 
Then Collection Agency Referral is saved
And User logout CC&B

Examples:
|testName|username|password|searchType|accountId|collAgency|status|comments|creationDate|referralAmt|referralRsn|
|CPCC002AddingACollectionAgencyReferral|SYSUSER|SysUser00|Account ID|0000751111|CPPCOLAG|Active|Selenium Test|08-20-2020|$20.00|Initial Referral|
