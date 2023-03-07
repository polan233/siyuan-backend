package com.example.scmap.Service;

import com.example.scmap.Common.CommonErrorCode;
import com.example.scmap.Common.CommonException;
import com.example.scmap.DTO.text.TextItem;
import com.example.scmap.Entity.Author;
import com.example.scmap.Entity.Text;
import com.example.scmap.Mapper.AuthorMapper;
import com.example.scmap.Mapper.TextMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

@Service
public class TextService {

    @Autowired
    private TextMapper textMapper;

    @Autowired
    private AuthorMapper authorMapper;

    public Text getTextByTextName(String textName){
        Example textExample = new Example(Text.class);
        Example.Criteria criteria =  textExample.createCriteria();
        criteria.andEqualTo("textName",textName);
        List<Text> textList = textMapper.selectByExample(textExample);
        if(textList.size()>1)throw new CommonException(CommonErrorCode.OBJECT_NOT_UNIQUE);
        else if (textList.size()==0)throw new CommonException(CommonErrorCode.OBJECT_NOT_EXIST);
        return textList.get(0);
    }

    public Author getTextAuthorByName(String textName){
        Text text = getTextByTextName(textName);
        Long authorId = text.getAuthorId();
        return authorMapper.getAuthorById(authorId);
    }

    public Text getTextInformationByName(String textName){
        return getTextByTextName(textName);
    }

    public Map<String,List<TextItem>> getSlideBarTextList(){
        List<TextItem> textList =  textMapper.getTextList();
        Map<String,List<TextItem>> result = new HashMap<>();
        for(TextItem textItem:textList){
            List<TextItem> temp = result.getOrDefault(textItem.getTextbook(),new LinkedList<>());
            temp.add(textItem);
            result.put(textItem.getTextbook(),temp);
        }
        return result;
    }

    public List<TextItem> getTextList(){
        return textMapper.getTextList();
    }

    public Boolean getTextTypeById(Long id){
        Text text =  textMapper.selectByPrimaryKey(id);
        if(text==null)throw new CommonException(CommonErrorCode.OBJECT_NOT_EXIST);
        return text.getType().equals('1');
    }

    public Boolean getTextTypeByName(String textName){
        return getTextByTextName(textName).getType().equals("1");
    }

    public String getTextContentByName(String textName){
        return getTextByTextName(textName).getContent();
    }






}
