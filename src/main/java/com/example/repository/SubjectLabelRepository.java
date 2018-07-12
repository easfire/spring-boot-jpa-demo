package com.example.repository;

import com.example.domain.SubjectLabel;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface SubjectLabelRepository extends Repository<SubjectLabel, Long>
{
    List<SubjectLabel> findByNameAndUserId(String name, String userId);

    @Query(value = "from SubjectLabel s where s.name=:name")
    List<SubjectLabel> findByName1(@Param("name") String name);

    @Query(value = "select * from #{#entityName} s where s.name=?1", nativeQuery = true)
    List<SubjectLabel> findByName2(String name);

    List<SubjectLabel> findByName(String name);
}
