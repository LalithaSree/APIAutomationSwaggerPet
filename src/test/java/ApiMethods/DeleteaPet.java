// this test case is to DELETE a Pet with provided PetID
//Input :ID     using Data provider we can use different data
//OutPut : Pet details should be deleted

package ApiMethods;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class DeleteaPet {
	//This method will provide data to any test method that declares that its Data Provider
		@DataProvider (name = "data-provider")
		 public Object[][] dpMethod(){
		 return new Object[][] {{100}, {101},{102},{103}};
		 }
		
		@Test (dataProvider = "data-provider")
		void DeletePet(int petId) {
			
			//Specify base URi
			RestAssured.baseURI = "https://petstore.swagger.io/v2/pet";
			
			//  Request object
			RequestSpecification httpRequest = RestAssured.given();
			
			// Response object
			Response response= httpRequest.request(Method.DELETE,"/"+petId);
			
			System.out.println("Deleting a pet");
			
			//Response body validation
			String responseBody =response.getBody().asString();
			System.out.println("Response body is: " + responseBody);
			
			
			//Status code validation
			int statusCode = response.getStatusCode();
			System.out.println("Status code is : " + statusCode);
			Assert.assertEquals(statusCode, 200);
			
			
		}

}
