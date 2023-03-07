package com.example.scmap.Service;

import com.example.scmap.Common.CommonErrorCode;
import com.example.scmap.Common.CommonException;
import com.example.scmap.DTO.event.EventItem;
import com.example.scmap.Entity.*;
import com.example.scmap.Mapper.AuthorMapper;
import com.example.scmap.Repository.AuthorRepository;
import com.example.scmap.Mapper.CityMapper;
import com.example.scmap.Mapper.EventMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.entity.Example;

import java.util.LinkedList;
import java.util.List;

@Repository
public class AuthorService {

    @Autowired
    private AuthorMapper authorMapper;

    @Autowired
    private AuthorRepository authorRepository;

    @Autowired
    private EventMapper eventMapper;

    @Autowired
    private CityMapper cityMapper;

    public Author getAuthorByAuthorName(String authorName){
        Example authorExample = new Example(Author.class);
        Example.Criteria criteria =  authorExample.createCriteria();
        criteria.andEqualTo("authorName",authorName);
        List<Author> authorList = authorMapper.selectByExample(authorExample);
        if(authorList.size()>1)throw new CommonException(CommonErrorCode.OBJECT_NOT_UNIQUE);
        else if (authorList.size()==0)throw new CommonException(CommonErrorCode.OBJECT_NOT_EXIST);
        return authorList.get(0);
    }

    public String addAuthorsToNeo4j(){
        List<Author> authorList= authorMapper.selectAll();
        List<Author> insertList = new LinkedList<>();
        for(Author author : authorList){
            insertList.add(author);
        }
        authorRepository.saveAll(insertList);
        return "success";
    }

    public List<EventItem> getAuthorPath(String authorName){
        Author author = getAuthorByAuthorName(authorName);
        Long authorId = author.getAuthorId();
        List<EventItem> path = eventMapper.getAuthorPathBC(authorId);
        path.addAll(eventMapper.getAuthorPathNotBC(authorId));
        return path;
    }

}
