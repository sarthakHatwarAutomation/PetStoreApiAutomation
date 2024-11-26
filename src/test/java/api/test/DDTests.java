package api.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import api.endpoints.UserEndpoints;
import api.payload.User;
import api.utilities.DataProviders;
import io.restassured.response.Response;

public class DDTests {
	User userPayload;

	@Test(priority = 1, dataProvider = "Data", dataProviderClass = DataProviders.class)
	public void createUserDD(String userId, String userName, String fName, String lName, String email, String pwd,
			String ph) {
		userPayload = new User();
		userPayload.setId(Integer.parseInt(userId));
		userPayload.setUsername(userName);
		userPayload.setFirstName(fName);
		userPayload.setLastName(lName);
		userPayload.setEmail(email);
		userPayload.setPassword(pwd);
		userPayload.setPhone(ph);

		Response response = UserEndpoints.createUser(userPayload);
		Assert.assertEquals(response.getStatusCode(), 200);

	}

	@Test(priority = 2, dataProvider = "UserNames", dataProviderClass = DataProviders.class)
	public void getUserDD(String userName) {
		Response response = UserEndpoints.getUser(userName);
		response.then().log().all();
		Assert.assertEquals(response.getStatusCode(), 200);
	}

	@Test(priority = 3, dataProvider = "UserNames", dataProviderClass = DataProviders.class)
	public void deleteUserDD(String userName) {
		Response response = UserEndpoints.deleteUser(userName);
		Assert.assertEquals(response.getStatusCode(), 200);
	}

}
