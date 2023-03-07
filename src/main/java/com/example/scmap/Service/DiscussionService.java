package com.example.scmap.Service;

import com.example.scmap.Entity.Discussion;
import com.example.scmap.Mapper.DiscussionMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

@Repository
public class DiscussionService {

    @Autowired
    private DiscussionMapper discussionMapper;

    public List<Discussion> getDiscussionListByTextId(Long textId){
        Example example = new Example(Discussion.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("textId",textId);
        List<Discussion> discussionList = discussionMapper.selectByExample(example);
        return discussionList;
    }

    public List<String> getDiscussionListByTextName(String textName){
        return discussionMapper.getDiscussionListByTextName(textName);
    }
}
