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
        for(Pet pet: fileData){
            System.out.println(pet.getTCID()+" "+ pet.getExcecution()+" "+ pet.getPetId()+" "+pet.getFilepath());
        }
//        uploadImage();
    }
    public static void uploadImage(){
        String baseUrl = "https://petstore.swagger.io/v2/pet/{petId}/uploadImage";
        String filePath = "/home/aditya/Pictures/Screenshots/mvc.png";
        String petId = "23";
        String additionalData = "First File";

        File file = new File(filePath);

        Response response = RestAssured.given().
                multiPart("additionalMetadata", "file 1").
                pathParam("petId", "2").
                multiPart(file).
                contentType("multipart/form-data").
                when().
                post(baseUrl);

        response.then().statusCode(200).contentType("application/json").assertThat().log().all();

    }
}
