Feature: Search FT
Scenario Outline: Search FT City Code in CC&B
Given User is on CC&B
When User login into CC&B with <username> and <password>
And Navigate to Financial Transaction page
And Search FT ID <ft_id> in pop-up window
And From Context Menu click Premise link
And Go to Premise Characteristics tab
Then Check City Code Premise Characteristics is equal to Char Type <char_type> and Char Val <char_value>
And Logout

Examples:
|username 	|password	|ft_id			|char_type			|char_value	|
|SYSUSER	|sysuser00	|166337079888	|Taxing State		|OH			|
|SYSUSER	|sysuser00	|000006735886	|Taxing City		|NCANTON	|