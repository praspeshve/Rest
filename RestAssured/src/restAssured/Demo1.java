package restAssured;

import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.ValidatableResponse;

public class Demo1 {

@Test
public void Rest_Put() {
	
	//STORING REQUEST BODY
	String body="{\r\n" + 
			"    \"name\": \"morpheus\",\r\n" + 
			"    \"job\": \"zion resident\"\r\n" + 
			"}";
	
	//STORING RESPONSE HEADER
	Map<String, String> headers = new HashMap<>();
	headers.put("Connection", "keep-alive");
	headers.put("Server", "cloudflare");
	headers.put("Vary", "Accept-Encoding");
	
	RestAssured.baseURI="https://reqres.in";
	@SuppressWarnings("unused")
	ValidatableResponse resp = RestAssured.given().header("Content-Type","application/json").and()
			.body(body).when().put("/api/users/2").then()
			.assertThat().statusCode(200).and().headers(headers);
}
		
		
	}


