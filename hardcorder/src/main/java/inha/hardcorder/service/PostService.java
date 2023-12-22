package inha.hardcorder.service;

import inha.hardcorder.domain.Post;
import inha.hardcorder.dto.PostDto;
import inha.hardcorder.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PostService {
    @Autowired
    PostRepository postRepository;

    @Transactional
    public PostDto save(PostDto postDto) {
        postRepository.save(new Post(postDto));
        return postDto;
    }

    public List<PostDto> getAllPost() {
        List<Post> postList = postRepository.findAll();
        List<PostDto> postDtoList = new ArrayList<>();
        for (Post post : postList) {
            postDtoList.add(new PostDto(post));
        }
        return postDtoList;
    }

    public List<Post> getPostsByKeyword(String keyword) {
        Optional<List<Post>> byTitleContaning = postRepository.findByTitleContaining(keyword);
        return byTitleContaning.orElse(null);
    }

    public PostDto getPostsByID(Long postId) {
        Optional<Post> byId = postRepository.findById(postId);
        if(byId.isEmpty()){
            return null;
        }else{
            return new PostDto(byId.get());
        }
    }

}
