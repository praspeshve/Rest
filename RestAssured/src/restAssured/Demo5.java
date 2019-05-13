package restAssured;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.hamcrest.Matchers;
import org.testng.annotations.*;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class Demo5 {
static Properties prop = new Properties();
@BeforeTest
public void getData() throws IOException {
	FileInputStream fis = new FileInputStream(".\\Files\\config.properties");
	try {
		prop.load(fis);
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	fis.close();
}
@Test
public void Test_place() {
	RestAssured.baseURI = prop.getProperty("HOST");
	Response res = RestAssured.given().queryParam("key", prop.getProperty("key"))
			.param("location", "-33.8670522,151.1957362").param("radius", "1500")
			.param("type", "restaurant").param("keyword", "cruise").when()
			.get("maps/api/place/nearbysearch/json")
			.then().assertThat().statusCode(200).and().
			contentType(ContentType.JSON).and().body("status", Matchers.equalTo("OK")).extract().response();
	String resString=res.asString();
	JsonPath jp = new JsonPath(resString);
	String placeid = jp.get("rating");
	System.out.println(placeid);
	
	
	
	
}
	

}
