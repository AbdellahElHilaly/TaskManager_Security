package com.youcode.taskmanager.core.service.app.impl;

import com.youcode.taskmanager.core.database.model.entity.Tag;
import com.youcode.taskmanager.core.database.repository.TagRepository;
import com.youcode.taskmanager.core.service.app.TagService;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class TagServiceImpl implements TagService {

    private final TagRepository tagRepository;
    @Override
    public Tag save(Tag tag) {
        return tagRepository.save(tag);
    }

    @Override
    public Tag findById(UUID uuid) {
        return findByIdOrThrow(uuid);
    }

    @Override
    public Tag update(UUID id, Tag tag) {
        findByIdOrThrow(id);
        tag.setId(id);
        return tagRepository.save(tag);
    }

    @Override
    public void deleteById(UUID uuid) {
        tagRepository.delete(findByIdOrThrow(uuid));
    }

    @Override
    public List<Tag> findAll() {
        return tagRepository.findAll();
    }

    private Tag findByIdOrThrow(UUID uuid) {
        return tagRepository.findById(uuid).orElseThrow(
                () -> new EntityNotFoundException("Tag not found with id: " + uuid)
        );
    }

    @Override
    public Tag findByName(String name) {
        return tagRepository.findByName(name).orElse(null);
    }
}
