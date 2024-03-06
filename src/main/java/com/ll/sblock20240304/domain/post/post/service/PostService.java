package com.ll.sblock20240304.domain.post.post.service;

import com.ll.sblock20240304.domain.post.post.entity.Post;
import com.ll.sblock20240304.domain.post.post.repository.PostRepository;
import com.ll.sblock20240304.global.rsData.RsData;
import com.ll.sblock20240304.standard.dto.retryOnOptimisticLock.RetryOnOptimisticLock;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class PostService {
    private final PostRepository postRepository;

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

    public Optional<Post> findWithShareLockById(long id) {
        return postRepository.findWithShareLockById(id);
    }

    public Optional<Post> findWithWriteLockById(long id) {
        return postRepository.findWithWriteLockById(id);
    }

    @Transactional
    public Post modifyWithPessimistic(long id, String title) {
        Post post = postRepository.findWithWriteLockById(id).get();
        post.setTitle(title);

        return post;
    }

    @SneakyThrows
    @Transactional
    public Post modifyWithOptimistic(long id, String title) {
        Post post = postRepository.findById(id).get();

        write("제목 new");

        Thread.sleep(10_000L);

        post.setTitle(title);

        return post;
    }
}

