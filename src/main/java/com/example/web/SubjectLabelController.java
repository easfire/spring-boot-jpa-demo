package com.example.web;

import com.example.domain.SubjectLabel;
import com.example.service.ISubjectLabelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


@RestController
@RequestMapping(value = "/subjectLabels")
public class SubjectLabelController
{
    @Autowired
    private ISubjectLabelService subjectLabelService;

    private String dateNowStr;

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public SubjectLabel addSubjectLabel(
            @RequestParam(value = "name") String name,
            @RequestParam(value = "userId") String userId,
            @RequestParam(value = "industryId", required = false) long industryId,
            @RequestParam(value = "weight", required = false) float weight,
            @RequestParam(value = "frequentUsed", required = false) short frequentUsed,
            @RequestParam(value = "abroadType", required = false) short abroadType

    ){
        SubjectLabel subjectLabel = new SubjectLabel();
        subjectLabel.setName(name);
        subjectLabel.setUserId(userId);
        subjectLabel.setIndustryId(industryId);
        subjectLabel.setWeight(weight);
        subjectLabel.setFrequentUsed(frequentUsed);
        subjectLabel.setAbroadType(abroadType);

        Date date = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        this.dateNowStr = dateFormat.format(date);

        subjectLabel.setCreatedAt(this.dateNowStr);
        subjectLabel.setUpdatedAt(this.dateNowStr);
        subjectLabelService.saveSubjectLabel(subjectLabel);

        return subjectLabel;
    }

    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public void deleteSubjectLabel(@RequestParam(value = "id") long id){
        subjectLabelService.delete(id);
    }

    @RequestMapping(value = "/list")
    public List<SubjectLabel> getSubjectLabel(){
        return subjectLabelService.findAll();
    }

    @RequestMapping(value = "/get", method = RequestMethod.GET)
    public SubjectLabel getSubjectLabelById(@RequestParam(value = "id") long id){
        SubjectLabel subjectLabel = subjectLabelService.findOne(id);
        return subjectLabel;
    }

    @RequestMapping(value = "/search/name", method = RequestMethod.GET)
    public List<SubjectLabel> getSubjectLabelByName(@RequestParam(value = "name") String name){
        List<SubjectLabel> subjectLabelList = subjectLabelService.findByName(name);
        return subjectLabelList;
    }
}
