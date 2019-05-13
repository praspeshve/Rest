package restapiTesting;

import java.util.*;

import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class Google_Places2 {
@Test
public void place2() {
	String url = "https://maps.googleapis.com";
	Map<String, String> param = new HashMap<String, String>();
	param.put("location", "-33.8670522,151.1957362");
	param.put("radius", "500");
	param.put("key", "AIzaSyCKIY3_Vj5_gStMjARlNF_vEuiXd0DBucY");
	RequestSpecBuilder builder = new RequestSpecBuilder();
	RestAssured.baseURI=url;
	builder.setContentType(ContentType.JSON);
	RequestSpecification requestSpec=builder.build();
	@SuppressWarnings("unused")
	ValidatableResponse resp = RestAssured.given().spec(requestSpec).when().get("maps/api/place/nearbysearch/json")
			.then().assertThat().statusCode(200);
	//System.out.println(resp.asString());
	
	}

}
