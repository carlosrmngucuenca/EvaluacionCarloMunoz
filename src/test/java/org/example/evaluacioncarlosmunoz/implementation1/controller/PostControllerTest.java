package org.example.evaluacioncarlosmunoz.implementation1.controller;

import org.example.evaluacioncarlosmunoz.implementation1.service.PostService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;

import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Collections;
import java.util.List;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.hamcrest.Matchers.*;

@WebMvcTest(PostController.class)
public class PostControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockitoBean
    private PostService postService;

    @Test
    void givenExistingUser_whenGetTitles_thenReturns200OkWithTitles() throws Exception {
        Long userId = 1L;
        List<String> expectedTitles = List.of("Título 1", "Título 2");
        given(postService.getTitlesByUserId(userId)).willReturn(expectedTitles);
        mockMvc.perform(get("/api/posts/user/{userId}/titles", userId)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$", hasSize(2)))
                .andExpect(jsonPath("$[0]", is("Título 1")))
                .andExpect(jsonPath("$[1]", is("Título 2")));
    }

    @Test
    void givenNonExistingUser_whenGetTitles_thenReturns204NoContent() throws Exception {

        Long userId = 999L;
        given(postService.getTitlesByUserId(userId)).willReturn(Collections.emptyList());
        mockMvc.perform(get("/api/posts/user/{userId}/titles", userId)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNoContent());
    }
}
