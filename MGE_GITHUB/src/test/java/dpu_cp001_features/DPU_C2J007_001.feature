#Author: EY_PHADV_Manila_Testing.GID@ey.net
Feature: Person Address Override Change Handler
Scenario Outline: Change handler program for Person Address Override information for City and Address1 field 
Given DPU_C2J007 User is on CC&B
When DPU_C2J007 User login into CC&B with <username> and <password>
And DPU_C2J007 Navigate to Control Central page
And DPU_C2J007 Select Search By as <searchType> 
And DPU_C2J007 Search Account ID as <account>
And DPU_C2J007 Enter Service Agreement ID with SA ID as <said> 
And DPU_C2J007 Enter Adjustment Type with Adjustment Type as <adjType>
And DPU_C2J007 Enter Adjustment Amount with Adjustment Amount as <amount>
Then DPU_C2J007 Adjustment record is saved
Then DPU_C2J007 Adjustment record is deleted
And DPU_C2J007 User logout CC&B

Examples:
|	username	|	password	|	searchType		|	account			|	amount	|
|	SYSUSER		|	sysuser00	|	Account ID		|	0014110000		|	25			|