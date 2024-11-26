package api.endpoints;

import static io.restassured.RestAssured.given;

import api.payload.User;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class UserEndpoints {

	public static Response createUser(User payload) {
		Response response = given()
				.contentType(ContentType.JSON)
				.accept(ContentType.JSON)
				.body(payload)
				.when()
				.post(Routes.postUser_url);

		return response;
	}

	public static Response getUser(String username) {
		Response response = given()
				.pathParam("username", username)
				.when()
				.get(Routes.getUser_url);

		return response;
	}

	public static Response updateUser(String username, User payload) {
		Response response = given()
				.contentType(ContentType.JSON)
				.accept(ContentType.JSON)
				.pathParam("username", username)
				.body(payload)
				.when()
				.put(Routes.updateUser_url);

		return response;
	}

	public static Response deleteUser(String username) {
		Response response=given()
		.pathParam("username", username)
		.when()
		.delete(Routes.deleteUser_url);
		return response;
	}

}
