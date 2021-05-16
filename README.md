# APIAutomationSwaggerPet
Automation of the Swagger API (Pet module):
Project  Name : 
	SwaggerPetProject
Tools used : 
	Eclipse IDE
Project details: 
	This is a Java(Maven) project 
	TestNG is used better organization od testcases and execution
	 RestAssured  (it is an API which is designed to automate Rest API/ Rest  API's) is 	used to Automation
Components of the Projects: 
	ApiMethods : 
	These are the API methods which are created for each and every API request, these 	can ce executed as a Indivudal test as well
	testng.xml:
	This file contains the Test Suite with a list of testcases mentioned above with its flow
	pom.Xml : 
	This contains all the dependencies used in the project
	Others:	
	Maven Dependencies and Reffered Libraries 
How to Run the Tests?
Pre-requsites:
	Java should be installed on the machine
We can excute the test in 2 different ways
⦁	Execution from Eclipse
		Pre-requsite : 
			Eclipse is installed
		Steps to Run Tests:
			Download the project from GIT
			Open the Project in Eclipse 
			Right on testng.xml (which is directly under project folder)
			Run As -- TestNG Suite
			User can see the results in the TestNG Results tab 
			Click on "Open TestNG Report" icon in the right top of the Result tab 			and user can see a default view of report 
⦁	Execution from Command prompt	
		Pre-requsite : 
			Maven is installed and "M2_Home" amd Path is set up in 				envirnoment variables 
		Steps to Run Tests:
			Download project from GitHub
			Goto the downloaded location and copy the path
			Edit a "ExecuteTest.bat" under the Project folder
			Update the location of the project and save it
			Double click on the bat file
			Tests get executed and results are shown in the command prompt
