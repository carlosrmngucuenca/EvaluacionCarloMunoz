package org.example.evaluacioncarlosmunoz.implementation2.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.evaluacioncarlosmunoz.implementation2.dto.UserDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.client.RestClientTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.client.MockRestServiceServer;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.requestTo;
import static org.springframework.test.web.client.response.MockRestResponseCreators.withServerError;
import static org.springframework.test.web.client.response.MockRestResponseCreators.withSuccess;

@RestClientTest(ExternalUserService.class)
public class ExternalUserServiceTest {
    @Autowired
    private ExternalUserService externalUserService;

    @Autowired
    private MockRestServiceServer mockServer;

    // ObjectMapper nos ayudará a convertir objetos Java a strings JSON para los mocks
    @Autowired
    private ObjectMapper objectMapper;

    private static final String EXTERNAL_API_URL = "https://jsonplaceholder.typicode.com/users";

    @BeforeEach
    void setUp() {
        mockServer.reset();
    }

    @Test
    void whenApiCallIsSuccessful_shouldReturnListOfUsers() throws Exception {
        UserDTO user1 = new UserDTO();
        user1.setId(1L);
        user1.setName("Carlos Muñoz");
        user1.setEmail("carlos.munozg@ucuenca.edu.ec");

        List<UserDTO> mockUsers = List.of(user1);

        // Convertimos nuestra lista de prueba a un string JSON
        String mockJsonResponse = objectMapper.writeValueAsString(mockUsers);

        // Configuramos el mock server:
        // "Espera una petición a esta URL...
        mockServer.expect(requestTo(EXTERNAL_API_URL))
                // ...y cuando la recibas, responde con un código de éxito (200 OK),
                // un cuerpo JSON y el content-type correcto."
                .andRespond(withSuccess(mockJsonResponse, MediaType.APPLICATION_JSON));

        // 2. Act (Actuar)
        List<UserDTO> result = externalUserService.fetchAllUsers();

        // 3. Assert (Verificar)
        // Verificamos que el mock server realmente recibió la petición esperada.
        mockServer.verify();

        assertNotNull(result);
        assertEquals(1, result.size());
        assertEquals("Leanne Graham", result.get(0).getName());
    }

    @Test
    void whenApiCallFails_shouldReturnEmptyList() {
        // 1. Arrange
        // Configuramos el mock server para que simule un error 500
        mockServer.expect(requestTo(EXTERNAL_API_URL))
                .andRespond(withServerError());

        // 2. Act
        List<UserDTO> result = externalUserService.fetchAllUsers();

        // 3. Assert
        mockServer.verify();
        assertNotNull(result);
        assertTrue(result.isEmpty());
    }


}
