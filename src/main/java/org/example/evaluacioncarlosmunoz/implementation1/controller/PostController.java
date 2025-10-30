package org.example.evaluacioncarlosmunoz.implementation1.controller;


import org.example.evaluacioncarlosmunoz.implementation1.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/posts")
public class PostController {

    @Autowired
    private PostService postService;

    @GetMapping("/user/{userId}/titles")
    public ResponseEntity<List<String>> getPostTitlesByUserId(@PathVariable Long userId) {
        List<String> titles = postService.getTitlesByUserId(userId);
        if (titles.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(titles);
    }
}
