package api_tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import utils.RestApiUtils;

public class PetStoreAPI_Tests {
	String baseurl = "https://petstore.swagger.io/v2";
	
	Response response;
	RestApiUtils apiutils;
	int petid;
	
	//create a pet with dynamic id, and store the id as a global variable
	//so that we can use that pet id in later tast cases
	
	@Test
	public void create_a_pet() {
		apiutils = new RestApiUtils();
		//request url
		String endpoint = "/pet";
		//request header
		//request method
		//request body
		
		petid = apiutils.randomNumber();
		String payload = "{\n"
				+ "  \"id\": "+petid+",\n"
				+ "  \"category\": {\n"
				+ "    \"id\": 223,\n"
				+ "    \"name\": \"dog\"\n"
				+ "  },\n"
				+ "  \"name\": \"Ocean\",\n"
				+ "  \"photoUrls\": [\n"
				+ "    \"string\"\n"
				+ "  ],\n"
				+ "  \"tags\": [\n"
				+ "    {\n"
				+ "      \"id\": 2230,\n"
				+ "      \"name\": \"oc223\"\n"
				+ "    }\n"
				+ "  ],\n"
				+ "  \"status\": \"available\"\n"
				+ "}";
		
		response = RestAssured
				.given()
					.accept(ContentType.JSON)
					.contentType(ContentType.JSON)
					.body(payload)
				.when()
					.post(baseurl + endpoint);
					
		response.then().statusCode(200).contentType(ContentType.JSON);
		response.prettyPrint();
					
		//assert the if is same as request id
		Assert.assertEquals(Integer.parseInt(response.path("id").toString()), petid);
					
		//assert the name is the same as request name
		Assert.assertEquals(response.path("name").toString(), "Ocean");
					
		Assert.assertEquals(response.path("status").toString(), "available");
	}
	
	//separately alone this test will not work, because the petid is null
	//solution - in TestNG - make a test dependent on another test
	//dependent test only runs if the other test is successful
	
	@Test (dependsOnMethods= "create_a_pet")
	public void getApetByID() {
		String endpoint = "/pet/";
		
		response = RestAssured
		.given()
				.accept(ContentType.JSON)
		.when()
				.get(baseurl+endpoint+petid);
		
		response.then().statusCode(200).contentType("application/json");
		response.prettyPrint();
		
	//validate the id
	System.out.println(response.path("name").toString());
	System.out.println(response.jsonPath().get("id").toString());
	Assert.assertEquals(Integer.parseInt(response.jsonPath().get("id").toString()),petid);
	Assert.assertEquals(response.path("name").toString(), "Ocean");
	
	//If I want to get the name of category, how to define the json path?
	System.out.println(response.path("category.name").toString());
	
	//If I want to get the id of category, how to define the json path?
	System.out.println(response.path("category.id").toString());
	
	//If I want to get the id of the first object of the tags, how to define the json path?
	System.out.println(response.path("tags[0].id").toString());
	
	//If I want to get the name of the second object of the tags, how to define the json path?
	System.out.println(response.path("tags[0].name").toString());
	
//	response.jsonPath().getList("tags");
	}

	
	//when update things, the update happens with the id of an object
	//if the given id doesnt exist, put creates new object as given request body
	
	@Test (dependsOnMethods = "getApetByID")
	public void update_a_pet () {
		String endpoint = "/pet";
		
		String payload = "{\n"
				+ "  \"id\": "+petid+",\n"
				+ "  \"category\": {\n"
				+ "    \"id\": 223,\n"
				+ "    \"name\": \"dog\"\n"
				+ "  },\n"
				+ "  \"name\": \"Husky\",\n"
				+ "  \"photoUrls\": [\n"
				+ "    \"string\"\n"
				+ "  ],\n"
				+ "  \"tags\": [\n"
				+ "    {\n"
				+ "      \"id\": 0,\n"
				+ "      \"name\": \"hk233\"\n"
				+ "    }\n"
				+ "  ],\n"
				+ "  \"status\": \"available\"\n"
				+ "}";
		response= RestAssured
				.given()
					.accept(ContentType.JSON)
					.contentType(ContentType.JSON)
					.body(payload)
				.when()
					.put(baseurl + endpoint);
		
				response.then().statusCode(200).contentType(ContentType.JSON);
				response.prettyPrint();
				
				//assert the if is same as request id
				Assert.assertEquals(Integer.parseInt(response.path("id").toString()), petid);
				
				//assert the name is the same as request name
				Assert.assertEquals(response.path("name").toString(), "Husky");
				
				Assert.assertEquals(response.path("tags[0].name").toString(), "hk233");
				Assert.assertEquals(response.path("status").toString(), "available");
	}
	@Test (dependsOnMethods = "update_a_pet")
	public void delete_the_pet() {
		String endpoint = "/pet/";
		
		response = RestAssured
				.given()
					.accept("application/json")
					.when()
					.delete(baseurl + endpoint+ petid);
		
		response.then().statusCode(200).contentType("application/json");
		response.prettyPrint();
		Assert.assertEquals(Integer.parseInt(response.path("message").toString()), petid);
	}
	@Test
	public void getPetsByStatus() {
		String endpoint = "/pet/findByStatus";
		
		response = RestAssured
		.given()
				.accept(ContentType.JSON)
				.param("status", "sold")
		.when().get(baseurl+endpoint);
		
		response.then().statusCode(200).contentType("application/json");
		response.prettyPrint();
	}
	@Test
	public void invalidGetPetByID() {
		String endpoint = "/pet/";
		response = RestAssured
		.given()
				.accept(ContentType.JSON)
		.when()
			.get(baseurl + endpoint + 38541659);

		response.then().statusCode(404).contentType("application/json");
		Assert.assertEquals(response.path("message").toString(), "Pet not found");
		response.prettyPrint();
	}
	@Test
	public void findAPetByID() {
		String endpoint = "/pet/22112";
		
		response = RestAssured
		.given()
				.accept(ContentType.JSON)
		.when()
				.get(baseurl + endpoint);
		
		response.then().statusCode(200).contentType("application/json");
		Assert.assertEquals(response.path("name").toString(), "booboo");
		Assert.assertEquals(response.path("status").toString(), "available");
		response.prettyPrint();
	}
	
	@Test
	public void findAPetByID404() {
		String endpoint = "/pet/201029";
		
		response = RestAssured
		.given()
				.accept(ContentType.JSON)
		.when()
				.get(baseurl + endpoint);
		
		response.then().statusCode(404).contentType("application/json");
		Assert.assertEquals(response.path("message").toString(), "Pet not found");
		response.prettyPrint();
	}
	
	@Test
	public void invalidfindPetByID() {
		String endpoint = "/pet/";
		response = RestAssured
		.given()
				.accept(ContentType.JSON)
		.when()
			.get(baseurl + endpoint + 201029);

		response.then().statusCode(404).contentType("application/json");
		Assert.assertEquals(response.path("message").toString(), "Pet not found");
		response.prettyPrint();
	}
}
