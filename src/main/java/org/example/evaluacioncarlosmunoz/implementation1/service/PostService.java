package org.example.evaluacioncarlosmunoz.implementation1.service;

import jakarta.annotation.PostConstruct;
import org.example.evaluacioncarlosmunoz.implementation1.entity.PostEntity;
import org.example.evaluacioncarlosmunoz.implementation1.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PostService {

    private final RestTemplate restTemplate = new RestTemplate();
    private static final String EXTERNAL_API_URL = "https://jsonplaceholder.typicode.com/posts";

    @Autowired
    private PostRepository postRepository;

    @PostConstruct
    public void fetchAndSavePosts() {
        PostEntity[] posts = restTemplate.getForObject(EXTERNAL_API_URL, PostEntity[].class);
        if (posts != null) {
            postRepository.saveAll(Arrays.asList(posts));
            System.out.println(posts.length + " posts han sido guardadas en la base de datos.");
        }
    }

    public List<String> getTitlesByUserId(Long userId) {
        List<PostEntity> posts = postRepository.findByUserId(userId);
        return posts.stream()
                .map(PostEntity::getTitle)
                .collect(Collectors.toList());
    }
}
