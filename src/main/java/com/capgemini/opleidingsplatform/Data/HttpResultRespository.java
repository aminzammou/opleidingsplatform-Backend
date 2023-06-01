package com.capgemini.opleidingsplatform.Data;

import com.capgemini.opleidingsplatform.Presentation.dto.CodeResultDTO;
//import org.springframework.web.client.RestTemplate;
import java.lang.reflect.Array;
import java.net.URI;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

//public class HttpResultRespository implements CodeResultRepository{
//    private final String rootPath;
//    private final RestTemplate client;
//
//    public HttpResultRespository(String rootPath, RestTemplate client) {
//        this.rootPath = rootPath;
//        this.client = client;
//    }

//    @Override
//    public List<CodeResultDTO> findAll() {
//        return null;
//    }
//    @Override
//    public Optional<CodeResultDTO> getResult(String code, int Time) {
//        URI uri = URI.create(this.rootPath + "/api/calc/algoritm");
//
//        CodeResultDTO results = this.client.postForObject(uri, CodeResultDTO.class);
//
//        if (results == null) {
//            return Optional.empty();
//        }
//        return Optional.of(results);
//
//    }


//
//    public class MyRestClient {
//        public void makePostRequest() {
//            // Create an instance of RestTemplate
//            RestTemplate restTemplate = new RestTemplate();
//
//            // Define the request URL
//            String url = "http://localhost:8081/api/calc/algoritm";
//
//            // Define the request headers
//            HttpHeaders headers = new HttpHeaders();
//            headers.setContentType(MediaType.APPLICATION_JSON);
//
//            // Define the request body
//            String requestBody = "{ \"Name\": \"\", \"Code\": \"\", \"Time\": \"\" }";
//            HttpEntity<String> requestEntity = new HttpEntity<>(requestBody, headers);
//
//            // Send the request and retrieve the response
//            ResponseEntity<String> response = restTemplate.postForEntity(url, requestEntity, String.class);
//
//            // Process the response
//            int statusCode = response.getStatusCodeValue();
//            HttpHeaders responseHeaders = response.getHeaders();
//            String responseBody = response.getBody();
//
//            System.out.println("Response Code: " + statusCode);
//            System.out.println("Response Headers: " + responseHeaders);
//            System.out.println("Response Body: " + responseBody);
//        }
//    }
//
//
//}

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
