package me.whiteship.demojpa3.post;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PagedResourcesAssembler;
import org.springframework.hateoas.PagedResources;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PostController {
    @Autowired
    PostRepository postRepository;

    @GetMapping("/posts/{id}")
    public String getAPost(@PathVariable("id") Post post) {
        return post.getTitle();
    }

    @GetMapping("/posts")
    public PagedResources<Post> getPosts(Pageable pageable, PagedResourcesAssembler assembler) {
        Page<Post> all = postRepository.findAll(pageable);
        return assembler.toResource(all);
    }
}
