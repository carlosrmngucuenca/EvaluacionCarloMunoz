package org.example.evaluacioncarlosmunoz.implementation2.controller;
import org.example.evaluacioncarlosmunoz.implementation2.dto.UserDTO;
import org.example.evaluacioncarlosmunoz.implementation2.service.ExternalUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/external")
public class ExternalUserController {
    @Autowired
    private ExternalUserService externalUserService;

    @GetMapping("/users")
    public ResponseEntity<List<UserDTO>> getAllExternalUsers() {
        List<UserDTO> users = externalUserService.fetchAllUsers();
        return ResponseEntity.ok(users);
    }
}
