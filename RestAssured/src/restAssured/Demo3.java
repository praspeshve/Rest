package restAssured;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
public class Demo3 {
@Test
public void Test() {
	RestAssured.baseURI="https://maps.googleapis.com";
	Response Resp=RestAssured.given().param("location", "-33.8670522,151.1957362").param("radius", "1500")
	.param("type", "restaurant").param("keyword", "cruise")
	.param("key", "AIzaSyCKIY3_Vj5_gStMjARlNF_vEuiXd0DBucY").when().get("maps/api/place/nearbysearch/json")
	.then().statusCode(200).extract().response();
	System.out.println(Resp.asString());
	
}
}
