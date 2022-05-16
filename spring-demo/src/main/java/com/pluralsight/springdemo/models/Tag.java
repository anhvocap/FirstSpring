package com.pluralsight.springdemo.models;

import javax.persistence.*;

@Entity
@Table(name = "tags")
public class Tag {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="tag_id")
    private Long tag_id;

    @Column(name="tag_id", insertable = false, updatable = false)
    private Long TagId;

    @Column(name="description")
    private String description;

    public Tag() {

    }

    public Long getTagId() {
        return TagId;
    }

    public void setTagId(Long tagId) {
        TagId = tagId;
    }

    public Long getTag_id() {
        return tag_id;
    }

    public void setTag_id(Long tag_id) {
        this.tag_id = tag_id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
