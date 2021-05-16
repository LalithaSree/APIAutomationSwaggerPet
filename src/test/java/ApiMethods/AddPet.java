//This test case is written to Add a pet to the store
// input : id, name , status     || Output : Pet details should be added
// here we are using Data provider from TestNG to use multiple set of data for adding multiple pets.
package ApiMethods;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class AddPet {
	//This method will provide data to any test method that declares that its Data Provider
	@DataProvider (name = "data-provider")
	 public Object[][] dpMethod(){
	 return new Object[][] {{100,"Hund", "available"}, {101,"Katze", "available"}, {102,"Parrot", "available"}, {103,"Sparrow","available"}};
	 }
	
	// TestNG Annotations
	@Test (dataProvider = "data-provider")
	void AddPetDataStore(int idNo, String name, String status) {
		
		//Specify base URi
		RestAssured.baseURI = "https://petstore.swagger.io/v2/pet";
		
		//  Request object
		RequestSpecification httpRequest = RestAssured.given().accept(ContentType.JSON);
			
		//Create request parameters
		JSONObject requestParams = new JSONObject();
		
		requestParams.put("id", idNo);
		requestParams.put("name", name);
		requestParams.put("status", status);
		
		httpRequest.header("Content-Type","application/json");

		//to attach the above data to the request
		httpRequest.body(requestParams.toJSONString());
		
		// Response object
		Response response= httpRequest.request(Method.POST);
		
		System.out.println("Adding a pet");
		
		//Status code validation
		int statusCode = response.getStatusCode();
		System.out.println("Status code is : " + statusCode);
		Assert.assertEquals(statusCode, 200);
		
		//Validating Content type
		System.out.println("Content Type : "+response.header("Content-Type"));
		Assert.assertEquals(response.header("Content-Type"), "application/json");	
		
		//Response body validation
		String responseBody =response.getBody().asString();
		System.out.println("Response body is: " + responseBody);
		
		//validating id
		int id = response.jsonPath().get("id");
		System.out.println("id is :" + id);
		Assert.assertEquals(id, idNo);
		
		//validating name
		String strname = response.jsonPath().get("name");
		System.out.println("name is :" + strname);
		Assert.assertEquals(strname, name);
		
		//validating status
		String strstatus = response.jsonPath().get("status");
		System.out.println("Status is :" + strstatus);
		Assert.assertEquals(strstatus, status);
		
	}

}