package com.ll.sblock20240304.domain.post.post.service;

import com.ll.sblock20240304.domain.post.post.entity.Post;
import com.ll.sblock20240304.domain.post.post.repository.PostRepository;
import com.ll.sblock20240304.global.rsData.RsData;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class PostService {
    private final PostRepository postRepository;
    @PersistenceContext
    private EntityManager entityManager;
    private final ApplicationEventPublisher publisher;

    @Transactional
    public RsData<Post> write(String title) {
        Post post = postRepository.save(
                Post.builder()
                        .title(title)
                        .build()
        );

        return RsData.of(post);
    }

    public long count() {
        return postRepository.count();
    }

    public Optional<Post> findById(long id) {
        return postRepository.findById(id);
    }
}

