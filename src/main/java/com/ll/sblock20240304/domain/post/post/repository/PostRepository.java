package com.ll.sblock20240304.domain.post.post.repository;

import com.ll.sblock20240304.domain.post.post.entity.Post;
import jakarta.persistence.LockModeType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;

import java.util.Optional;

public interface PostRepository extends JpaRepository<Post, Long> {
    @Lock(LockModeType.PESSIMISTIC_READ)
    Optional<Post> findWithShareLockById(long id);
}
