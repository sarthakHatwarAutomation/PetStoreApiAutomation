package api.test;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import api.endpoints.UserEndpoints;
import api.payload.User;
import io.restassured.response.Response;

public class UserTests {

	Faker faker;
	User userPayload;
	public Logger logger;

	@BeforeClass
	public void setupTest() {
		faker = new Faker();

		userPayload = new User();
		userPayload.setId(faker.idNumber().hashCode());
		userPayload.setUsername(faker.name().username());
		userPayload.setFirstName(faker.name().firstName());
		userPayload.setLastName(faker.name().lastName());
		userPayload.setEmail(faker.internet().safeEmailAddress());
		userPayload.setPassword(faker.internet().password(5, 12));
		userPayload.setPhone(faker.phoneNumber().cellPhone());

		logger = LogManager.getLogger(UserTests.class);
		//logger.debug("debugging.....");


	}

	@Test(priority = 1)
	public void testCreateUser() {
		logger.info("**********Create User Test**********");
		Response response = UserEndpoints.createUser(userPayload);
		response.then().log().all();
		Assert.assertEquals(response.getStatusCode(), 200);
		logger.info("**********User Created Successfully**********");
	}

	@Test(priority = 2)
	public void testGetUserByUserName() {
		logger.info("**********Retrieve User Test**********");
		Response response = UserEndpoints.getUser(this.userPayload.getUsername());
		response.then().log().all();
		Assert.assertEquals(response.getStatusCode(), 200);
		logger.info("**********User Retrieved Successfully**********");
	}

	@Test(priority = 3)
	public void testUpdateUserByUserName() {
		logger.info("**********Update User Test**********");
		userPayload.setFirstName(faker.name().firstName());
		userPayload.setLastName(faker.name().lastName());
		userPayload.setEmail(faker.internet().safeEmailAddress());

		Response response = UserEndpoints.updateUser(this.userPayload.getUsername(), userPayload);
		response.then().log().all();

		Assert.assertEquals(response.getStatusCode(), 200);
		Response responseAfterUpdation = UserEndpoints.getUser(this.userPayload.getUsername());
		responseAfterUpdation.then().log().all();
		Assert.assertEquals(responseAfterUpdation.getStatusCode(), 200);

		logger.info("**********User Updated Successfully**********");

	}

	@Test(priority = 4)
	public void testDeleteUserByUserName() {
		logger.info("**********Delete User Test**********");
		Response response = UserEndpoints.deleteUser(this.userPayload.getUsername());
		Assert.assertEquals(response.getStatusCode(), 200);
		logger.info("**********User Deleted Successfully**********");
	}

}
