package org.example.evaluacioncarlosmunoz.implementation2.controller;

import org.example.evaluacioncarlosmunoz.implementation2.dto.UserDTO;
import org.example.evaluacioncarlosmunoz.implementation2.service.ExternalUserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;

import static net.bytebuddy.matcher.ElementMatchers.is;
import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.content;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.jsonPath;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import java.util.Collections;
import java.util.List;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(ExternalUserController.class)
public class ExternalUserControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockitoBean
    private ExternalUserService externalUserService;

    @Test
    void whenUsersExist_shouldReturn200OkWithUserList() throws Exception {
        UserDTO user1 = new UserDTO();
        user1.setId(1L);
        user1.setName("Test User");
        user1.setUsername("testuser");
        List<UserDTO> mockUsers = List.of(user1);
        given(externalUserService.fetchAllUsers()).willReturn(mockUsers);
        mockMvc.perform(get("/api/external/users")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect((ResultMatcher) content().contentType(MediaType.APPLICATION_JSON))
                .andExpect((ResultMatcher) jsonPath("$", hasSize(1)))
                .andExpect((ResultMatcher) jsonPath("$[0].name", is("Test User")))
                .andExpect((ResultMatcher) jsonPath("$[0].username", is("testuser")));
    }

    @Test
    void whenNoUsersExist_shouldReturn200OkWithEmptyList() throws Exception {

        given(externalUserService.fetchAllUsers()).willReturn(Collections.emptyList());


        mockMvc.perform(get("/api/external/users")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect((ResultMatcher) content().contentType(MediaType.APPLICATION_JSON))
                .andExpect((ResultMatcher) jsonPath("$", hasSize(0)));
    }
}
