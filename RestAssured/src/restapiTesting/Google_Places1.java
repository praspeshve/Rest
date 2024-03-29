package restapiTesting;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;
import static org.hamcrest.Matchers.*;
//asserting status code
public class Google_Places1 {

@Test
public void Place1() {
	RestAssured.baseURI="https://maps.googleapis.com";
	@SuppressWarnings("unused")
	ValidatableResponse resp = RestAssured.given().param("location", "-33.8670522,151.1957362")
			.param("radius", "1500").param("type","restaurant").param("keyword", "cruise")
			.param("key", "AIzaSyCKIY3_Vj5_gStMjARlNF_vEuiXd0DBucY").when().get("maps/api/place/nearbysearch/json")
			.then().assertThat().statusCode(200).and().contentType(ContentType.JSON).and()
			.body("results[1].name", equalTo("Sydney Showboats"));
	
	
	
}

}
