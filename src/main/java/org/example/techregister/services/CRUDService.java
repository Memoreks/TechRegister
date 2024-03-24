package org.example.techregister.services;

import org.example.techregister.dto.TechnicDto;

import java.util.Collection;

public interface CRUDService<T> {
    T getById(Integer id);
    Collection<T> getAll();
    void create(T item);
    void update(T item);
    void delete(Integer id);
}
