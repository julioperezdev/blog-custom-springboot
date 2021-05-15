package dev.protobot.blogcustom.mapper;
import dev.protobot.blogcustom.dto.SubredditDto;
import dev.protobot.blogcustom.model.Post;
import dev.protobot.blogcustom.model.Subreddit;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;


import java.util.List;

@Mapper(componentModel = "spring")
public interface SubredditMapper{

    @Mapping(target = "numberOfPost",
            expression = "java(mapPosts(subreddit.getPosts()))")
    SubredditDto mapSubredditToDto(Subreddit subreddit);

    default Integer mapPosts(List<Post> numberOfPosts){
        return numberOfPosts.size();
    }

    @InheritInverseConfiguration
    @Mapping(target = "posts", ignore = true)
    Subreddit mapDtoToSubreddit(SubredditDto subredditDto);

}
