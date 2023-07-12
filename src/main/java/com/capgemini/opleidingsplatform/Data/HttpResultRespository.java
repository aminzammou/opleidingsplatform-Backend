package com.capgemini.opleidingsplatform.Data;

import com.capgemini.opleidingsplatform.Presentation.dto.CodeResultDTO;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class HttpResultRespository {
    public CodeResultDTO makePostRequest(String code, int time) throws JsonProcessingException {
        // Create an instance of RestTemplate
        RestTemplate restTemplate = new RestTemplate();

        // Define the request URL
        String url = "http://localhost:8081/api/calc/algoritm";
        String name = "test";
        // Define the request headers
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        // Define the request body
        String requestBody = "{ \"Name\": \"" + name + "\", \"Code\": \"" + code + "\", \"Time\": " + time + " }";
        HttpEntity<String> requestEntity = new HttpEntity<>(requestBody, headers);

        // Send the request and retrieve the response
        ResponseEntity<String> response = restTemplate.postForEntity(url, requestEntity, String.class);

        // Process the response
        int statusCode = response.getStatusCodeValue();
        HttpHeaders responseHeaders = response.getHeaders();
        String responseBody = response.getBody();


        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode responseJson = objectMapper.readTree(responseBody);
        System.out.println(responseJson);
        double executionTime = responseJson.get("result").get("executionTime").asDouble();
        double memoryUsage = responseJson.get("result").get("memoryUsage").asDouble();

        CodeResultDTO codeRes = new CodeResultDTO(executionTime,memoryUsage);

        System.out.println("Response Code: " + statusCode);
        System.out.println("Response Headers: " + responseHeaders);
        System.out.println("Response Body: " + responseBody);
        System.out.println("Execution Time: " + executionTime);
        System.out.println("Memory Usage: " + memoryUsage);
        return codeRes;
    }
}
