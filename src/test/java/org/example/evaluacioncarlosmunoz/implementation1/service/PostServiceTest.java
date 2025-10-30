package org.example.evaluacioncarlosmunoz.implementation1.service;

import org.example.evaluacioncarlosmunoz.implementation1.entity.PostEntity;
import org.example.evaluacioncarlosmunoz.implementation1.repository.PostRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class PostServiceTest {

    @Mock
    private PostRepository postRepository;

    @InjectMocks
    private PostService postService;

    private PostEntity post1;
    private PostEntity post2;

    @BeforeEach
    void setUp() {
        // Preparamos datos de prueba que usaremos en varios tests
        post1 = new PostEntity();
        post1.setId(1L);
        post1.setUserId(1L);
        post1.setTitle("Título del Post 1");
        post1.setBody("Cuerpo del post 1");

        post2 = new PostEntity();
        post2.setId(2L);
        post2.setUserId(1L);
        post2.setTitle("Título del Post 2");
        post2.setBody("Cuerpo del post 2");
    }

    @Test
    void whenUserExists_shouldReturnListOfTitles() {
        Long userId = 1L;
        List<PostEntity> userPosts = List.of(post1, post2);
        when(postRepository.findByUserId(userId)).thenReturn(userPosts);
        List<String> titles = postService.getTitlesByUserId(userId);
        assertNotNull(titles, "La lista de títulos no debería ser nula");
        assertEquals(2, titles.size(), "Debería haber dos títulos en la lista");
        assertTrue(titles.contains("Título del Post 1"), "La lista debería contener el primer título");
        assertTrue(titles.contains("Título del Post 2"), "La lista debería contener el segundo título");

    }

    @Test
    void whenUserDoesNotExist_shouldReturnEmptyList() {
        Long userId = 999L; // Un usuario que no existe
        when(postRepository.findByUserId(userId)).thenReturn(Collections.emptyList());
        List<String> titles = postService.getTitlesByUserId(userId);
        assertNotNull(titles, "La lista no debería ser nula");
        assertTrue(titles.isEmpty(), "La lista de títulos debería estar vacía");

    }

}
