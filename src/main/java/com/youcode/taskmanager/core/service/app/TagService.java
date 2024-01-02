package com.youcode.taskmanager.core.service.app;

import com.youcode.taskmanager.core.database.model.entity.Tag;

import java.util.UUID;

public interface TagService extends CrudService<Tag, UUID> {

    Tag findByName(String name);

}
