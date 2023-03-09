package ru.skillbox.mapper;

import javax.annotation.processing.Generated;
import ru.skillbox.model.Post;
import ru.skillbox.response.post.PostDto;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-03-09T10:55:29+0300",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 19 (Oracle Corporation)"
)
public class PostMapperImpl implements PostMapper {

    @Override
    public PostDto postToPostDto(Post post, Long currentUser, boolean isTest) {
        if ( post == null ) {
            return null;
        }

        PostDto postDto = new PostDto();

        postDto.setTime( mapTime( post.getTime(), isTest ) );
        postDto.setAuthorId( mapAuthorId( post.getPerson() ) );
        postDto.setCommentsCount( mapCommentsCount( post.getPostCommentList() ) );
        postDto.setImagePath( mapPhoto( post.getPostFiles() ) );
        postDto.setLikeAmount( mapLikeAmount( post.getPostLikes() ) );
        postDto.setMyLike( mapMyLike( post.getPostLikes(), currentUser ) );
        postDto.setPublishDate( mapPublishDate( post.getTime(), isTest ) );
        postDto.setTags( mapTags( post.getTags() ) );
        postDto.setTimeChanged( mapPublishDate( post.getTimeChanged(), isTest ) );
        postDto.setIsDelete( post.getIsDelete() );
        postDto.setId( post.getId() );
        postDto.setTitle( post.getTitle() );
        postDto.setType( post.getType() );
        postDto.setPostText( post.getPostText() );
        postDto.setIsBlocked( post.getIsBlocked() );

        return postDto;
    }
}
