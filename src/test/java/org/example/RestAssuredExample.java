package org.example;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class RestAssuredExample {
    public static void main(String[] args) {
        // Устанавливаем базовый URL для API
        RestAssured.baseURI = "https://api.example.com";

        // JSON-тело запроса для авторизации пользователя
        String requestBody = "{ \"username\": \"user123\", \"password\": \"pass456\" }";

        // Отправляем POST-запрос на путь /api/auth/ и указываем Content-Type как application/json
        Response response = RestAssured.given()
                .contentType(ContentType.JSON)
                .body(requestBody)
                .post("/api/auth/");

        // Получаем статус-код из ответа
        int statusCode = response.getStatusCode();
        System.out.println("Status Code: " + statusCode);

        // Получаем тело ответа в виде строки
        String responseBody = response.getBody().asString();
        System.out.println("Response Body: " + responseBody);
    }
}

