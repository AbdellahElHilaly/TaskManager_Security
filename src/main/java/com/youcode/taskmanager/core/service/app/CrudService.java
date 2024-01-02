package com.youcode.taskmanager.core.service.app;

import java.util.List;

public interface CrudService <T,ID> {
    T save(T t);
    T findById(ID id);
    T update(ID id, T t);
    void deleteById(ID id);

    List<T> findAll();
}
