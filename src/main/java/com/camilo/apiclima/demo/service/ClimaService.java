package com.camilo.apiclima.demo.service;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

@Service
public class ClimaService {

    public  ResponseEntity<String> obtenerClimaApi(String ciudad){
        try{
            String apiKey = "f492bd9c121971074e2b2c0faf2fd2a0";
            String url ="https://api.openweathermap.org/data/2.5/weather?q="+ciudad+"&appid="+apiKey;


            RestTemplate restTemplate = new RestTemplate();
            String clima = restTemplate.getForObject(url, String.class);

            return ResponseEntity.ok(clima);

        }catch(HttpClientErrorException.Unauthorized e){
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Error de autorización");

        }
    }

}
