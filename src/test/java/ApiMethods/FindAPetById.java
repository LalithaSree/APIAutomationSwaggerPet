// this test case is to get the details of the Pets with provided PetID
//Input :ID
//OutPut : Pet details

package ApiMethods;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class FindAPetById {
	
	//This method will provide data to any test method that declares that its Data Provider 
	@DataProvider (name = "data-provider")
	 public Object[][] dpMethod(){
	 return new Object[][] {{100}, {101}, {102}, {103}};
	 }
	
	@Test (dataProvider = "data-provider")
	void FindPetByID(int petId) {
		
		//Specify base URi
		RestAssured.baseURI = "https://petstore.swagger.io/v2/pet";
		
		//  Request object
		RequestSpecification httpRequest = RestAssured.given();
		
		// Response object
		Response response= httpRequest.request(Method.GET,"/"+petId);
		
		System.out.println("Finding a pet by ID");
		
		//Response body validation
		String responseBody =response.getBody().asString();
		System.out.println("Response body is: " + responseBody);
		
		//validating id
		int id = response.jsonPath().get("id");
		System.out.println("id is :" + id);
		Assert.assertEquals(id, petId);
		
		//Status code validation
		int statusCode = response.getStatusCode();
		System.out.println("Status code is : " + statusCode);
		Assert.assertEquals(statusCode, 200);
		
		
	}

}
