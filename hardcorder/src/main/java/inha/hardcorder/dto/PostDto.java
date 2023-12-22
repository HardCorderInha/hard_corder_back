package inha.hardcorder.dto;

import inha.hardcorder.domain.Post;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data

@NoArgsConstructor
public class PostDto {
    private Long id;
    private String title;
    private String content;

    @Builder
    public PostDto( Long id, String title, String content) {
        this.title = title;
        this.content = content;
        this.id = id;
    }
    public PostDto(Post post){
        this.id = post.getId();
        this.title = post.getTitle();
        this.content = post.getContent();
    }

}
