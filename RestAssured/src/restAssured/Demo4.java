package restAssured;

import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Demo4 {
@Test
public void Test_One() {
	//String Base_Uri="https://maps.googleapis.com";
	RestAssured.baseURI="https://maps.googleapis.com";
	Map<String, String> param = new HashMap<>();
	param.put("location", "-33.8670522,151.1957362");
	param.put("radius", "1500");
	param.put("type", "restaurant");
	param.put("keyword", "cruise");
	param.put("key", "AIzaSyDXZe0v9LAKV4QGinIGnvleHYBrXo7xLw4");
	
	RequestSpecBuilder builder = new RequestSpecBuilder();
	//builder.setBaseUri(Base_Uri);
	
	
	builder.setContentType(ContentType.JSON);
	RequestSpecification requestSpec=builder.build();
	
	Response resp = RestAssured.given().spec(requestSpec).when().get("maps/api/place/nearbysearch/json")
			.then().statusCode(200).extract().response();
	System.out.println(resp.asString());
}
}
