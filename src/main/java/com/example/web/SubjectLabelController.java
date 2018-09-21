package com.example.web;

import com.example.domain.SubjectLabel;
import com.example.service.ISubjectLabelService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;


@RestController
@RequestMapping(value = "/subjectLabels")
public class SubjectLabelController
{
    @Autowired
    private ISubjectLabelService subjectLabelService;

    @PersistenceUnit
    private EntityManagerFactory emf;

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public SubjectLabel addSubjectLabel(
            @RequestParam(value = "id", required = false) Long id,
            @RequestParam(value = "name") String name,
            @RequestParam(value = "userId") String userId,
            @RequestParam(value = "industryId", required = false, defaultValue = "0") long industryId,
            @RequestParam(value = "weight", required = false, defaultValue = "0") float weight,
            @RequestParam(value = "frequentUsed", required = false, defaultValue = "0") short frequentUsed,
            @RequestParam(value = "abroadType", required = false, defaultValue = "0") short abroadType

    ){
        SubjectLabel subjectLabel = new SubjectLabel();
        if(id != null){
            subjectLabel.setId(id);
        }
        subjectLabel.setName(name);
        subjectLabel.setUserId(userId);
        System.out.println("industryId: "+industryId);
        if(industryId != 0){
            subjectLabel.setIndustryId(industryId);
        }
        if(weight != 0){
            subjectLabel.setWeight(weight);
        }
        if(frequentUsed != 0){
            subjectLabel.setFrequentUsed(frequentUsed);
        }
        if(abroadType != 0){
            subjectLabel.setAbroadType(abroadType);
        }

        Date date = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String dateNowStr = dateFormat.format(date);

        subjectLabel.setCreatedAt(dateNowStr);
        subjectLabel.setUpdatedAt(dateNowStr);
        subjectLabelService.saveSubjectLabel(subjectLabel);

        return subjectLabel;
    }

    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public void deleteSubjectLabel(@RequestParam(value = "id") long id){
        subjectLabelService.delete(id);
    }

    @RequestMapping(value = "/list")
    public List<SubjectLabel> getSubjectLabel(){
        List<SubjectLabel> list = subjectLabelService.findAll();
        System.out.println(list);

        for (SubjectLabel item : list){
            System.out.println(item);
        }


        ObjectMapper oMapper = new ObjectMapper();

        for (SubjectLabel item : list){
            Map<String, Object> map = oMapper.convertValue(item, Map.class);
            System.out.println(map);
        }
        return list;
    }

    @RequestMapping(value = "/get", method = RequestMethod.GET)
    public SubjectLabel getSubjectLabelById(@RequestParam(value = "id") long id){
        SubjectLabel subjectLabel = subjectLabelService.findOne(id);
        return subjectLabel;
    }

    @RequestMapping(value = "/search/name", method = RequestMethod.GET)
    public List<SubjectLabel> getSubjectLabelByName(@RequestParam(value = "name") String name){
        List<SubjectLabel> subjectLabelList = subjectLabelService.findByName(name);
        System.out.println(subjectLabelList);
        return subjectLabelList;
    }

    @RequestMapping(value = "/getJoinUser", method = RequestMethod.GET)
    public List getSlByItem(@RequestParam(value = "id") Long id){
        EntityManager em = emf.createEntityManager();
        List arrJoin = em.createQuery("select s.id, u.name, u.address from SubjectLabel s, User u " +
                "where s.userId=u.id")
                        .getResultList();
        System.out.println("out is " + arrJoin);
        return arrJoin;
    }
}
