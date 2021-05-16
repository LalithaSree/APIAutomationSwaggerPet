// this test case is to get the details of the Pets with provided status
//Input :ID   using data provider we can use different data for execution
//OutPut : Pet details
package ApiMethods;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class FindPetsByStatus {
	
	//This method will provide data to any test method that declares that its Data Provider
	 @DataProvider (name = "data-provider")
	 public Object[][] dpMethod(){
	 return new Object[][] {{"status=pending"}, {"status=sold"}, {"status=available"}, {"status=sold,pending"}};
	 }
	
	@Test (dataProvider = "data-provider")
	public void FindPetWithStatus(String status) {
		
		//Specify base URi
		RestAssured.baseURI = "https://petstore.swagger.io/v2/pet";
		
		//  Request object
		RequestSpecification httpRequest = RestAssured.given().accept(ContentType.JSON);
		
		// Response object
		Response response= httpRequest.request(Method.GET,"/findByStatus?"+status);
		
		System.out.println("Finding a pet by Status");
		
		//Response body validation
		String responseBody =response.getBody().asString();
		System.out.println("Response body is: " + responseBody);
				
		//Status code validation
		int statusCode = response.getStatusCode();
		System.out.println("Status code is : " + statusCode);
		Assert.assertEquals(statusCode, 200);
		
		// validate Content Type
		System.out.println("Content Type : "+response.header("Content-Type"));
		Assert.assertEquals(response.header("Content-Type"), "application/json");		
	}
}
