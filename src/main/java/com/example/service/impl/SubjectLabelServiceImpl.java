package com.example.service.impl;

import com.example.domain.SubjectLabel;
import com.example.repository.SubjectLabelJpaRepository;
import com.example.repository.SubjectLabelRepository;
import com.example.service.ISubjectLabelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class SubjectLabelServiceImpl implements ISubjectLabelService
{
    @Autowired
    private SubjectLabelJpaRepository subjectLabelJpaRepository;

    @Autowired
    private SubjectLabelRepository subjectLabelRepository;

    public List<SubjectLabel> findAll() {
        return subjectLabelJpaRepository.findAll();
    }

    public List<SubjectLabel> findByName(String name){
        List<SubjectLabel> subjectLabelList1 = subjectLabelRepository.findByName1(name);
        List<SubjectLabel> subjectLabelList2 = subjectLabelRepository.findByName2(name);
        List<SubjectLabel> subjectLabelList3 = subjectLabelRepository.findByNameAndUserId(name, "");
        System.out.println("subjectLabel1:" + subjectLabelList1);
        System.out.println("subjectLabel2:" + subjectLabelList2);
        System.out.println("subjectLabel3:" + subjectLabelList3);

        return subjectLabelRepository.findByName(name);
    }

    @Override
    public void saveSubjectLabel(SubjectLabel subjectLabel) {
        subjectLabelJpaRepository.save(subjectLabel);
    }

    @Cacheable("SubjectLabel")
    public SubjectLabel findOne(long id)
    {
        System.out.println("Cached Pages");
        return subjectLabelJpaRepository.findOne(id);
    }

    @Override
    public void delete(long id) {
        subjectLabelJpaRepository.delete(id);
    }
}
