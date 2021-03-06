import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.internal.path.json.mapping.JsonObjectDeserializer;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


public class Testlocal {


	@Test
	void TC_post01() {

		baseURI = "http://localhost:3000/";
		JSONObject obj = new JSONObject();

		obj.put("name", "Vebo");
		obj.put("lastname", "rai");
		obj.put("jobid", 8);
		//obj.put("id", "5");

				RequestSpecification req = RestAssured.given();
				
				req.header("ContentType", "application/json");

				req.body(obj.toJSONString());
				
		System.out.println(obj.toJSONString());

		req.post("/user");

		given().
		contentType(ContentType.JSON).accept(ContentType.JSON).
		body(obj.toJSONString()).
		when().
		post("/user").
		then().
		statusCode(201);

		given().get("/user").then().log().body(true);	
	}

	@Test
	void TC_get02() {

		baseURI = "http://localhost:3000/";

		Response response = get("/user");

		response.getBody();
		String names = response.jsonPath().getString("name");
		System.out.println(names);
		
		
		
		System.out.println(response.jsonPath().get("id"));


//		Map<String, String> res= new HashMap<String, String>();
//		res=response.jsonPath().getMap("id[0]");
//		System.out.println(res);

	}

	@Test
	void TC_put03() {

		baseURI = "http://localhost:3000/";
		JSONObject obj = new JSONObject();

		obj.put("name", "Shivam");
		obj.put("lastname", "chatur");
		obj.put("jobid", 5);
		//obj.put("id", "5");

		//		RequestSpecification req = RestAssured.given();
		//		
		//		req.body(obj.toJSONString());
		//		
		System.out.println(obj.toJSONString());

		//req.post("/user");

		given().
		contentType(ContentType.JSON).accept(ContentType.JSON).
		body(obj.toJSONString()).
		when().
		put("/user/6").
		then().
		statusCode(200);

		given().get("/user").then().log().body(true);	
	}
	
	@Test
	void TC_patch04() {

		baseURI = "http://localhost:3000/";
		JSONObject obj = new JSONObject();

		obj.put("name", "Shivam");
		//obj.put("lastname", "chaturvedi");
		//obj.put("jobid", 5);
		//obj.put("id", "5");

		//		RequestSpecification req = RestAssured.given();
		//		
		//		req.body(obj.toJSONString());
		//		
		System.out.println(obj.toJSONString());

		//req.post("/user");

		given().
		contentType(ContentType.JSON).accept(ContentType.JSON).
		body(obj.toJSONString()).
		when().
		patch("/user/6").
		then().
		statusCode(200);

		given().get("/user").then().log().body(true);	
	}

	@Test
	void TC_patch05() {

		baseURI = "http://localhost:3000/";
		JSONObject obj = new JSONObject();

		obj.put("name", "Shiv");
		//obj.put("lastname", "chaturvedi");
		//obj.put("jobid", 5);
		//obj.put("id", "5");

				//RequestSpecification req = RestAssured.given();
				
				//req.body(obj.toJSONString());
				
		System.out.println(obj.toJSONString());

		//req.post("/user");

		given().
		contentType(ContentType.JSON).accept(ContentType.JSON).
		body(obj.toJSONString()).
		when().
		patch("/user/6").
		then().
		statusCode(200);

		given().get("/user").then().log().body(true);	
	}
	
	@Test
	void TC_Del06() {

		baseURI = "http://localhost:3000/";
		JSONObject obj = new JSONObject();

//		obj.put("name", "Shiv");
		//obj.put("lastname", "chaturvedi");
		//obj.put("jobid", 5);
		//obj.put("id", "5");

				//RequestSpecification req = RestAssured.given();
				
				//req.body(obj.toJSONString());
				
	//	System.out.println(obj.toJSONString());

		//req.post("/user");

		given().
		contentType(ContentType.JSON).accept(ContentType.JSON).
		when().
		delete("/user/9").
		then().
		statusCode(200);

		given().get("/user").then().log().body(true);	
	}
	
	@Test
	void Tc_001() {
		baseURI ="http://localhost:3000/user";

		ArrayList<String> arr = new ArrayList<String>();
		arr= (ArrayList<String>) given().param("user.id",1).
				when().get().then().extract().body();
		System.out.println(arr);
		
		
	}
}
