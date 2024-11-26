package api.endpoints;

public class Routes {

	/*
	 * Swagger URI --> https://petstore.swagger.io
	 * 
	 * Create user(Post) : https://petstore.swagger.io/v2/user Get user (Get):
	 * https://petstore.swagger.io/v2/user/{username} Update user (Put) :
	 * https://petstore.swagger.io/v2/user/{username} Delete user (Delete) :
	 * https://petstore.swagger.io/v2/user/{username}
	 * 
	 */

	// User Module
	public static String base_url = "https://petstore.swagger.io/v2";
	public static String postUser_url = base_url + "/user";
	public static String getUser_url = base_url + "/user/{username}";
	public static String updateUser_url = base_url + "/user/{username}";
	public static String deleteUser_url = base_url + "/user/{username}";

	// Pet Module
	// All Pet URL Constants will be stored here

	// Store Module
	// All Store URL Constants will be stored here

}
