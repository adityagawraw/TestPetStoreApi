import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.util.ExcelUtil;
import io.util.Pet;

import java.io.File;
import java.util.List;

public class Base {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        List<Pet> fileData = new ExcelUtil("/home/aditya/Downloads/PetsData.xlsx",0).readFile();
        for(Pet pet : fileData){
           int statusCode = uploadImage(pet);

            if (statusCode == 200) {
                pet.setStatus("Pass");
            } else {
                pet.setStatus("Fail");
            }
            new ExcelUtil("/home/aditya/Downloads/PetsData.xlsx",0).updateTestStatus(pet);
        }
    }

    public static int uploadImage(Pet pet){
        String baseUrl = "https://petstore.swagger.io/v2/pet/{petId}/uploadImage";
        String filePath = pet.getFilepath();

        File file = new File(filePath);

            Response response = RestAssured.given().
                    multiPart(file).
                    pathParam("petId", pet.getPetId()).
                    contentType("multipart/form-data").
                    when().
                    post(baseUrl);

        response.then().contentType("application/json").log().all();

        return response.getStatusCode();
    }
}
