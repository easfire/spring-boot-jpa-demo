package com.example.service;

import java.util.List;

import com.example.domain.SubjectLabel;

public interface ISubjectLabelService
{
    public List<SubjectLabel> findAll();

    public void saveSubjectLabel(SubjectLabel subjectLabel);

    public SubjectLabel findOne(long id);

    public void delete(long id);

    public List<SubjectLabel> findByName(String name);
}
