package api.endpoints;

import static io.restassured.RestAssured.given;

import java.util.ResourceBundle;

import api.payload.User;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class UserEndpoints2 {

	public static ResourceBundle getUrl() {
		ResourceBundle routes = ResourceBundle.getBundle("routes");// To Load Routes Properties File & Return Data Under
																	// it
		return routes;
	}

	public static Response createUser(User payload) {
		String postUser_url = UserEndpoints2.getUrl().getString("post_url");
		Response response = given()
				.contentType(ContentType.JSON)
				.accept(ContentType.JSON)
				.body(payload)
				.when()
				.post(postUser_url);

		return response;
	}

	public static Response getUser(String username) {
		String getUser_url = UserEndpoints2.getUrl().getString("get_url");
		Response response = given()
				.pathParam("username", username)
				.when()
				.get(getUser_url);

		return response;
	}

	public static Response updateUser(String username, User payload) {
		String updateUser_url = UserEndpoints2.getUrl().getString("update_url");
		Response response = given()
				.contentType(ContentType.JSON)
				.accept(ContentType.JSON)
				.pathParam("username", username)
				.body(payload)
				.when()
				.put(updateUser_url);

		return response;
	}

	public static Response deleteUser(String username) {
		String deleteUser_url = UserEndpoints2.getUrl().getString("delete_url");
		Response response = given()
				.pathParam("username", username)
				.when()
				.delete(deleteUser_url);
		return response;
	}

}
