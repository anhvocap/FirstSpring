package com.pluralsight.springdemo.controllers;

import com.pluralsight.springdemo.models.Speaker;
import com.pluralsight.springdemo.models.Tag;
import com.pluralsight.springdemo.repositories.TagRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/tag")
public class TagController {
    @Autowired
    private TagRepository tagRepository;

    @GetMapping
    public List<Tag> list() {
        List<Tag> tags = tagRepository.findAll();
        System.out.println("tags:" + tags.stream().count());
        return tags;
    }

    @GetMapping
    @RequestMapping("{id}")
    public Tag item(@PathVariable Long id) {
        Tag tag = tagRepository.findItem(id);
        System.out.println("tag:" + tag.getTag_id() + " desc:" + tag.getDescription());
        return tag;
    }
}
