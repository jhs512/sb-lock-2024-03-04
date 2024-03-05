package com.ll.sblock20240304.domain.post.post.controller;

import com.ll.sblock20240304.domain.post.post.entity.Post;
import com.ll.sblock20240304.domain.post.post.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/posts")
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ApiV1PostController {
    private final PostService postService;

    @GetMapping("/{id}")
    public Post getPost(
            @PathVariable long id
    ) {
        return postService.findById(id).get();
    }
}