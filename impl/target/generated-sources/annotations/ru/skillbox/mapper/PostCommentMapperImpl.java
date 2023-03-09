package ru.skillbox.mapper;

import javax.annotation.processing.Generated;
import ru.skillbox.enums.CommentType;
import ru.skillbox.model.PostComment;
import ru.skillbox.repository.PostCommentRepository;
import ru.skillbox.response.post.PostCommentDto;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-03-09T10:28:01+0300",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 19 (Oracle Corporation)"
)
public class PostCommentMapperImpl implements PostCommentMapper {

    @Override
    public PostCommentDto postCommentToPostCommentDto(PostComment comment, long currentUserId, PostCommentRepository postCommentRepository, boolean isTest) {
        if ( comment == null ) {
            return null;
        }

        PostCommentDto postCommentDto = new PostCommentDto();

        postCommentDto.setTime( mapTime( comment.getTime(), isTest ) );
        postCommentDto.setAuthorId( mapAuthorId( comment.getPerson() ) );
        postCommentDto.setCommentsCount( mapCommentsCount( comment.getId(), postCommentRepository ) );
        postCommentDto.setLikeAmount( mapLikeAmount( comment.getCommentLikes() ) );
        postCommentDto.setMyLike( mapMyLike( comment.getCommentLikes(), currentUserId ) );
        if ( comment.getPost() != null ) {
            postCommentDto.setPostId( mapPostId( comment.getPost() ).intValue() );
        }
        postCommentDto.setIsDelete( comment.getIsDelete() );
        postCommentDto.setId( comment.getId() );
        if ( comment.getCommentType() != null ) {
            postCommentDto.setCommentType( Enum.valueOf( CommentType.class, comment.getCommentType() ) );
        }
        if ( comment.getTimeChanged() != null ) {
            postCommentDto.setTimeChanged( String.valueOf( comment.getTimeChanged() ) );
        }
        postCommentDto.setParentId( comment.getParentId() );
        postCommentDto.setCommentText( comment.getCommentText() );
        postCommentDto.setIsBlocked( comment.getIsBlocked() );

        return postCommentDto;
    }
}
