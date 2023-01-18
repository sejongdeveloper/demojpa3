package me.whiteship.demojpa3.post;

import me.whiteship.demojpa3.MyRepository;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends MyRepository<Post, Long>, PostCustomRepository<Post> {
}
