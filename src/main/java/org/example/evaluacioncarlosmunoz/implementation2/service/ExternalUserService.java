package org.example.evaluacioncarlosmunoz.implementation2.service;

import org.example.evaluacioncarlosmunoz.implementation2.dto.UserDTO;
import org.springframework.stereotype.Service;

import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Service
public class ExternalUserService {
    private final RestTemplate restTemplate;
    private static final String EXTERNAL_API_URL = "https://jsonplaceholder.typicode.com/users";

    public ExternalUserService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public List<UserDTO> fetchAllUsers() {
        try {
            UserDTO[] users = restTemplate.getForObject(EXTERNAL_API_URL, UserDTO[].class);
            return users != null ? Arrays.asList(users) : Collections.emptyList();
        } catch (Exception e) {
            System.err.println("Error al consumir la API externa: " + e.getMessage());
            return Collections.emptyList();
        }
    }
}
