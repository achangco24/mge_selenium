Feature: CPCC003 Credit & Collections
Scenario Outline: Adding a Collection Process

#####################################################################################
#
# CHANGE HISTORY:                                                
#                                                                
# Date:       	by:    		Reason:                                     
# 2020-05-05	RExtra		Initial Version.
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
And Navigate to Add Collection Process
And Enter Collection Class Control code <collClassCtrlCode> and Search
And Select <collProcTemplate> Collection Process Template
And Enter Collection Amount Base Date
And Set Collection <daysInArrears> Days in Arrears
And Add Collection Process Comment <comment>
And Switch to SA Tab
And Link SA <saID>
And Select SA Status
And Save Collection Process <mode>
And User logout CC&B

Examples:
|testName|username|password|searchType|accountId|collClassCtrlCode|collProcTemplate|daysInArrears|comment|saID|mode|
|CPCC003AddingACollectionProcess|SYSUSER|SysUser00|Account ID|0090850000|E-RES-REGULAR|CPP COLLECTIONS TIER1|40|Selenium Test|0090588896|Add|
