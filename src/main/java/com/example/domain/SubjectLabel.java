package com.example.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Table(name = "subject_label")
@Entity
@NamedQuery(name = "SubjectLabel.findByName", query = "select s from SubjectLabel s where s.name=?1")
public class SubjectLabel implements Serializable
{

    @Id
    private long id;

    @Column(name = "name")
    private String name;

    @Column(name = "userId")
    private String userId;

    @Column(name = "industryId")
    private long industryId;

    @Column(name = "weight")
    private float weight;

    @Column(name = "frequentUsed")
    private short frequentUsed;

    @Column(name = "abroadType")
    private short abroadType;

    @Column(name = "deletedAt")
    private String deletedAt;

    @Column(name = "createdAt")
    private String createdAt;

    @Column(name = "updatedAt")
    private String updatedAt;

    @Column(name = "productScore")
    private String productScore;

    @Column(name = "highestAdLevel")
    private String highestAdLevel;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public long getIndustryId() {
        return industryId;
    }

    public void setIndustryId(long industryId) {
        this.industryId = industryId;
    }

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }

    public short getFrequentUsed() {
        return frequentUsed;
    }

    public void setFrequentUsed(short frequentUsed) {
        this.frequentUsed = frequentUsed;
    }

    public short getAbroadType() {
        return abroadType;
    }

    public void setAbroadType(short abroadType) {
        this.abroadType = abroadType;
    }

    public String getDeletedAt() {
        return deletedAt;
    }

    public void setDeletedAt(String deletedAt) {
        this.deletedAt = deletedAt;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    public String getProductScore() {
        return productScore;
    }

    public void setProductScore(String productScore) {
        this.productScore = productScore;
    }

    public String getHighestAdLevel() {
        return highestAdLevel;
    }

    public void setHighestAdLevel(String highestAdLevel) {
        this.highestAdLevel = highestAdLevel;
    }

    @Override
    public String toString() {
        return "SubjectLabel{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", userId='" + userId + '\'' +
                ", industryId=" + industryId +
                ", weight=" + weight +
                ", frequentUsed=" + frequentUsed +
                ", abroadType=" + abroadType +
                ", deletedAt='" + deletedAt + '\'' +
                ", createdAt='" + createdAt + '\'' +
                ", updatedAt='" + updatedAt + '\'' +
                ", productScore='" + productScore + '\'' +
                ", highestAdLevel=" + highestAdLevel +
                '}';
    }
}
