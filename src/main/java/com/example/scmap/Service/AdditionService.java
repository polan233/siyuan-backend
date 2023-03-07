package com.example.scmap.Service;

import com.example.scmap.Common.CommonErrorCode;
import com.example.scmap.Common.CommonException;
import com.example.scmap.DTO.text.TextContent;
import com.example.scmap.Entity.Addition;
import com.example.scmap.Entity.Text;
import com.example.scmap.Mapper.AdditionMapper;
import com.example.scmap.Mapper.TextMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

@Repository
public class AdditionService {

    @Autowired
    private TextMapper textMapper;

    @Autowired
    private AdditionMapper additionMapper;

    public TextContent getTextContentById(Long textId){
        Text text = textMapper.selectByPrimaryKey(textId);
        if(text==null)throw new CommonException(CommonErrorCode.OBJECT_NOT_EXIST);
        Example additionExample = new Example(Addition.class);
        Example.Criteria criteria = additionExample.createCriteria();
        criteria.andEqualTo("textId",textId);
        List<Addition> additions = additionMapper.selectByExample(additionExample);
        return TextContent.builder().textId(textId).textName(text.getTextName()).type(text.getType()).additions(additions).build();
    }

    public TextContent getTextContentByName(String textName){
        Example textExample = new Example(Text.class);
        Example.Criteria criteria =  textExample.createCriteria();
        criteria.andEqualTo("textName",textName);
        List<Text> textList = textMapper.selectByExample(textExample);
        if(textList.size()>1)throw new CommonException(CommonErrorCode.OBJECT_NOT_UNIQUE);
        else if(textList.size()==1){
            Text text = textList.get(0);
            Example additionExample = new Example(Addition.class);
            Example.Criteria additionCriteria = additionExample.createCriteria();
            additionCriteria.andEqualTo("textId",text.getTextId());
            List<Addition> additions = additionMapper.selectByExample(additionExample);
            return TextContent.builder().textId(text.getTextId()).textName(text.getTextName()).type(text.getType()).additions(additions).build();
        }
        else throw new CommonException(CommonErrorCode.OBJECT_NOT_EXIST);
    }
}
