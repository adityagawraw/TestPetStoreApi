package org.example;

import io.restassured.RestAssured;
import io.restassured.response.Response;

import java.io.File;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        uploadImage();
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

        response.then().statusCode(200).contentType("application/json").log().all();

    }

}