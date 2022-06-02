package com.pluralsight.conference.demo.controllers;

import com.pluralsight.conference.demo.models.Tag;
import com.pluralsight.conference.demo.repositories.ITagRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/tag")
public class TagController {
    @Autowired
    private ITagRepository tagRepository;

    @GetMapping
    public List<Tag> list(@RequestParam(required = false) String name) {
        if (name != null) {
            return tagRepository.findByDescriptionContains(name);
        } else {
            return tagRepository.findAll();
        }
    }

    @GetMapping
    @RequestMapping("{id}")
    public Tag get(@PathVariable Long id) {
        return tagRepository.getById(id);
    }

    @PostMapping
    public Tag create(@RequestBody final Tag tag){
        return tagRepository.saveAndFlush(tag);
    }
}
