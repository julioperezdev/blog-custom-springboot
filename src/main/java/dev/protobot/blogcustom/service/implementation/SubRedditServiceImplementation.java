package dev.protobot.blogcustom.service.implementation;

import dev.protobot.blogcustom.dto.SubredditDto;
import dev.protobot.blogcustom.mapper.SubredditMapper;
import dev.protobot.blogcustom.model.Subreddit;
import dev.protobot.blogcustom.respository.SubredditRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class SubRedditServiceImplementation {

    private final SubredditRepository subredditRepository;
    private final SubredditMapper subredditMapper;


    @Autowired
    public SubRedditServiceImplementation(SubredditRepository subredditRepository,
                                          SubredditMapper subredditMapper) {
        this.subredditRepository = subredditRepository;
        this.subredditMapper = subredditMapper;
    }


    @Transactional
    public SubredditDto saveSubredditDto(SubredditDto subredditDto){
        SubredditDto subredditDtoSaved = subredditRepository.saveSubredditDto(
                subredditDto.getName(),
                subredditDto.getDescription());
        //subRedditRequest.setId(save.getId());
        return subredditDtoSaved;
    }

    @Transactional(readOnly = true)
    public List<SubredditDto> getAllSubredditDto (){
        return subredditRepository.getAllSubredditDto();
    }

    //-------------------------------------------------------

    @Transactional
    public SubredditDto saveSubreddit(SubredditDto subredditDto){
        Subreddit subredditMapped = subredditMapper.mapDtoToSubreddit(subredditDto);

        Subreddit subredditSaved = subredditRepository.saveSubreddit(
                subredditMapped.getName(),
                subredditMapped.getDescription());
        //subRedditRequest.setId(save.getId());
        return subredditDto;
    }

    @Transactional(readOnly = true)
    public List<SubredditDto> getAllSubreddit (){
        List<SubredditDto> allStudents = subredditRepository.getAllSubreddit()
                .stream()
                .map(subredditMapper::mapSubredditToDto)
                .collect(Collectors.toList());
        System.out.println(allStudents);
        return allStudents;
    }

    @Transactional(readOnly = true)
    public List<Subreddit> getAllSubreddit2 (){
        List<Subreddit> allStudents = subredditRepository.getAllSubreddit();

        return allStudents;
    }



}
