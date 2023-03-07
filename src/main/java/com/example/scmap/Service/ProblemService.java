package com.example.scmap.Service;

import com.example.scmap.DTO.text.ProblemList;
import com.example.scmap.DTO.text.TextProblemList;
import com.example.scmap.Entity.Problem;
import com.example.scmap.Entity.Text;
import com.example.scmap.Mapper.ProblemMapper;
import com.example.scmap.Mapper.TextMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.entity.Example;

import java.util.LinkedList;
import java.util.List;

@Repository
public class ProblemService {

    @Autowired
    private ProblemMapper problemMapper;

    @Autowired
    private TextMapper textMapper;

    @Autowired
    private TextService textService;

    public List<Problem> getTextProblemsById(Long textId){
        Example problemExample = new Example(Problem.class);
        Example.Criteria criteria = problemExample.createCriteria();
        criteria.andEqualTo("textId",textId);
        return problemMapper.selectByExample(problemExample);
    }

    public TextProblemList getTextProblemsByName(String textName){
        Text text = textService.getTextByTextName(textName);
        Example problemExample = new Example(Problem.class);
        Example.Criteria problemCriteria = problemExample.createCriteria();
        problemCriteria.andEqualTo("textId",text.getTextId());
        List<Problem> problemList = problemMapper.selectByExample(problemExample);
        List<String> moxie = new LinkedList<>();
        List<String> moxieAnswer = new LinkedList<>();
        List<String> zhushi = new LinkedList<>();
        List<String> zhushiAnswer = new LinkedList<>();
        List<String> juzi = new LinkedList<>();
        List<String> juziAnswer = new LinkedList<>();
        for(Problem problem:problemList){
            if(problem.getType()==0){
                moxie.add(problem.getTitle());
                moxieAnswer.add(problem.getAnswer());
            }
            else if(problem.getType()==1){
                zhushi.add(problem.getTitle());
                zhushiAnswer.add(problem.getAnswer());
            }
            else if(problem.getType()==2){
                juzi.add(problem.getTitle());
                juziAnswer.add(problem.getAnswer());
            }
        }
        ProblemList moxieList = ProblemList.builder().problems(moxie).answers(moxieAnswer).build();
        ProblemList zhushiList = ProblemList.builder().problems(zhushi).answers(zhushiAnswer).build();
        ProblemList juziList = ProblemList.builder().problems(juzi).answers(juziAnswer).build();
        return TextProblemList.builder().moxie(moxieList).zhushi(zhushiList).juzi(juziList).build();
    }
}
