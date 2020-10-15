#Author: EY_PHADV_Manila_Testing.GID@ey.net
Feature: Adjustment Maintenance Extension
Scenario Outline: User has the authority to CREATE Adjustment
Given DPU_C2J001 User is on CC&B
When DPU_C2J001 User login into CC&B with <username> and <password>
And DPU_C2J001 Navigate to Adjustment page
And DPU_C2J001 Enter Service Agreement ID with SA ID as <said> 
And DPU_C2J001 Enter Adjustment Type with Adjustment Type as <adjType>
And DPU_C2J001 Enter Adjustment Amount with Adjustment Amount as <amount>
Then DPU_C2J001 Adjustment record is saved
Then DPU_C2J001 Adjustment record is deleted
And DPU_C2J001 User logout CC&B

Examples:
|	username	|	password	|	said				|	adjType		|	amount	|
|	SYSUSER		|	sysuser00	|	5317274395	|	MTRTEST		|	25			|