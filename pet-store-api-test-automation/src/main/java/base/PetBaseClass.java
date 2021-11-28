package base;

import com.google.common.io.Resources;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.json.JSONObject;

import java.io.IOException;
import java.net.URL;
import java.nio.charset.Charset;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.MatcherAssert.assertThat;
import static utils.Constants.*;

public class PetBaseClass {


    public void createPet(Long id) throws IOException {
        URL file = Resources.getResource("pet.json");
        String myJson = Resources.toString(file, Charset.defaultCharset());
        JSONObject petObject = new JSONObject(myJson);

        petObject.put("id", id);
        petObject.getJSONObject("category").put("id", id);

        given() //belirli şartlar burada verilir
                .contentType("application/json")
                .body(petObject.toString())
                .when()
                .post(POST_ENDPOINT)
                .then()
                .statusCode(200);
    }

    public  void checkPet(Long id) throws IOException{
        given()
                .contentType("application/json")
                .when()
                .get(GET_ENDPOINT, id)
                .then()
                .statusCode(200);

    }

    public  void updatePet(long id,String key,String value) throws IOException {

        URL userFile = Resources.getResource("pet.json");
        String petJson = Resources.toString(userFile, Charset.defaultCharset());
        JSONObject petObject = new JSONObject(petJson);
        petObject.put("id", id);
        petObject.getJSONObject("category").put("id", id);
        petObject.put(key,value);

        given()
                .contentType("application/json")
                .body(petObject.toString())
                .when()
                .put( PUT_ENDPOINT )
                .then()
                .statusCode(200);
    }

    public void checkPetUpdate(Long id,String key,String value) throws IOException {

        Response response = RestAssured.given()
                .contentType("application/json")
                .when()
                .get(GET_ENDPOINT, id)
                .then()
                .statusCode(200)
                .extract().response();
       assertThat(response.getBody().jsonPath().getString(key), Matchers.containsString(value));


    }

    public  void deletePet(Long id) throws IOException {

        given()
                .contentType("application/json")
                .when()
                .delete(DELETE_ENDPOINT, id)
                .then()
                .statusCode(200);
    }

    public void validatePetDeletion(Long id) throws  IOException{
        given()
                .contentType("application/json")
                .when()
                .get(GET_ENDPOINT, id)
                .then()
                .body(containsString("Pet not found"));
    }


}
