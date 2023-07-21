package tests;
import org.junit.Assert;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class ExamSteps {
	public Response response;
	
	@Given("I want to validate api response")
	public void i_want_to_validate_api_response() {
	}

	@When("I get request from api")
	public void i_get_request_from_api() {
		RestAssured.baseURI = "https://api.tmsandbox.co.nz/v1/Categories/6329/Details.json?catalogue=false";
		RequestSpecification httpRequest = RestAssured.given();
		response = httpRequest.get("");
	}

	@Then("I am able to validate that name is {string}")
	public void i_am_able_to_validate_that_name_is(String name) {
		String resName = response.path("Name");
		Assert.assertTrue(resName.equals(name));
	}

	@Then("I am able to relist")
	public void i_am_able_to_relist() {
		Boolean canRelist = response.path("CanRelist");
		Assert.assertTrue(canRelist);
	}

	@Then("I am able to validate promotion named {string} contains description {string}")
	public void i_am_able_to_validate_promotion_named_contains_description(String name, String description) {
		String resdesc = response.jsonPath().getString("Promotions.find { it.Name == '"+name+"' }.Description");
		Assert.assertTrue(resdesc.contains(description));
	}
}
