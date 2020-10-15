Feature: Create New Person
Scenario Outline: Create New Person in CC&B
Given User is on CC&B
When User login into CC&B with <username> and <password>
And Navigate to Customer Page
And Enter Person Names Table with Person Name as <person_name>
And Select Person Contacts Table with Contact Type as <contact_type>
And Enter Person Contacts Table with Contact Number as <contact_number>
And Set Person Contact Table with Primary Contact as "true"
And Set Person ID Table with ID Type as <id_type>
And Set Person ID Table with ID number as <id_number>
And Set Person ID Table with Primary ID as "true"
Then Person Contact must be Saved
And Logout

Examples:
|username 	|password	|person_name		|contact_type	|contact_number 	|id_type			|id_number		|
|SYSUSER	|sysuser00	|Miyuki,Kobayakawa	|Home Phone		|(888) 888-8977		|Drivers license	|725S7199890	|