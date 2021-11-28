import base.PetBaseClass;
import extensions.RetryAnalyzer;
import io.restassured.RestAssured;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.sql.Timestamp;

import static utils.Constants.BASE_URL;

public class ApiTests {
    PetBaseClass petBase = new PetBaseClass();
    long id;

    @BeforeTest
    public void beforeTest() {
        RestAssured.baseURI = BASE_URL;
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        id = timestamp.getTime();
    }

    @Test(retryAnalyzer = RetryAnalyzer.class)
    public void createPetTest() throws IOException {
        petBase.createPet(id);
        petBase.checkPet(id);
    }

    @Test(retryAnalyzer = RetryAnalyzer.class)
    public void updatePetTest() throws IOException {
        petBase.updatePet(id, "name","max");
        petBase.checkPetUpdate(id, "name", "max");
    }

    @Test(retryAnalyzer = RetryAnalyzer.class)
    public void deletePetTest() throws IOException {
        petBase.deletePet(id);
        petBase.validatePetDeletion(id);
    }
}
